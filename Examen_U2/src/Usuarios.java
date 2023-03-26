import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private List<String> listaUsuarios;

    public Usuarios(String rutaArchivo) {
        this.listaUsuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                this.listaUsuarios.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getListaUsuarios(int indice) {
        return listaUsuarios.get(indice);
    }
    
    public int getTamañoLista() {
    	return listaUsuarios.size();
    }
}
