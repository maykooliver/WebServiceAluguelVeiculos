/**
 * TODAS AS FUNCIONALIDADES PEDIDAS ESTÃO FUNCIONANDO, PORÉM HÁ BUGS
 * RELACIONADOS A FUNCIONALIDADES SUPÉRFLUAS.
 * 
 * LISTA DE BUGS:
 * Edição de veículo passível de erros.
 *  Ao editar um segundo veículo, onde há dois veiculos na lista, esse segundo
 *  veículo substituirá o primeiro.
 */

package aluguelveiculosutf.impl;

import aluguelveiculosutf.interfaces.InterfaceCli;
import aluguelveiculosutf.interfaces.InterfaceServ;
import aluguelveiculosutf.servidor.Interessado;
import aluguelveiculosutf.servidor.Locador;
import aluguelveiculosutf.servidor.ServicosServ;
import static aluguelveiculosutf.servidor.ServicosServ.listaVeiculo;
import aluguelveiculosutf.servidor.Veiculo;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ{
    
    public static ArrayList<Locador> listaLocadores;
    public static ArrayList<Interessado> listaInteressados;
    
    /**
     * Implementação do servidor.
     * Construtor.
     * @throws RemoteException
     * @throws AlreadyBoundException 
     */
    public ServImpl() throws RemoteException, AlreadyBoundException
    {
        listaLocadores = new ArrayList<>();
        listaInteressados = new ArrayList<>();

       try{
            //Cria o registro para receber as referencias, para a porta 1099, local
            Registry referenciaServicoNome = LocateRegistry.createRegistry(1099);

            //A classe é associada a um nome para ser acessado externamente
            //(Registra uma referencia de objeto remoto)
            referenciaServicoNome.rebind("Locacao de Veiculos", this);

            //Inicia o array de clientes.
            //contas = new ArrayList<>();

            System.out.println("Serviços de locação de veículos iniciado..\n");
            
        }catch(RemoteException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }        
    }

     @Override
    public boolean alugarVeic(String modeloVeiculoLocado, String locRetirada, String locDevolucao, String dataIni, String horaInicio, String dataTerm, String horaFim, String condutor, int idade, String numeroParcelas, InterfaceCli ref) throws RemoteException {

        Locador locador = new Locador(modeloVeiculoLocado, locRetirada, locDevolucao, dataIni, horaInicio, dataTerm, horaFim, condutor, idade, numeroParcelas, ref) ;
        
        listaLocadores.add(locador);

        int indice = 0;
        
        for (Veiculo veiculo: listaVeiculo){
            if(veiculo.getModelo().equals(modeloVeiculoLocado)){
                indice =+1; //Apenas para corrigir bug do editarVeiculo
                veiculo.setOcupado(true);
                ServicosServ.editarVeiculo(indice, true, veiculo);
            }else{
                indice ++;
            }
        }
        
        return true;
    }

    @Override
    public boolean regInteresseVeic(String modeloVeic, float valor, InterfaceCli ref) throws RemoteException {
        Interessado inter = new Interessado(modeloVeic, valor, ref);
        listaInteressados.add(inter);
        return true;
    }

    @Override
    public boolean solicitacaoFormLocacao(String modeloVeic, InterfaceCli ref) throws RemoteException {
        int indice = 0;
        
        for (Veiculo veiculo: listaVeiculo){
            if(veiculo.getModelo().equals(modeloVeic)){
                if(!veiculo.isOcupado()){
                    return true;
                }else{
                    return false;
                }
            }else{
                indice ++;
            }
        }
        
        return false;
    }

    @Override
    public boolean devolverVeiculo(String nomeCli, InterfaceCli ref) throws RemoteException {
        
        try {
            int indice = 0;
            
            String modelo = null;
            
            for (Locador loc : listaLocadores) {
                System.out.println("locador:" + loc.getNomeCondutor());
                System.out.println("modelo: " + loc.getModeloVeiculoLocado());
                if (loc.getNomeCondutor().equals(nomeCli)) {
                    modelo = loc.getModeloVeiculoLocado();
                    loc.setLocacaoFinalizada(true);
                } 
                indice++;
            }
            
            indice = 0;
            
            for (Veiculo veiculo : listaVeiculo) {
                System.out.println("Veiculo modelo: " + veiculo.getModelo());
                System.out.println("Modelo: " + modelo);
                if(veiculo.getModelo().equals(modelo)) {
                    indice =+ 1; //Necessário para corrigir o bug de editarVeiculo;
                    System.out.println("Ocupado? " + veiculo.isOcupado());
                    veiculo.setOcupado(false);
                    System.out.println("Devolver Veiculo: " + veiculo.getModelo());
                    System.out.println("Ocupado? " + veiculo.isOcupado());
                    ServicosServ.editarVeiculo(indice, true, veiculo);
                }
                indice++;
            }
            System.out.println("terminou o foreach de listaVeicuLOS");
            
            return true;
            
        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public void novoClienteConectado(String nomeCli) throws RemoteException{
        System.out.println("Novo cliente conectado: " + nomeCli);
    }

    @Override
    public ArrayList<Veiculo> consultarVeiculos() throws RemoteException {
        ArrayList<Veiculo> listaVeiculos;
        listaVeiculos = ServicosServ.getListaVeiculo();
        return listaVeiculos;
    }
    
    public static void notificarCarro(String modelo, InterfaceCli ref){
        InterfaceCli refCli = ref;
        String msg = "Carro " + modelo + " já está disponível na margem de valor desejado.";
        try {
            refCli.notifCarroDisp(msg);
        } catch (RemoteException ex) {
            Logger.getLogger(ServImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
