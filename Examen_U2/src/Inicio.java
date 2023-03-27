import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends JPanel{
	
	private JLabel titulo;
	
	public Inicio() {
		//Propiedades del panel
		setBackground(Color.white);
		setLayout(null);
		
		//Componentes del panel
		titulo = new JLabel("", JLabel.CENTER); //Texto de bienvenida
		titulo.setFont(new Font("Comic Sans", Font.BOLD,40));
		titulo.setForeground(Color.decode("#505252"));
		titulo.setSize(400,80);
		titulo.setLocation(10,140);
		add(titulo);
		
		//Imagen icono inicio
		JPanel iconoInicio = new JPanel();
		iconoInicio.setBackground(Color.white);
		iconoInicio.setSize(150, 170);
		iconoInicio.setLocation(175,15);
		add(iconoInicio);
		Imagen inicio = new Imagen("resources/inicio.png",iconoInicio);
		
		//Fondo de inicio
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.white);
		fondo.setSize(500, 600);
		fondo.setLocation(0,100);
		add(fondo);
				
		Imagen fondoInicio = new Imagen("resources/fondoInicio.png",fondo);
	}

	//Getters de la clase inicio
	public void setNombreUsuario(String nombreUsuario) {
		titulo.setText("¡Hola! "+nombreUsuario);
	}
}