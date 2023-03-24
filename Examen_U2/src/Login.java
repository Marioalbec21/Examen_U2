import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel{
	//Botones de acción
	private JButton iniciar;
	private JButton cancelar;
	
	public Login() {
		//Propiedades del panel
		setBackground(Color.decode("#154D82"));
		setLayout(null);
		
		//Componentes del panel
		JLabel bienvenida = new JLabel("Iniciar sesión", JLabel.CENTER);
		bienvenida.setFont(new Font("Comic Sans", Font.ITALIC,35));
		bienvenida.setForeground(Color.orange);
		bienvenida.setSize(400,80);
		bienvenida.setLocation(50,40);
		add(bienvenida);
			
		JLabel msjNombre = new JLabel("Nombre de usuario");
		msjNombre.setFont(new Font("Comic Sans", Font.ITALIC,12));
		msjNombre.setForeground(Color.white);
		msjNombre.setSize(250,80);
		msjNombre.setLocation(90,100);
		add(msjNombre);
		
		JTextField usuario = new JTextField();
		usuario.setSize(250,40);
		usuario.setLocation(90,150);
		usuario.setBorder(null);
		add(usuario);
	
		JLabel msjContra = new JLabel("Contraseña de acceso");
		msjContra.setFont(new Font("Comic Sans", Font.ITALIC,12));
		msjContra.setForeground(Color.white);
		msjContra.setSize(250,80);
		msjContra.setLocation(90,180);
	
		add(msjContra);
		
		JPasswordField  contraseña = new JPasswordField ();
		contraseña.setForeground(Color.gray);
		contraseña.setSize(250,40);
		contraseña.setLocation(90,230);
		contraseña.setEditable(true);
		add(contraseña);
		
		//Propiedades boton iniciar
		iniciar = new JButton("Iniciar Sesión");
		iniciar.setFont(new Font("Comic Sans", Font.ITALIC,13));
		iniciar.setSize(135,40);
		iniciar.setLocation(280,350);
		add(iniciar);
		
		//Propiedades boton cancelar
		cancelar = new JButton("Cancelar");
		cancelar.setFont(new Font("Comic Sans", Font.ITALIC,13));
		cancelar.setSize(135,40);
		cancelar.setLocation(90,350);
		add(cancelar);
	}
	
	//Getters de botones de acción
	public JButton getIniciar() {
		return iniciar;
	}
	
	public JButton getCancelar() {
		return cancelar;
	}
}