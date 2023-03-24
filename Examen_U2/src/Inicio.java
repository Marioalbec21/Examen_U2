import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Inicio extends JPanel{

	public Inicio() {
		//Propiedades del panel
		setBackground(Color.decode("#154D82"));
		setLayout(null);
		
		//Componentes del panel
		JLabel bienvenida = new JLabel("Hola", JLabel.CENTER); //Texto de bienvenida
		bienvenida.setFont(new Font("Comic Sans", Font.BOLD,35));
		bienvenida.setForeground(Color.white);
		bienvenida.setSize(400,80);
		bienvenida.setLocation(50,40);
		add(bienvenida);		
	}
	
	//Metodo para Crear la barra de menú
	public JMenuBar barra() {
		JMenuBar menu = new JMenuBar();
		
		JMenu cuenta = new JMenu("Cuenta");	
		JMenu usuario = new JMenu("Usuario");
		JMenu ayuda = new JMenu("Ayuda");
		
		JMenuItem item1 = new JMenuItem("Mi Cuenta");
		JMenuItem item2 = new JMenuItem("Cerrar Sesión");
		JMenuItem item3 = new JMenuItem("Lista de Usuarios");
		JMenuItem item4 = new JMenuItem("Crear Usuario");
		JMenuItem item5 = new JMenuItem("¿Cómo crear usuarios?");
		
		cuenta.add(item1);
		cuenta.add(item2);
		usuario.add(item3);
		usuario.add(item4);
		ayuda.add(item5);
		
		menu.add(cuenta);
		menu.add(usuario);
		menu.add(ayuda);
		
		return menu;
	}
}