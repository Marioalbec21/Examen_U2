import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Login extends JPanel{

	private Color colorFuente = Color.white;
	private Color colorFondos = new Color(128, 208, 186);
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
		txtfUsuario = new JTextField("Usuario");
		txtfUsuario.setFont(font);
		txtfUsuario.setForeground(colorFuente);
		txtfUsuario.setSize(tamañoRect);
		txtfUsuario.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfUsuario.setBackground(colorFondos);
		txtfUsuario.setBorder(BorderFactory.createLineBorder(new Color(128, 208, 186, 150))); //Da color al borde
		txtfUsuario.setHorizontalAlignment(SwingConstants.CENTER);

		txtfContraseña = new JTextField("Contraseña");
		txtfContraseña.setFont(font);
		txtfContraseña.setForeground(colorFuente);
		txtfContraseña.setSize(tamañoRect);
		txtfContraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfContraseña.setBackground(colorFondos);
		txtfContraseña.setBorder(BorderFactory.createLineBorder(new Color(128, 208, 186, 150)));  //Da color al borde
		txtfContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		
		ImageIcon icon = new ImageIcon("Examen_U2/resources/borrar.png");
		 
		//Botones de accion
		intervalo*=1.5;
		cancelar = new JButton(icon); //Boton cancelar
		cancelar.setSize(42,45);
		cancelar.setOpaque(true);
		cancelar.setBackground(new Color(174, 236, 219, 150));
		cancelar.setLocation(5,310);
		
		iniciar = new JButton("Login"); //Boton iniciar sesión
		iniciar.setSize(270, 45);
		iniciar.setLocation(15,240);
		
		//Fondo icono usuario
		JPanel imgUsuario = new JPanel();
		imgUsuario.setSize(150, 170);
		imgUsuario.setLocation(175,75);
		imgUsuario.setBackground(new Color(128, 208, 186, 0)); //Hace invisible el fondo
		
		//Agrega imagen al panel
		Imagen usuario = new Imagen("resources/user.png",150,170,imgUsuario); 
		add(imgUsuario);
				
		//Fondo verde componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(174, 236, 219, 150));
		fondo.setLayout(null);
		fondo.setSize(300, 380);
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
		
		Imagen fondoLog = new Imagen("resources/fondoLogin.jpg",500,600,fondoLogin);
		add(fondoLogin);
		
		//Metodo para quitar el texto dentro del textfield de usuario y contraseña
		listenerTxtf();
	}

	public void listenerTxtf() {
		txtfUsuario.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(!txtfUsuario.getText().isEmpty()){
					txtfUsuario.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtfContraseña.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(!txtfContraseña.getText().isEmpty()){
					txtfContraseña.setText(null);
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
	
	public void vaciarTxt() {
		 txtfUsuario.setText("");
		 txtfContraseña.setText("");
	}
	
	public void reiniciarTxt() {
		 txtfUsuario.setText("Usuario");
		 txtfContraseña.setText("Contraseña");
	}
}
