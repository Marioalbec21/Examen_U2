import java.awt.Color;
import javax.swing.JPanel;

public class Carga extends JPanel {
	
	public Carga() {
		//Propiedades del panel
		setBackground(Color.decode("#AEECDB"));
		setLayout(null);
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#AEECDB"));
		fondo.setSize(500, 600);
		fondo.setLocation(0,150);
		add(fondo);
		
		//Agrega imagen a la pantalla de carga
		Imagen splash = new Imagen("mano.gif", 400,300,fondo);
		
	}
}