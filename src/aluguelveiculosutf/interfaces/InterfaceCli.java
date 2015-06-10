package aluguelveiculosutf.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucas
 */
public interface InterfaceCli extends Remote{
    
    /**
     * Notificação de carro disponível.
     * Se o cliente estiver habilitado para receber notificações automáticas,
     * quando o carro de interesse estiver disponível, ele receberá uma notificação.
     * Servidor - Cliente.
     * @param msg Mensagem do servidor.
     * @throws java.rmi.RemoteException
     */
    public void notifCarroDisp(String msg) throws RemoteException;
    
}
