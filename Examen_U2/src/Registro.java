import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registro extends JPanel{

	private Color colorFuente = Color.white;
	private Dimension tamañoLbl = new Dimension(140, 40);
	private Dimension tamañoRect = new Dimension(250, 25);
	private Point ubicacion = new Point(120, 120);  //modifica la ubicacion de los componentes
	private int intervalo = 35;
	
	//Botones de acción
	private JButton cancelar;
	private JButton crear;
	private JTextField txtfNombre ;
	private JTextField txtfApellido;
	private JTextField txtfUsuario;
	private JTextField txtfEmail;
	private JTextField txtfContraseña;
	private JTextField txtfconfirmarContra;
	
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
		JLabel nombre = new JLabel("Nombre");
		nombre.setSize(tamañoLbl);
		nombre.setForeground(colorFuente);
		nombre.setLocation(ubicacion);
		
		txtfNombre = new JTextField();
		txtfNombre.setSize(tamañoRect);
		txtfNombre.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel apellido = new JLabel("Apellido");
		apellido.setSize(tamañoLbl);
		apellido.setForeground(colorFuente);
		apellido.setLocation(ubicacion);
		
		txtfApellido = new JTextField();
		txtfApellido.setSize(tamañoRect);
		txtfApellido.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JLabel usuario = new JLabel("Usuario");
		usuario.setSize(tamañoLbl);
		usuario.setForeground(colorFuente);
		usuario.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
	    txtfUsuario = new JTextField();
		txtfUsuario.setSize(tamañoRect);
		txtfUsuario.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
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
		
		JLabel confirmarContra = new JLabel("Confirmar Contraseña");
		confirmarContra.setSize(tamañoLbl);
		confirmarContra.setForeground(colorFuente);
		confirmarContra.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		txtfconfirmarContra = new JTextField();
		txtfconfirmarContra.setSize(tamañoRect);
		txtfconfirmarContra.setLocation(ubicacion.x, ubicacion.y+=intervalo);

		add(nombre);
		add(txtfNombre);
		add(apellido);
		add(txtfApellido);
		add(usuario);
		add(txtfUsuario);
		add(email);
		add(txtfEmail);
		add(contraseña);
		add(txtfContraseña);
		add(confirmarContra);
		add(txtfconfirmarContra);
		
		//Botones inferiores
		intervalo*=1.5;
		cancelar = new JButton("Cancelar");
		cancelar.setSize(90,25);
		cancelar.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		crear = new JButton("Crear Usuario");
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
	
	//Metodo para registro del usuario
	public void registrarUsuario() {
		Usuarios usuarios = new Usuarios("users.txt");
		usuarios.añadirUsuario(txtfUsuario.getText(), txtfNombre.getText(), 
				txtfApellido.getText(), txtfEmail.getText(), txtfContraseña.getText());
		
		JOptionPane.showMessageDialog(null, "Usuario creado",
		          "Mensaje",JOptionPane.INFORMATION_MESSAGE);
	}
		
	//Getters del panel
	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getCrear() {
		return crear;
	}
}
