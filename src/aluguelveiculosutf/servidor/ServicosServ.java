package aluguelveiculosutf.servidor;

import aluguelveiculosutf.impl.ServImpl;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ServicosServ {

    private static ServicosServ instancia;
    public static ArrayList<Veiculo> listaVeiculo;


    private ServicosServ(){
        listaVeiculo = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public static ArrayList<Veiculo> getListaVeiculo() {
        return listaVeiculo;
    }

    /**
     *
     * @param listaVeiculo
     */
    public void setListaVeiculo(ArrayList<Veiculo> listaVeiculo) {
        ServicosServ.listaVeiculo = listaVeiculo;
    }

    /**
     *
     * @return
     */
    public static ServicosServ getInstancia() {
        if (instancia == null) {
            instancia = new ServicosServ();
        }
        return instancia;
    }

    /**
     *
     * @param veiculo
     */
    public void salvarVeiculo(Veiculo veiculo) {
        listaVeiculo.add(veiculo);
        Serializa serializa = new Serializa();
        String msg = "Veículo cadastrado com sucesso!";
        JOptionPane.showMessageDialog(null, msg);
        serializa.descerializaVeiculos(serializa.serializaVeiculos(listaVeiculo));
        
    }

    /**
     *
     * @param indice
     * @param reqCliente
     * @param veiculo
     */
    public static void editarVeiculo(int indice, boolean reqCliente, Veiculo veiculo) {
        indice = indice - 1;
        listaVeiculo.set(indice, veiculo);
        if(!reqCliente){
            String msg = "Veículo editado com sucesso!";
            JOptionPane.showMessageDialog(null, msg);
        }
        
        Serializa serializa = new Serializa();
        serializa.serializaVeiculos(listaVeiculo);
            
        int i = 0;
        
        for (Interessado inter : ServImpl.listaInteressados) {
            if (inter.getModeloVeic().equals(veiculo.getModelo())){
                if(inter.getValor() >= veiculo.getValorLocacao()){
                    ServImpl.notificarCarro(inter.getModeloVeic(), inter.getRefCli());
                    //ServImpl.listaInteressados.remove(i);
                }
            }
            i++;
        }
    }

    /**
     *
     * @param modeloVeiculo
     * @return
     */
    public static Veiculo buscarVeiculo(String modeloVeiculo) {
        Veiculo veiculo = null;
        try {
            veiculo = listaVeiculo.
                    stream().
                    filter(v -> (v.getModelo() == null ? modeloVeiculo == null
                                    : v.getModelo().equals(modeloVeiculo))).
                    findFirst().get();
        } catch (NoSuchElementException e) {
            String msg = "Veículo não cadastrado!";
            JOptionPane.showMessageDialog(null, msg);
        }

        return veiculo;
    }

}
