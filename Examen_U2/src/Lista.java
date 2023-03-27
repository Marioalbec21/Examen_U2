import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Lista extends JPanel{
	
	private Color colorFuente = Color.white;
	private Dimension tamañoLbl = new Dimension(100, 40);
	private Dimension tamañoRect = new Dimension(250, 25);
	private Point ubicacion = new Point(120, 100);
	private int intervalo = 35;
	
	public Lista() {
		//Propiedades del panel
		setBackground(Color.decode("#293845"));
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("Lista de usuarios", JLabel.CENTER);
		titulo.setForeground(colorFuente);
		titulo.setSize(150, 40);
		titulo.setLocation(170,40);
		add(titulo);
		
		//Componentes del panel datos
		JLabel nombre = new JLabel("Editar");
		nombre.setSize(tamañoLbl);
		nombre.setForeground(colorFuente);
		nombre.setLocation(ubicacion);
		
		JComboBox cbox1 = new JComboBox();
		cbox1.setSize(tamañoRect);
		cbox1.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		JButton editar = new JButton("Editar a Usuario");
		editar.setSize(tamañoRect);
		editar.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		add(nombre);
		add(cbox1);
		add(editar);
		
	}
	//Metodo para añadir la tabla de usuarios
	public void añadirTabla(Tabla tabla) {
		JScrollPane sp = new JScrollPane(tabla);
		sp.setBounds(ubicacion.x, ubicacion.y += intervalo, 250, 104);
		add(sp);		
	}
}
