//EXAMEN UNIDAD 2
//JOSÉ MIGUEL MENDOZA ANAYA
//MARIO ALBERTO CASTELLANOS

import java.awt.Color;
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
	
	//Paneles de la aplicacion
	private Login login = new Login();
	private Inicio inicio = new Inicio();
	private Cuenta cuenta = new Cuenta();
	private Lista lista = new Lista();
	
	public Ventana() {
		//Propiedades de la ventana
		super("Sistema");
		setSize(largo, ancho);
		setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setResizable(false);
		getContentPane().setBackground(Color.decode("#154D82"));
	    
		//Inicia Pantalla y login
		pantallaCarga();
		
	    //Actualiza la ventana
	    actualizar();
	}
	
	public void mostrarLogin() {
	    add(login);
	    
	    //Boton acceder de login
	    login.getIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ingresando al sistema...",
						          "Iniciando",JOptionPane.INFORMATION_MESSAGE);
				
				//Remueve el login
				remove(login);
				//Añade el panel inicio
				add(inicio);			
				//Añade la barra del menu inicio
				setJMenuBar(inicio.getMenu());			
				//Actualizar ventana
				actualizar();
			}
	    });
	    
	    //Boton cancelar de login
	    login.getCancelar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saliendo del sistema...",
						          "Iniciando",JOptionPane.INFORMATION_MESSAGE);

				//Salir de la aplicación
				salir();
			}
	    });
	}
	
	//Opciones del menu superior
	public void opcionesMenu() {
		inicio.getMenu().getItem1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve el login
				remove(inicio);
				//Añade el panel inicio
				add(cuenta);			
				//Actualizar ventana
				actualizar();
			}
	    });
		cuenta.getCancelar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remueve el login
				remove(cuenta);
				//Añade el panel inicio
				add(inicio);			
				//Actualizar ventana
				actualizar();
			}
	    });
		cuenta.getActualizar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cuenta.actualizarDatos();
			}
	    });
	}
	
	//Metodo para la pantalla de carga
	public void pantallaCarga() {
		Carga carga = new Carga();
	    add(carga);
	    Tiempo(carga);
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
	
	//Metodo para cerrar la aplicación
	public void salir() {
		System.exit(0);
	}
}