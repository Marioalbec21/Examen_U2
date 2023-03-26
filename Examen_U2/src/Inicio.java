import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends JPanel{
	
	private JLabel titulo;
	
	public Inicio() {
		//Propiedades del panel
		setBackground(Color.decode("#154D82"));
		setLayout(null);
		
		//Componentes del panel
		titulo = new JLabel("", JLabel.CENTER); //Texto de bienvenida
		titulo.setFont(new Font("Comic Sans", Font.BOLD,35));
		titulo.setForeground(Color.white);
		titulo.setSize(400,80);
		titulo.setLocation(50,40);
		add(titulo);		
	}

	//Getters de la clase inicio
	public void setNombreUsuario(String nombreUsuario) {
		titulo.setText("Hola "+nombreUsuario);
	}
	
}