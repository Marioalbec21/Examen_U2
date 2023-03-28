import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Cuenta extends JPanel{

	private Color colorFondos = new Color(255, 255, 255);
	private Color colorFuente = Color.gray;
	private Dimension tamañoRect = new Dimension(250, 35);
	private Point ubicacion = new Point(130, 140);
	private int intervalo = 55;
	private JLabel titulo;
	//Fuente 
	private Font font = new Font("Arial", Font.PLAIN, 15);
	//Botones de acción
	private JButton cancelar;
	private JButton actualizar;
	
	//Datos del la cuenta
	private JTextField txtfNombre;
	private JTextField txtfApellido;
	private JTextField txtfEmail;
	private JPasswordField txtfContraseña;
    
	public Cuenta(String ruta) {
		//Propiedades del panel
		setBackground(Color.white);
		setLayout(null);
		
		//Componentes del panel
		titulo = new JLabel("Editar Cuenta", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 35));
		titulo.setForeground(Color.white);
		titulo.setSize(400, 40);
		titulo.setLocation(50,130);
		add(titulo);

		//Componentes del panel datos	
		txtfNombre = new JTextField("Nombre");
		txtfNombre.setFont(font);
		txtfNombre.setForeground(colorFuente);
		txtfNombre.setSize(tamañoRect);
		txtfNombre.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfNombre.setBackground(colorFondos);
		txtfNombre.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
		txtfNombre.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtfApellido = new JTextField("Apellido");
		txtfApellido.setFont(font);
		txtfApellido.setForeground(colorFuente);
		txtfApellido.setSize(tamañoRect);
		txtfApellido.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfApellido.setBackground(colorFondos);
		txtfApellido.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
		txtfApellido.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtfEmail = new JTextField("Correo electrónico");
		txtfEmail.setFont(font);
		txtfEmail.setForeground(colorFuente);
		txtfEmail.setSize(tamañoRect);
		txtfEmail.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfEmail.setBackground(colorFondos);
		txtfEmail.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
		txtfEmail.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtfContraseña = new JPasswordField("********");
		txtfContraseña.setFont(font);
		txtfContraseña.setForeground(colorFuente);
		txtfContraseña.setSize(tamañoRect);
		txtfContraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfContraseña.setBackground(colorFondos);
		txtfContraseña.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
		txtfContraseña.setHorizontalAlignment(SwingConstants.LEFT);

		add(txtfNombre);
		add(txtfApellido);
		add(txtfEmail);
		add(txtfContraseña);
		
		//Titulo boton inicio
		JLabel tituloInicio = new JLabel("Inicio", JLabel.CENTER);
		tituloInicio.setFont(new Font("Arial", Font.BOLD, 22));
		tituloInicio.setForeground(Color.white); 
		tituloInicio.setSize(100, 20);
		tituloInicio.setLocation(385,80);
		add(tituloInicio);
				
		ImageIcon icon = new ImageIcon(ruta+"iconInicio.png");
		
		//Botones de accion
		intervalo*=1.5;
		cancelar = new JButton(icon); //Boton inicio
		cancelar.setSize(70,65);
		cancelar.setLocation(400, 10);
		cancelar.setBorderPainted(false);
		
		actualizar = new JButton("Actualizar datos"); //Boton actualizar
		actualizar.setFont(font);
		actualizar.setForeground(Color.gray);
		actualizar.setBackground(Color.white);
		actualizar.setSize(131,45);
		actualizar.setLocation(60+ubicacion.x, ubicacion.y+60);

		add(cancelar);
		add(actualizar);
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.white);
		fondo.setSize(510, 610);
		fondo.setLocation(-5,-60);
		add(fondo);
		Imagen fondoInicio = new Imagen(ruta+"fondoRegistro.png",500,610,fondo);
		
		listenerTxtf();
	}
	
	//Getters del panel
	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getActualizar() {
		return actualizar;
	}

	public String getNombre() {
		return txtfNombre.getText();
	}

	public String getApellido() {
		return txtfApellido.getText();
	}

	public String getEmail() {
		return txtfEmail.getText();
	}

	public String getContraseña() {
		return new String(txtfContraseña.getPassword());
	}
	
	public void listenerTxtf() {
		txtfNombre.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txtfNombre.getText().equals("Nombre")){
					txtfNombre.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtfNombre.getText().equals("")) {
					txtfNombre.setText("Nombre");					
				}
			}
		});
		
		txtfApellido.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txtfApellido.getText().equals("Apellido")){
					txtfApellido.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtfApellido.getText().equals("")) {
					txtfApellido.setText("Apellido");					
				}
			}
		});
		
		txtfEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txtfEmail.getText().equals("Correo electrónico")){
					txtfEmail.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtfEmail.getText().equals("")) {
					txtfEmail.setText("Correo electrónico");					
				}
			}
		});
		
		txtfContraseña.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(new String(txtfContraseña.getPassword()).equals("********")){
					txtfContraseña.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(new String(txtfContraseña.getPassword()).equals("")){
					txtfContraseña.setText("********");					
				}
			}
		});
	}

	public void setTitulo(String usuario) {
		titulo.setText(usuario);
	}
	public void vaciarDatos() {
		txtfNombre.setText("Nombre");
		txtfApellido.setText("Apellido");
		txtfEmail.setText("Correo electrónico");
		txtfContraseña.setText("********");
	}
}
