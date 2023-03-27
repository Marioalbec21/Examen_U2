import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Login extends JPanel{

	private Color colorFuente = Color.white;
	private Dimension tamañoRect = new Dimension(250, 45);
	private Point ubicacion = new Point(25, 20);
	private int intervalo = 75;

	//Nombre de usuario y contraseña
	private JTextField txtfUsuario ;
	private JTextField txtfContraseña;
		
	//Botones de acción
	private JButton cancelar;
	private JButton iniciar;
	
	//Fuente 
	private Font font = new Font("Arial", Font.BOLD, 15);
	
	public Login() {
		 
		//Propiedades del panel
		setLayout(null);

		//Componentes del panel datos
		txtfUsuario = new JTextField("                   U s u a r i o");
		txtfUsuario.setFont(font);
		txtfUsuario.setForeground(colorFuente);
		txtfUsuario.setSize(tamañoRect);
		txtfUsuario.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfUsuario.setBackground(new Color(128, 208, 186, 150));
		txtfUsuario.setBorder(BorderFactory.createLineBorder(new Color(128, 208, 186, 150))); //Da color al borde
		
		txtfContraseña = new JTextField("                C o n t r a s e ñ a");
		txtfContraseña.setFont(font);
		txtfContraseña.setForeground(colorFuente);
		txtfContraseña.setSize(tamañoRect);
		txtfContraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfContraseña.setBackground(new Color(128, 208, 186, 150));
		txtfContraseña.setBorder(BorderFactory.createLineBorder(new Color(128, 208, 186, 150)));  //Da color al borde
		
		//Botones de accion
		intervalo*=1.5;
		cancelar = new JButton("Trash"); //Boton cancelar
		cancelar.setSize(60,35);
		cancelar.setLocation(5,310);
		
		iniciar = new JButton("L o g i n"); //Boton iniciar sesión
		iniciar.setSize(270, 45);
		iniciar.setLocation(15,240);
		
		//Fondo icono usuario
		JPanel imgUsuario = new JPanel();
		imgUsuario.setSize(150, 170);
		imgUsuario.setLocation(175,75);
		imgUsuario.setBackground(new Color(128, 208, 186, 0)); //Hace invisible el fondo
		
		//Agrega imagen al panel
		Imagen usuario = new Imagen("/resources/user.png",150,170,imgUsuario); 
		add(imgUsuario);
				
		//Fondo verde componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(174, 236, 219, 150));
		fondo.setLayout(null);
		fondo.setSize(300, 350);
		fondo.setLocation(100,180);
		
		fondo.add(txtfUsuario);
		fondo.add(txtfContraseña);
		fondo.add(cancelar);
		fondo.add(iniciar);
		
		add(fondo);
		
		//Fondo login
		JPanel fondoLogin = new JPanel();
		fondoLogin.setSize(500, 600);
		fondoLogin.setLocation(0,-10);
		
		Imagen fondoLog = new Imagen("/resources/fondo5.jpg",500,600,fondoLogin);
		add(fondoLogin);
		
		//Metodo para quitar el texto dentro del textfield de usuario y contraseña
		listenerTxtf();
	}
	
	public void listenerTxtf() {
		txtfUsuario.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txtfUsuario.getText().equals("                   U s u a r i o")){
					txtfUsuario.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtfContraseña.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txtfContraseña.getText().equals("                C o n t r a s e ñ a")){
					txtfContraseña.setText("");
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
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

	public String getUsuario() {
		return txtfUsuario.getText();
	}

	public String getContraseña() {
		return txtfContraseña.getText();
	}
}
