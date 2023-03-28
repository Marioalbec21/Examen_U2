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
			//Pasa los datos de la linea de texto a un arreglo
			String[] datos = getListaUsuarios(i).split(",");
			
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
            String apellido, String correo, String contraseña, String confirmarContra) {
    	
    	boolean usuarioNuevo = false;
    	for(int i = 0; i < getTamañoLista(); i++) {
			//Pasa los datos de la linea de texto a un arreglo
			String[] datos = getListaUsuarios(i).split(",");
			
			if(!getListaUsuarios().toString().contains(correo)) {
				//Validaciones de registro de usuario
				if(!datos[0].equals(usuario)) {
					usuarioNuevo = true;
				}
				else {
			    	usuarioNuevo = false;
			    	JOptionPane.showMessageDialog(null, "Usuario ya existente.",
			  		          "Mensaje",JOptionPane.ERROR_MESSAGE);
					i = getTamañoLista();
				}
			}
			else {
		    		usuarioNuevo = false;
		        	JOptionPane.showMessageDialog(null, "Correo ya existente.",
			  		          "Mensaje",JOptionPane.ERROR_MESSAGE);
					i = getTamañoLista();
			}
    	}
    	if(usuarioNuevo) {
    		
    		//Valida que el usuario ingrese sus datos
    		if(!usuario.contains("Usuario") && 
    				!nombre.contains("Nombre") && 
    				!apellido.contains("Apellido") && 
    				!correo.contains("Correo")) {
    			
    			if(!usuario.contains(" ") && 
        				!nombre.contains(" ") && 
        				!apellido.contains(" ") && 
        				!correo.contains(" ") &&
    					!contraseña.contains(" ") &&
    					!confirmarContra.contains(" ")) {
    				
	    			//Valida las contraseñas
	    			if(!contraseña.contains("*") && !confirmarContra.contains("*")) {	
	    				
	    				//Valida que las contraseñas sean iguales
	    				if(contraseña.equals(confirmarContra)) {
	        				
	        				//Crea el nuevo usuario con los datos
	        				try {
	        		            //Crear FileWriter
	        		            FileWriter escribir = new FileWriter(rutaArchivo, true);
	        		            //Crear BufferedWriter 
	        		            BufferedWriter almacen = new BufferedWriter(escribir);
	
	        		            //Añadir al nuevo usuario
	        		            almacen.write(usuario+","+nombre+","+apellido+","+correo+","+contraseña);
	        		            almacen.newLine();
	        		            //Cerrar el BufferedWriter
	        		            almacen.close();
	        		            actualizarListaUsuarios();
	
	        		        } catch (IOException e) {
	
	        		            System.out.println("Error: " + e.getMessage());
	        		        }
	        				JOptionPane.showMessageDialog(null, "Usuario creado con éxito.",
	        		  		          "Mensaje",JOptionPane.INFORMATION_MESSAGE);
	        			}
	        			else {
	        				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.",
	        		  		          "Mensaje",JOptionPane.ERROR_MESSAGE);
	        			}
	    			}
	    			else {
	    				JOptionPane.showMessageDialog(null, "Porfavor escriba una contraseña.",
	  		  		          "Mensaje",JOptionPane.ERROR_MESSAGE);
	    			}
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "No puede haber espacios en blanco.",
	  		  		          "Mensaje",JOptionPane.ERROR_MESSAGE);
    			}
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "Porfavor escriba sus datos.",
    	  		          "Mensaje",JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }
	
    //Metodo para actualizar datos del usuario
  	public void actualizarDatos(String username, 
  			String nombre, String apellido, String email, String contraseña) {
  		boolean datosActualizados = false;
  		
  		//Valida que los datos no estén en blanco o sean iguales a sus nombres 
	    if (!nombre.contains(" ") && !nombre.contains("Nombre")) {
	    	for(int i = 0; i < getTamañoLista(); i++) {
		        String[] datos = getListaUsuarios(i).split(",");
		        
		        //Actualiza los datos del usuario
		        if(datos[0].equals(username)) {
		            setDatosUsuario(0, username);
		            setDatosUsuario(1, nombre);
		            
		            //Actualiza los datos del usuario en el users.txt
		            editarUsuario(i);
		            actualizarListaUsuarios();
		            
		            datosActualizados = true;
		        }
		    }	   
	    }
	    
	    if (!apellido.contains(" ") && !apellido.contains("Apellido")) {
	    	for(int i = 0; i < getTamañoLista(); i++) {
		        String[] datos = getListaUsuarios(i).split(",");
		        
		        //Actualiza los datos del usuario
		        if(datos[0].equals(username)) {
		            setDatosUsuario(0, username);
		            setDatosUsuario(2, apellido);

		            //Actualiza los datos del usuario en el users.txt
		            editarUsuario(i);
		            actualizarListaUsuarios();
		            
		            datosActualizados = true;
		        }
		    }
	    }
	    
	    if (!email.contains(" ") && !email.contains("Correo")) {
	    	if(!getListaUsuarios().toString().contains(email)) {
		    	for(int i = 0; i < getTamañoLista(); i++) {
			        String[] datos = getListaUsuarios(i).split(",");
			        	//Actualiza los datos del usuario
			        	if(datos[0].equals(username)) {
			        		setDatosUsuario(3, email);
			        		
			        		//Actualiza los datos del usuario en el users.txt
			        		editarUsuario(i);
			        		actualizarListaUsuarios();
			        		
			        		datosActualizados = true;
			        	}		        	
			        }
			}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Correo ya existente.",
	    				"Mensaje",JOptionPane.ERROR_MESSAGE);
	    	}
	    }
	    
	    if (!contraseña.contains(" ") && !contraseña.contains("*")) {
		    for(int i = 0; i < getTamañoLista(); i++) {
		        String[] datos = getListaUsuarios(i).split(",");
		        
		        //Actualiza los datos del usuario
		        if(datos[0].equals(username)) {
		            setDatosUsuario(4, contraseña);

		            //Actualiza los datos del usuario en el users.txt
		            editarUsuario(i);
		            actualizarListaUsuarios();

		            datosActualizados = true;
		        }
		    }
	    }
	    if(!datosActualizados) {
	    	JOptionPane.showMessageDialog(null, "Datos incorrectos.",
	  		          "Mensaje",JOptionPane.ERROR_MESSAGE);
	    }
	    else {
            JOptionPane.showMessageDialog(null, "Datos actualizados.",
            		"Mensaje",JOptionPane.INFORMATION_MESSAGE);
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