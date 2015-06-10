package aluguelveiculosutf.servidor;

import com.google.gson.Gson;

import aluguelveiculosutf.servidor.Veiculo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Classe de terceiros adaptada.
 * @author Desconhecido.
 */
public class Serializa {

    public String serializaVeiculos(ArrayList<Veiculo> listaVeiculo){
        try {
            Gson gson = new Gson();
            String mensagem = gson.toJson(listaVeiculo);
            System.out.println("Serializando" + gson.toJson(listaVeiculo));
            return mensagem;
        } catch (Exception e) {
                e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Veiculo> descerializaVeiculos(String json){
        ArrayList<Veiculo> listaVeiculo = new ArrayList<>();
        try {
            Gson gson = new Gson();
            listaVeiculo = gson.fromJson(json, ArrayList.class);
            System.out.println("Descerializando" + listaVeiculo);            
            return listaVeiculo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }


}
