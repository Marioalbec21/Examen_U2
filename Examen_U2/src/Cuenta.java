import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Cuenta extends JPanel{

	private Color colorFondos = new Color(255, 255, 255);
	private Color colorFuente = Color.gray;
	private Dimension tamañoRect = new Dimension(250, 35);
	private Point ubicacion = new Point(130, 170);
	private int intervalo = 55;
	
	//Fuente 
	private Font font = new Font("Arial", Font.PLAIN, 15);
	//Botones de acción
	private JButton cancelar;
	private JButton actualizar;
	
	//Datos del la cuenta
	private JTextField txtfNombre;
	private JTextField txtfApellido;
	private JTextField txtfEmail;
	private JTextField txtfContraseña;
	
	//private String carpeta = "resources/";
    private String carpeta = "";
    
	public Cuenta() {
		//Propiedades del panel
		setBackground(Color.white);
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("Mi Cuenta", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 35));
		titulo.setForeground(Color.white);
		titulo.setSize(400, 40);
		titulo.setLocation(50,140);
		add(titulo);

		//Componentes del panel datos	
		txtfNombre = new JTextField("Nombre");
		txtfNombre.setFont(font);
		txtfNombre.setForeground(colorFuente);
		txtfNombre.setSize(tamañoRect);
		txtfNombre.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfNombre.setBackground(colorFondos);
		txtfNombre.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
		txtfNombre.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtfApellido = new JTextField("Apellidos");
		txtfApellido.setFont(font);
		txtfApellido.setForeground(colorFuente);
		txtfApellido.setSize(tamañoRect);
		txtfApellido.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfApellido.setBackground(colorFondos);
		txtfApellido.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
		txtfApellido.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtfEmail = new JTextField("Correo");
		txtfEmail.setFont(font);
		txtfEmail.setForeground(colorFuente);
		txtfEmail.setSize(tamañoRect);
		txtfEmail.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfEmail.setBackground(colorFondos);
		txtfEmail.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
		txtfEmail.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtfContraseña = new JTextField("Contraseña");
		txtfContraseña.setFont(font);
		txtfContraseña.setForeground(colorFuente);
		txtfContraseña.setSize(tamañoRect);
		txtfContraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfContraseña.setBackground(colorFondos);
		txtfContraseña.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
		txtfContraseña.setHorizontalAlignment(SwingConstants.LEFT);

		add(txtfNombre);
		add(txtfApellido);
		add(txtfEmail);
		add(txtfContraseña);
		ImageIcon icon = new ImageIcon(carpeta+"iconInicio.png");
		//Botones de accion
		intervalo*=1.5;
		cancelar = new JButton(icon); //Boton inicio
		cancelar.setSize(70,65);
		cancelar.setLocation(20, ubicacion.y+=intervalo);
		cancelar.setOpaque(false);
		actualizar = new JButton("Actualizar datos"); //Boton actualizar
		actualizar.setSize(131,45);
		actualizar.setLocation(60+ubicacion.x, ubicacion.y-25);

		add(cancelar);
		add(actualizar);
		
		
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.white);
		fondo.setSize(510, 610);
		fondo.setLocation(-5,-60);
		add(fondo);
		Imagen fondoInicio = new Imagen(carpeta+"fondoRegistro.png",500,610,fondo);
	}
	
	//Getters del panel
	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getActualizar() {
		return actualizar;
	}

	public String getNombre() {
		return txtfNombre.getText();
	}

	public String getApellido() {
		return txtfApellido.getText();
	}

	public String getEmail() {
		return txtfEmail.getText();
	}

	public String getContraseña() {
		return txtfContraseña.getText();
	}
}
