import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private List<String> listaUsuarios;
    private String rutaArchivo;
    public Usuarios(String rutaArchivo) {
    	this.rutaArchivo = rutaArchivo;
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
    
    public void añadirUsuario(String usuario, String nombre, 
    		String apellido, String correo, String contraseña) {
    	
    	try {
            //Crear objeto FileWriter con la opción para agregar contenido al final del archivo
            FileWriter fw = new FileWriter(rutaArchivo, true);
            //Crear objeto BufferedWriter para escribir el nuevo contenido
            BufferedWriter bw = new BufferedWriter(fw);
            //Escribir la nueva línea de texto
            bw.write("\n"+usuario+","+nombre+","+apellido+","+correo+","+contraseña);
            bw.newLine(); //Agregar salto de línea
            //Cerrar el BufferedWriter
            bw.close();    

        } catch (IOException e) {
            //Manejar cualquier error que pueda ocurrir
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public int getTamañoLista() {
    	return listaUsuarios.size();
    }
}
