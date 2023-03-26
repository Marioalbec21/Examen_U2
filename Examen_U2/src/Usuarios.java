import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private List <String> listaUsuarios;
    private String rutaArchivo;

    //Arreglo de datos del usuario
  	private String[] datosUsuario = new String[5];
  	
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

    //Metodo que devuelve todos los datos del usuario de una linea del txt
    public String getListaUsuarios(int indice) {
        return listaUsuarios.get(indice);
    }

    public void añadirUsuario(String usuario, String nombre, 
            String apellido, String correo, String contraseña) {

        try {
            //Crear FileWriter
            FileWriter escribir = new FileWriter(rutaArchivo, true);
            //Crear BufferedWriter 
            BufferedWriter almacen = new BufferedWriter(escribir);

            //Añadir al nuevo usuario
            almacen.write("\n"+usuario+","+nombre+","+apellido+","+correo+","+contraseña);
            //Cerrar el BufferedWriter
            almacen.close();

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void editarUsuario(int indiceLinea) {
        try {
            FileReader leer = new FileReader(rutaArchivo);
            BufferedReader lector = new BufferedReader(leer);

            FileWriter escribir = new FileWriter(rutaArchivo + ".temp", true);
            BufferedWriter almacen = new BufferedWriter(escribir);

            //Lee el archivo línea por línea y reemplazar la línea
            String linea;
            int lineaActual = 0;
            while ((linea = lector.readLine()) != null) {
                if (lineaActual == indiceLinea) {
                    //Escribe la nueva línea con los datos actualizados
                    String nuevaLinea = String.join(",", datosUsuario);
                    almacen.write(nuevaLinea);
                    almacen.newLine();
                } else {
                    //Escribe la línea original
                	almacen.write(linea);
                	almacen.newLine();
                }
                lineaActual++;
            }

            leer.close();
            leer.close();
            almacen.close();
            escribir.close();
            
            File archivoOriginal = new File(rutaArchivo);
            File archivoTemp = new File(rutaArchivo + ".temp");
            archivoOriginal.delete();
            archivoTemp.renameTo(archivoOriginal);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //Metodo que devuelve el tamaño de la lista
    public int getTamañoLista() {
        return listaUsuarios.size();
    }
    
    //Metodo para obtener el dato del arreglo con un indice
	public String getDatosUsuario(int indice) {
		return datosUsuario[indice];
	}

	//Metodo para establecer los datos del arreglo
	public void setDatosUsuario(String[] datosUsuario) {
		this.datosUsuario = datosUsuario;
	}
	
	//Metodo para establecer los datos del arreglo con un indice y un string
	public void setDatosUsuario(int indice, String dato) {
		this.datosUsuario[indice] = dato;
	}
}