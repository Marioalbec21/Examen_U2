import java.awt.Color;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ayuda extends JPanel{

	private Color colorFuente = Color.white;
	private Point ubicacion = new Point(90,500);  //modifica la ubicacion de los componentes
	private JButton crear;
	public Ayuda() {
		//Propiedades del panel
		setBackground(Color.decode("#293845"));
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("¿Cómo crear un usuario", JLabel.CENTER);
		titulo.setForeground(colorFuente);
		titulo.setSize(150, 40);
		titulo.setLocation(170,30);
		add(titulo);
		
		//Area de Texto de los pasos para crear usuario
		JTextArea pasos = new JTextArea();
		pasos.setForeground(colorFuente);
		pasos.setSize(320, 240);
		pasos.setLocation(90,250);
		pasos.setText(""
				+ "  1). Hacer click en la opción “Usuarios” "
				+ "\n\n       en el menú superior\n\n"
				+ "  2). Hacer click en la opción “Crear Usuario”"
				+ "\n\n       en el menú desplegado\n\n"
				+ "  3). Llenar los campos solicitados\n\n"
				+ "  4). Hacer click en el botón “Crear Usuario”\n\n"
				+ "  5). Listo, el usuario se ha creado");
		
		pasos.setBackground(Color.decode("#526687"));
		pasos.setEditable(false);
		add(pasos);
		
		//Boton crear usuario
		crear = new JButton("Crear Usuario");
		crear.setSize(131,25);
		crear.setLocation(ubicacion.x+ubicacion.x, ubicacion.y);
		add(crear);
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#526687"));
		fondo.setSize(320, 320);
		fondo.setLocation(90,230);
		add(fondo);
	}
	
	//Getters del panel
	public JButton getCrear() {
		return crear;
	}
}
