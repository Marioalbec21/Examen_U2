import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ayuda extends JPanel{

	private Point ubicacion = new Point(90,400);  //modifica la ubicacion de los componentes
	private JButton crear;
	
	public Ayuda(String ruta) {
		//Propiedades del panel
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("¿Cómo crear un usuario?", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 33));
		titulo.setForeground(Color.white); 
		titulo.setSize(500, 40);
		titulo.setLocation(0,40);
		add(titulo);

		//Boton crear usuario
		crear = new JButton("Crear Usuario");
		crear.setFont(new Font("Arial", Font.PLAIN, 15));
		crear.setForeground(Color.gray);
		crear.setBackground(Color.white);
		crear.setSize(130,55);
		crear.setLocation(185, 450);
		add(crear);
				
		//Area de Texto de los pasos para crear usuario
		JTextArea pasos = new JTextArea();
		pasos.setForeground(Color.white);
		pasos.setSize(420, 500);
		pasos.setLocation(40,30);
		pasos.setText(""
				+ "\n\n\n\n  1). Hacer click en la opción “Usuarios” "
				+ "\n\n       en el menú superior\n\n"
				+ "  2). Hacer click en la opción “Crear Usuario”"
				+ "\n\n       en el menú desplegado\n\n"
				+ "  3). Llenar los campos solicitados\n\n"
				+ "  4). Hacer click en el botón “Crear Usuario”\n\n"
				+ "  5). Listo, el usuario se ha creado");
		
		pasos.setFont(new Font("Arial", Font.BOLD, 19));
		pasos.setBackground(Color.decode("#82A69C"));
		pasos.setEditable(false);
		add(pasos);
		repaint();
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#AEECDB"));
		fondo.setSize(500, 600);
		fondo.setLocation(0,-10);
		add(fondo);
		Imagen fondoAyuda = new Imagen(ruta+"fondo.png",500,600,fondo);
		
	}
	
	//Getters del panel
	public JButton getCrear() {
		return crear;
	}
}
