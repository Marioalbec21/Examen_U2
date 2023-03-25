import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends JPanel{

	//Menu del panel
	private Menu menu = new Menu();
	
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
	public Menu getMenu() {
		return menu;
	}
}