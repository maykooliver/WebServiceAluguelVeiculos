package aluguelveiculosutf.interfaces;

import aluguelveiculosutf.servidor.Veiculo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public interface InterfaceServ extends Remote{
    
    /**
     * Devolver Veículo.
     * Realiza a solicitação para a devolução de um veículo.
     * @param nomeCli
     * @param ref
     * @return 
     * @throws java.rmi.RemoteException
     */
    public boolean devolverVeiculo(String nomeCli, InterfaceCli ref) throws RemoteException;

    /**
     * Alugar Veículo.
     * @param modeloVeiculoLocado
     * @param locRetirada
     * @param locDevolucao
     * @param dataIni
     * @param horaInicio
     * @param dataTerm
     * @param horaFim
     * @param condutor
     * @param idade
     * @param numeroParcelas
     * @param ref
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public boolean alugarVeic(String modeloVeiculoLocado, String locRetirada, String locDevolucao, String dataIni, String horaInicio, String dataTerm, String horaFim, String condutor, int idade, String numeroParcelas, InterfaceCli ref) throws RemoteException;

    /**
     * Registrar Interesse de Veículo.
     * @param modeloVeic
     * @param valor
     * @param ref
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public boolean regInteresseVeic(String modeloVeic, float valor, InterfaceCli ref) throws RemoteException;

    /**
     * Solicitar Formulário de Locação.
     * @param modeloVeic
     * @param ref
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public boolean solicitacaoFormLocacao(String modeloVeic, InterfaceCli ref) throws RemoteException;

    /**
     * Novo Cliente Conectado.
     * Informa que um novo cliente se conectou ao servidor.
     * @param nomeCli 
     * @throws java.rmi.RemoteException 
     */
    public void novoClienteConectado(String nomeCli) throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public ArrayList<Veiculo> consultarVeiculos() throws RemoteException;
    
}
