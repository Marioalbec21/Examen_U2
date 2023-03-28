import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Login extends JPanel{

	private Color colorFuente = Color.white;
	private Color colorFondos = new Color(128, 208, 186);
	private Dimension tamañoRect = new Dimension(250, 45);
	private Point ubicacion = new Point(75, 55);
	private int intervalo = 75;

	//Nombre de usuario y contraseña
	private JTextField txtfUsuario ;
	private JPasswordField txtfContraseña;
	//Botones de acción
	private JButton cancelar;
	private JButton iniciar;
	
	//Fuente 
	private Font font = new Font("Arial", Font.BOLD, 16);
	
	public Login(String ruta) {
		 
		//Propiedades del panel
		setLayout(null);
		
		//Titulo login
		JLabel titulo = new JLabel("A c c e d e r", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 35));
		titulo.setForeground(Color.white);
		titulo.setSize(400, 40);
		titulo.setLocation(50,180);
		add(titulo);

		//Componentes del panel datos
		txtfUsuario = new JTextField("Usuario");
		txtfUsuario.setFont(font);
		txtfUsuario.setForeground(colorFuente);
		txtfUsuario.setSize(tamañoRect);
		txtfUsuario.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfUsuario.setBackground(colorFondos);
		txtfUsuario.setBorder(BorderFactory.createLineBorder(new Color(128, 208, 186, 150))); //Da color al borde
		txtfUsuario.setHorizontalAlignment(SwingConstants.CENTER);

		txtfContraseña = new JPasswordField("********");
		txtfContraseña.setFont(font);
		txtfContraseña.setForeground(colorFuente);
		txtfContraseña.setSize(tamañoRect);
		txtfContraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfContraseña.setBackground(colorFondos);
		txtfContraseña.setBorder(BorderFactory.createLineBorder(new Color(128, 208, 186, 150)));  //Da color al borde
		txtfContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		
		ImageIcon icon = new ImageIcon(ruta+"borrar.png");
		 
		//Botones de accion
		intervalo*=1.5;
		cancelar = new JButton(icon); //Boton eliminar
		cancelar.setSize(42,45);
		cancelar.setLocation(350,330);
		cancelar.setOpaque(true);
		cancelar.setBackground(Color.decode("#82A69C"));
		cancelar.setBorderPainted(false);
		
		iniciar = new JButton("L o g i n"); //Boton iniciar sesión
		iniciar.setFont(font);
		iniciar.setForeground(Color.gray);
		iniciar.setSize(290, 55);
		iniciar.setLocation(55,270);
		iniciar.setBackground(Color.white);
		
		//Fondo icono usuario
		JPanel imgUsuario = new JPanel();
		imgUsuario.setSize(150, 170);
		imgUsuario.setLocation(175,5);
		imgUsuario.setBackground(new Color(0, 0, 0, 0)); //Hace invisible el fondo
		
		//Agrega imagen al panel
		Imagen usuario = new Imagen(ruta+"user.png",150,170,imgUsuario); 
		
		add(imgUsuario);
				
		//Fondo verde componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#82A69C"));
		fondo.setLayout(null);
		fondo.setSize(400, 380);
		fondo.setLocation(50,120);
		
		fondo.add(txtfUsuario);
		fondo.add(txtfContraseña);
		fondo.add(cancelar);
		fondo.add(iniciar);
		
		add(fondo);
		
		//Fondo login
		JPanel fondoLogin = new JPanel();
		fondoLogin.setSize(500, 600);
		fondoLogin.setLocation(0,-10);
		
		Imagen fondoLog = new Imagen(ruta+"fondoLogin.jpg",500,600,fondoLogin);
		add(fondoLogin);
		
		//Metodo para quitar el texto dentro del textfield de usuario y contraseña
		listenerTxtf();
	}

	public void listenerTxtf() {
		txtfUsuario.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txtfUsuario.getText().equals("Usuario")){
					txtfUsuario.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtfUsuario.getText().equals("")) {
					txtfUsuario.setText("Usuario");					
				}
			}
		});
		
		txtfContraseña.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(new String(txtfContraseña.getPassword()).equals("********")){
					txtfContraseña.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(new String(txtfContraseña.getPassword()).equals("")) {
					txtfContraseña.setText("********");					
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

	public String getUsuario() {
		return txtfUsuario.getText();
	}

	public String getContraseña() {
		return new String(txtfContraseña.getPassword());
	}
	public void vaciarDatos() {
		 txtfUsuario.setText("Usuario");
		 txtfContraseña.setText("********");
	}
}
