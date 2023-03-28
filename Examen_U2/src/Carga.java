import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carga extends JPanel {
	public Carga(String ruta) {
		//Propiedades del panel
		setBackground(Color.decode("#AEECDB"));
		setLayout(null);
		
		//Mensaje creadores
		JLabel titulo = new JLabel("By Alberto Martinez & Miguel Mendoza", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 14));
		titulo.setForeground(Color.white);
		titulo.setSize(400, 35);
		titulo.setLocation(50,500);
		add(titulo);
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#AEECDB"));
		fondo.setSize(500, 300);
		fondo.setLocation(0,150);
		add(fondo);
		
		//Agrega imagen a la pantalla de carga
		Imagen splash = new Imagen(ruta+"mano.gif", 400,300,fondo);
	}
}