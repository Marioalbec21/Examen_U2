import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel{

	private Color colorFuente = Color.white;
	private Dimension tamañoLbl = new Dimension(150, 40);
	private Dimension tamañoRect = new Dimension(250, 25);
	private Point ubicacion = new Point(120, 190);
	private JTextField txtfUsuario ;
	private JTextField txtfContraseña;
	private int intervalo = 35;
	
	//Botones de acción
	private JButton cancelar;
	private JButton iniciar;
	
	//Arreglo de datos del usuario
	private String[] datosUsuario = new String[5];

	public Login() {
		//Propiedades del panel
		setBackground(Color.decode("#293845"));
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("Accede a tu cuenta", JLabel.CENTER);
		titulo.setForeground(colorFuente);
		titulo.setSize(150, 40);
		titulo.setLocation(170,30);
		add(titulo);

		//Componentes del panel datos
		JLabel usuario = new JLabel("Nombre de usuario");
		usuario.setSize(tamañoLbl);
		usuario.setForeground(colorFuente);
		usuario.setLocation(ubicacion);
		
		txtfUsuario = new JTextField();
		txtfUsuario.setSize(tamañoRect);
		txtfUsuario.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel contraseña = new JLabel("Contraseña de acceso");
		contraseña.setSize(tamañoLbl);
		contraseña.setForeground(colorFuente);
		contraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		txtfContraseña = new JTextField();
		txtfContraseña.setSize(tamañoRect);
		txtfContraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);

		add(usuario);
		add(txtfUsuario);
		add(contraseña);
		add(txtfContraseña);

		//Botones de accion
		intervalo*=1.5;
		cancelar = new JButton("Cancelar"); //Boton cancelar
		cancelar.setSize(90,25);
		cancelar.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		iniciar = new JButton("Iniciar Sesión"); //Boton iniciar sesión
		iniciar.setSize(131,25);
		iniciar.setLocation(ubicacion.x+ubicacion.x, ubicacion.y);

		add(cancelar);
		add(iniciar);
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#526687"));
		fondo.setSize(300, 350);
		fondo.setLocation(100,180);
		add(fondo);
	}
	
	//Metodo para validar datos
	public boolean comprobarDatos() {
		boolean datosCorrectos = false;
		
		Usuarios usuarios = new Usuarios("users.txt"); //Lee el archivo users.txt
		for(int i = 0; i < usuarios.getTamañoLista(); i++) {
			
			//Pasa los datos de la linea de texto a un arreglo
			if(usuarios.getListaUsuarios(i).contains(txtfUsuario.getText())) {
				datosUsuario = usuarios.getListaUsuarios(i).split(",");
				
				//Comprueba que el usuario y contraseña esten correctos
				if(txtfUsuario.getText().contains(datosUsuario[0]) && 
						txtfContraseña.getText().contains(datosUsuario[4])) {
					datosCorrectos = true;
				}
				else {
					datosCorrectos = false;
				}
			}
		}
		return datosCorrectos;
	}
	
	//Getters del panel
	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getIniciar() {
		return iniciar;
	}

	public String[] getDatosUsuario() {
		return datosUsuario;
	}
}
