import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cuenta extends JPanel{

	private Color colorFuente = Color.white;
	private Dimension tamañoLbl = new Dimension(100, 40);
	private Dimension tamañoRect = new Dimension(250, 25);
	private Point ubicacion = new Point(120, 190);
	private int intervalo = 35;
	
	//Botones de acción
	private JButton cancelar;
	private JButton actualizar;
	
	//Datos del la cuenta
	private JTextField txtfNombre;
	private JTextField txtfApellido;
	private JTextField txtfEmail;
	private JTextField txtfContraseña;
		
	public Cuenta() {
		//Propiedades del panel
		setBackground(Color.decode("#293845"));
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("Mi cuenta personal", JLabel.CENTER);
		titulo.setForeground(colorFuente);
		titulo.setSize(150, 40);
		titulo.setLocation(170,30);
		add(titulo);

		//Componentes del panel datos
		JLabel nombre = new JLabel("Nombre");
		nombre.setSize(tamañoLbl);
		nombre.setForeground(colorFuente);
		nombre.setLocation(ubicacion);
		
		txtfNombre = new JTextField();
		txtfNombre.setSize(tamañoRect);
		txtfNombre.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel apellido = new JLabel("Apellidos");
		apellido.setSize(tamañoLbl);
		apellido.setForeground(colorFuente);
		apellido.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		txtfApellido = new JTextField();
		txtfApellido.setSize(tamañoRect);
		txtfApellido.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel email = new JLabel("Email");
		email.setSize(tamañoLbl);
		email.setForeground(colorFuente);
		email.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		txtfEmail = new JTextField();
		txtfEmail.setSize(tamañoRect);
		txtfEmail.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel contraseña = new JLabel("Contraseña");
		contraseña.setSize(tamañoLbl);
		contraseña.setForeground(colorFuente);
		contraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		txtfContraseña = new JTextField();
		txtfContraseña.setSize(tamañoRect);
		txtfContraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);

		add(nombre);
		add(txtfNombre);
		add(apellido);
		add(txtfApellido);
		add(email);
		add(txtfEmail);
		add(contraseña);
		add(txtfContraseña);

		//Botones de accion
		intervalo*=1.5;
		cancelar = new JButton("Cancelar"); //Boton cancelar
		cancelar.setSize(90,25);
		cancelar.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		actualizar = new JButton("Actualizar datos"); //Boton actualizar
		actualizar.setSize(131,25);
		actualizar.setLocation(ubicacion.x+ubicacion.x, ubicacion.y);

		add(cancelar);
		add(actualizar);
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#526687"));
		fondo.setSize(300, 350);
		fondo.setLocation(100,180);
		add(fondo);
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
