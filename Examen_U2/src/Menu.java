import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	
	//Propiedades del menu
	private JMenu cuenta = new JMenu("Cuenta");	
	private JMenu usuario = new JMenu("Usuario");
	private JMenu ayuda = new JMenu("Ayuda");
	
	private JMenuItem item1 = new JMenuItem("Mi Cuenta");
	private JMenuItem item2 = new JMenuItem("Cerrar Sesión");
	private JMenuItem item3 = new JMenuItem("Lista de Usuarios");
	private JMenuItem item4 = new JMenuItem("Crear Usuario");
	private JMenuItem item5 = new JMenuItem("¿Cómo crear usuarios?");
	
	public Menu(){
		cuenta.add(item1);
		cuenta.add(item2);
		usuario.add(item3);
		usuario.add(item4);
		ayuda.add(item5);
		
		add(cuenta);
		add(usuario);
		add(ayuda);
	}

	//Getters del menu
	public Menu getMenu() {
		return this;
	}
	
	public JMenu getCuenta() {
		return cuenta;
	}

	public JMenu getUsuario() {
		return usuario;
	}

	public JMenu getAyuda() {
		return ayuda;
	}

	public JMenuItem getItem1() {
		return item1;
	}

	public JMenuItem getItem2() {
		return item2;
	}

	public JMenuItem getItem3() {
		return item3;
	}

	public JMenuItem getItem4() {
		return item4;
	}

	public JMenuItem getItem5() {
		return item5;
	}
}
