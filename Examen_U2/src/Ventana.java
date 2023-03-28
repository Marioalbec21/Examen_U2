//EXAMEN UNIDAD 2
//JOSÉ MIGUEL MENDOZA ANAYA
//MARIO ALBERTO CASTELLANOS

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	
	private int largo = 500;
	private int ancho = 600;
	private int contador = 0;
	
	//Menu del panel
	private Menu menu = new Menu();
	private Usuarios usuarios = new Usuarios("users.txt"); //Lee el archivo users.txt

	//Lista de usuarios del panel
	private Tabla tabla = new Tabla();;
	
	//Ruta de recursos (cambiar por "" si estas en mac)
	private String ruta = ""; 
	
	//Paneles de la aplicacion
	private Login login = new Login(ruta);
	private Inicio inicio = new Inicio(ruta);
	private Cuenta cuenta = new Cuenta(ruta);
	private Lista lista = new Lista(tabla);
	private Registro registro = new Registro(ruta);
	private Ayuda ayuda  = new Ayuda(ruta);
	
	public Ventana() {
		//Propiedades de la ventana
		super("Sistema");
		setSize(largo, ancho);
		setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setResizable(false);
		//Inicia Pantalla y login
		pantallaCarga();
	}
	
	public void mostrarLogin() {
	    add(login);
	    
	    //Boton acceder de login
	    login.getIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ingresando al sistema...",
						"Iniciando",JOptionPane.INFORMATION_MESSAGE);
				
				//Comprueba que el usuario y contraseña sean correctos
				if(usuarios.comprobarDatos(login.getUsuario(), login.getContraseña())) {
					//Remueve todos los paneles
					removerPaneles();
					//Remueve el actionListener del boton iniciar sesion
			        login.getIniciar().removeActionListener(this);
					//Añade el panel inicio
					add(inicio);
					//Pasa el nombre del usuario a la ventana inicio
					inicio.setNombreUsuario(usuarios.getDatosUsuario(1));
					//Repintar el menu
					añadirMenu();
					//Actualizar ventana
					actualizar();
				}
				else {
					JOptionPane.showMessageDialog(null, "El usuario o contraseña no coinciden...",
							"Ha habido un problema",JOptionPane.INFORMATION_MESSAGE);
				}
			}
	    });
	    
	    //Boton cancelar de login
	    login.getCancelar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login.vaciarDatos();
			}
	    });
	}
	
	boolean usuarioSeleccionado = false; //Variable que guarda si un usuario ha sido seleccionado de la lista
	public void mostrarCuenta() {
		add(cuenta);
		
		//Boton cancelar de cuenta
		cuenta.getCancelar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve todos los paneles
				removerPaneles();
				//Remueve el actionListener del boton cancelar
		        cuenta.getCancelar().removeActionListener(this);
				//Añade el panel inicio
				add(inicio);
				//Actualizar ventana
				actualizar();
			}
	    });
		
		//Boton actualizar de cuenta
		cuenta.getActualizar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve el actionListener del boton actualizar
		        cuenta.getActualizar().removeActionListener(this);
		        
		        if(!usuarioSeleccionado) {
		        	//Actualiza los datos del usuario que inicio sesion
		        	usuarios.actualizarDatos(login.getUsuario(), 
		        			cuenta.getNombre(), 
		        			cuenta.getApellido(),
		        			cuenta.getEmail(),
		        			cuenta.getContraseña());
		        	
		        	JOptionPane.showMessageDialog(null, "Información actualizada.",
			  		          "Mensaje",JOptionPane.INFORMATION_MESSAGE);
		        }
		        if(usuarioSeleccionado) {
		        	//Actualiza los datos del usuario seleccionado
		        	usuarios.actualizarDatos(lista.usuarioSeleccionado(), 
		        			cuenta.getNombre(), 
		        			cuenta.getApellido(),
		        			cuenta.getEmail(),
		        			cuenta.getContraseña());
		        	
		        	usuarioSeleccionado = false;
		        	
		        	JOptionPane.showMessageDialog(null, "Información actualizada.",
			  		          "Mensaje",JOptionPane.INFORMATION_MESSAGE);
		        }
			}
	    });
	}
	
	public void mostrarRegistro() {
		add(registro);
		
		//Boton cancelar de registro
		registro.getCancelar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registro.vaciarDatos();
			}
		});
		
		//Boton crear de registro
		registro.getCrear().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve el actionListener del boton crear usuario
				registro.getCrear().removeActionListener(this);
				
				//Metodo para validar el registro de usuario
				usuarios.añadirUsuario(registro.getUsuario(), 
						registro.getNombre(), 
						registro.getApellido(),
						registro.getEmail(),
						registro.getContraseña(),
						registro.getConfirmarContra());
				
				//Remueve todos los paneles
				removerPaneles();
				//Añade el panel lista
				mostrarLista();
				//Actualizar ventana
				actualizar();	
			}
		});	
	}
	
	public void mostrarLista() {
		add(lista);
		
		//Limpia y actualiza los datos de la lista de usuarios
		lista.limpiarLista();
		lista.actualizarLista(usuarios.getListaUsuarios());

		//Limpia y actualiza la tabla de usuarios de la clase lista
		tabla.limpiarTabla();	
		tabla.actualizarTabla(usuarios.getListaUsuarios());
		
		//Remueve y añade la tabla a la clase inicio
		lista.removerTabla();
		lista.añadirTabla(tabla);
		
		//Boton editar de lista
		lista.getEditar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve todos los paneles
				removerPaneles();
				//Remueve el actionListener del boton editar de lista
				lista.getEditar().removeActionListener(this);		
				usuarioSeleccionado = true;
				//Añade el panel cuenta
				mostrarCuenta();
				//Actualizar ventana
				actualizar();
			}
		});
	}
	
	public void mostrarAyuda() {
		add(ayuda);
		
		//Boton crear de ayuda
		ayuda.getCrear().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve todos los paneles
				removerPaneles();
				//Remueve el actionListener del boton crear usuario
				ayuda.getCrear().removeActionListener(this);
				//Añade el panel registro
				mostrarRegistro();	
				//Actualizar ventana
				actualizar();
			}
		});
	}
	
	//Opciones del menu superior
	public void opcionesMenu() {
		menu.getMenu().getItem1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve todos los paneles
				removerPaneles();
				//Añade el panel cuenta
				mostrarCuenta();
				//Actualizar ventana
				actualizar();
			}
	    });
		
		menu.getMenu().getItem2().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve todos los paneles
				removerPaneles();
				//Añade el panel login
				mostrarLogin();	
				//Ocultar el menu
				ocultarMenu();
				//Actualizar ventana
				actualizar();	
			}
		});
		
		menu.getMenu().getItem3().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve todos los paneles
				removerPaneles();
				//Añade el panel lista
				mostrarLista();
				//Actualizar ventana
				actualizar();	
			}
		});
		
		menu.getMenu().getItem4().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve todos los paneles
				removerPaneles();
				//Añade el panel registro
				mostrarRegistro();	
				//Actualizar ventana
				actualizar();	
			}
		});
		
		menu.getMenu().getItem5().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve todos los paneles
				removerPaneles();
				//Añade el panel ayuda
				mostrarAyuda();	
				//Actualizar ventana
				actualizar();	
			}
		});
	}

	//Metodo para la pantalla de carga
	public void pantallaCarga() {
		Carga carga = new Carga(ruta);
	    add(carga);
	    Tiempo(carga);
	    actualizar();
	}
	
	//Hace invisible el panel cuando pasan 3 segundos	
	public void Tiempo(JPanel panelCarga) {
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				contador++;
				if(contador == 3) {
					mostrarLogin();
					opcionesMenu();
					panelCarga.setVisible(false);
					timer.cancel();	
				}
				System.out.println(contador);
			}
		};
		timer.schedule(tarea,0,1000);
	}

	//Metodo para actualizar la ventana
	public void actualizar(){
		repaint();
		revalidate();
	}
	
	//Metodo para añadir el menu
	public void añadirMenu() {
		menu.getMenu().setVisible(true);
		setJMenuBar(menu.getMenu());	
	}
	
	//Metodo para ocultar el menu
	public void ocultarMenu() {
		menu.getMenu().setVisible(false);
	}
	
	//Remueve todos los paneles
	public void removerPaneles() {
		remove(login);
		remove(inicio);
		remove(cuenta);
		remove(lista);
		remove(registro);
		remove(ayuda);
	}
}