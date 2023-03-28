import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Lista extends JPanel{
	
	private Dimension tamañoRect = new Dimension(250, 25);
	private Point ubicacion = new Point(120, 100);
	private int intervalo = 35;
	
	//Botones de accion
	private JButton editar;
	private JComboBox cbox1;
	private JScrollPane sp;
	public Lista(Tabla tabla,String ruta) {
		//Propiedades del panel
		setBackground(Color.decode("#AEECDB"));
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("Lista de usuarios", JLabel.CENTER);
	
		titulo.setFont(new Font("Arial", Font.BOLD, 45));
		titulo.setForeground(Color.white);
		titulo.setSize(400, 40);
		titulo.setLocation(50,40);
		add(titulo);
		
		//Componentes del panel datos
		JLabel nombre = new JLabel("Seleccionar");
		nombre.setFont(new Font("Arial", Font.BOLD, 20));
		nombre.setForeground(Color.gray);
		nombre.setSize(400, 40);
		nombre.setLocation(120,100);
		
		cbox1 = new JComboBox();
		cbox1.setSize(tamañoRect);
		cbox1.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		añadirTabla(tabla);
		
		editar = new JButton("Editar a Usuario");
		editar.setFont(new Font("Arial", Font.BOLD, 13));
		editar.setForeground(Color.gray);
		editar.setBackground(Color.white);
		editar.setSize(tamañoRect);
		editar.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		add(nombre);
		add(editar);
		
		//Fondo de lista
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#AEECDB"));
		fondo.setSize(500, 230);
		fondo.setLocation(0,350);
		add(fondo);
				
		Imagen fondoLista = new Imagen(ruta+"lista.png",fondo);
		repaint();
	}
	
	//Metodo para actualizar la lista del JComboBox
	public void actualizarLista(List <String> usuarios) {
		for (int i = 0; i < usuarios.size(); i++) {
			
			String[] datos = usuarios.get(i).split(",");			
			cbox1.addItem(datos[0]);
		}
		add(cbox1);
	}
	
	//Metodo para limpiar la lista del JComboBox
	public void limpiarLista() {
		cbox1.removeAllItems();
	}
	
	//Metodo para añadir la tabla de usuarios
	public void añadirTabla(Tabla tabla) {
		sp = new JScrollPane(tabla);
		sp.setBounds(ubicacion.x, ubicacion.y + intervalo, 250, 104);
		add(sp);		
	}
	
	//Metodo para remover la tabla de la clase
	public void removerTabla() {
		remove(sp);
	}
	
	//Metodo que regresa el usuario seleccionado del cbox
	public String usuarioSeleccionado() {
		String usuario = (String) cbox1.getSelectedItem();
		return usuario;
	}
	
	//Getters del panel
	public JButton getEditar() {
		return editar;
	}
}
