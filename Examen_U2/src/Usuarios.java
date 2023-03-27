import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuarios {
    private List <String> listaUsuarios;
    private String rutaArchivo;

    //Arreglo de datos del usuario
  	private String[] datosUsuario = new String[5];
  	
    public Usuarios(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.listaUsuarios = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                this.listaUsuarios.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo que regresa la lista completa de usuarios
    public List <String> getListaUsuarios() {
        return listaUsuarios;
    }
    
    //Metodo que devuelve todos los datos del usuario de una linea del txt
    public String getListaUsuarios(int indice) {
        return listaUsuarios.get(indice);
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
	
    //Actualiza la lista de la memoria del programa
    private void actualizarListaUsuarios() {
        listaUsuarios.clear();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                listaUsuarios.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	//Metodo para validar datos
	public boolean comprobarDatos(String usuario, String contraseña) {
		boolean datosCorrectos = false;
		
		for(int i = 0; i < getTamañoLista(); i++) {
			String[] datos = getListaUsuarios(i).split(",");
			
			//Pasa los datos de la linea de texto a un arreglo
			if(datos[0].equals(usuario)) {
				setDatosUsuario(getListaUsuarios(i).split(","));

				//Comprueba que el usuario y contraseña esten correctos
				if(usuario.equals(getDatosUsuario(0)) && 
						contraseña.equals(getDatosUsuario(4))) {
					datosCorrectos = true;
				}
				else {
					datosCorrectos = false;
				}
			}
		}
		return datosCorrectos;
	}
	
	//Metodo para añadir un nuevo usuario
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
            actualizarListaUsuarios();

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
    
    //Metodo para actualizar datos del usuario
  	public void actualizarDatos(String username, 
  			String nombre, String apellido, String email, String contraseña) {
  		
  		for(int i = 0; i < getTamañoLista(); i++) {
  			String[] datos = getListaUsuarios(i).split(",");
  			
  			//Actualiza los datos del usuario
  			if(datos[0].equals(username)) {
  				setDatosUsuario(0, username);
	  			setDatosUsuario(1, nombre);
	  			setDatosUsuario(2, apellido);
	  			setDatosUsuario(3, email);
	  			setDatosUsuario(4, contraseña);

  				//Actualiza los datos del usuario en el users.txt
  				editarUsuario(i);
  				actualizarListaUsuarios();
  			}
  		}
  	}
  	
  	//Metodo paea actualizar un usuario existente
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
}