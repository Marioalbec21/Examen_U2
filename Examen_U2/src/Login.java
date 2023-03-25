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
	
	public void validaciones() {
		iniciar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//ARCHIVO 
				File archivo;
				FileReader leer;
				BufferedReader almacenamiento;
				
				String nombre = "" , lector = " ";
			 
			    archivo = new  File("users.txt");
				
			    try {
					
					leer = new FileReader(archivo);
					almacenamiento = new BufferedReader(leer);
					
					if(!txtfUsuario.getText().equals("") || !txtfContraseña.getText().equals("") )
					{
						while(lector != null) {
							lector = almacenamiento.readLine();
							String [] informacionUser = new String[4];
							
							if(lector!=null)
							{
								String [] auxiliar = lector.split(" ");
								
								informacionUser = auxiliar;
								
							}
		
							if(txtfUsuario.getText().equals(informacionUser[2]) && txtfContraseña.getText().equals(informacionUser [3]))
							{
								nombre = informacionUser [0];
								String saludo = "Bienvenido " + nombre;
								JOptionPane.showMessageDialog(null, saludo , "Iniciando",JOptionPane.INFORMATION_MESSAGE);
								
								break;
								
							}
							else if(lector == null)
							{
								JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto","Error",JOptionPane.ERROR_MESSAGE);
							
							}
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Favor de llenar los recuadros","Error Vacío",JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				catch(Exception e1) 
				{
					System.out.println("Error: " + e1.getMessage());
				}
				
			}
			
		});
		
	}
	//Getters del panel
	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getIniciar() {
		return iniciar;
	}
	
}
