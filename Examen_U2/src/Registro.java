import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registro extends JPanel{

	private Color colorFuente = Color.white;
	private Dimension tamañoLbl = new Dimension(140, 40);
	private Dimension tamañoRect = new Dimension(250, 25);
	private Point ubicacion = new Point(120, 140);  //modifica la ubicacion de los componentes
	private int intervalo = 35;
	
	public Registro() {
		//Propiedades del panel
		setBackground(Color.decode("#293845"));
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("Crear Usuario", JLabel.CENTER);
		titulo.setForeground(colorFuente);
		titulo.setSize(150, 40);
		titulo.setLocation(170,30);
		add(titulo);

		//Componentes del panel datos
		JLabel nombre = new JLabel("Nombre Completo");
		nombre.setSize(tamañoLbl);
		nombre.setForeground(colorFuente);
		nombre.setLocation(ubicacion);
		
		JTextField txtfNombre = new JTextField();
		txtfNombre.setSize(tamañoRect);
		txtfNombre.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel apellido = new JLabel("Usuario");
		apellido.setSize(tamañoLbl);
		apellido.setForeground(colorFuente);
		apellido.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JTextField txtfApellido = new JTextField();
		txtfApellido.setSize(tamañoRect);
		txtfApellido.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel email = new JLabel("Email");
		email.setSize(tamañoLbl);
		email.setForeground(colorFuente);
		email.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JTextField txtfEmail = new JTextField();
		txtfEmail.setSize(tamañoRect);
		txtfEmail.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel contraseña = new JLabel("Contraseña");
		contraseña.setSize(tamañoLbl);
		contraseña.setForeground(colorFuente);
		contraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JTextField txtfContraseña = new JTextField();
		txtfContraseña.setSize(tamañoRect);
		txtfContraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel confirmarContra = new JLabel("Confirmar Contraseña");
		confirmarContra.setSize(tamañoLbl);
		confirmarContra.setForeground(colorFuente);
		confirmarContra.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JTextField txtfconfirmarContra = new JTextField();
		txtfconfirmarContra.setSize(tamañoRect);
		txtfconfirmarContra.setLocation(ubicacion.x, ubicacion.y+=intervalo);

		add(nombre);
		add(txtfNombre);
		add(apellido);
		add(txtfApellido);
		add(email);
		add(txtfEmail);
		add(contraseña);
		add(txtfContraseña);
		add(confirmarContra);
		add(txtfconfirmarContra);
		
		//Botones inferiores
		intervalo*=1.5;
		JButton cancelar = new JButton("Cancelar");
		cancelar.setSize(90,25);
		cancelar.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		JButton crear = new JButton("Crear Usuario");
		crear.setSize(131,25);
		crear.setLocation(ubicacion.x+ubicacion.x, ubicacion.y);

		add(cancelar);
		add(crear);
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#526687"));
		fondo.setSize(300, 420);
		fondo.setLocation(100,130);
		add(fondo);
	}
}
