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

public class Registro extends JPanel{
	
	private Color colorFondos = new Color(255, 255, 255);
	private Color colorFuente = Color.gray;
	private Dimension tamañoRect = new Dimension(250, 35);
	private Point ubicacion = new Point(120, 80);  //modifica la ubicacion de los componentes
	private int intervalo = 55;
	
	//Fuente 
	private Font font = new Font("Arial", Font.PLAIN, 15);
		
	//Botones de acción
	private JButton cancelar;
	private JButton crear;
	private JTextField txtfNombre ;
	private JTextField txtfApellido;
	private JTextField txtfUsuario;
	private JTextField txtfEmail;
	private JPasswordField txtfContraseña;
	private JPasswordField txtfconfirmarContra;
	
	public Registro(String ruta) {
		//Propiedades del panel
		setBackground(Color.decode("#293845"));
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("Crear Usuario", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 35));
		titulo.setForeground(Color.white);
		titulo.setSize(400, 40);
		titulo.setLocation(50,50);
		add(titulo);

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
		
	    txtfUsuario = new JTextField("Usuario");
	    txtfUsuario.setFont(font);
	    txtfUsuario.setForeground(colorFuente);
	    txtfUsuario.setSize(tamañoRect);
	    txtfUsuario.setLocation(ubicacion.x, ubicacion.y+=intervalo);
	    txtfUsuario.setBackground(colorFondos);
	    txtfUsuario.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
	    txtfUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		
		
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
	
		txtfconfirmarContra = new JPasswordField("********");
		txtfconfirmarContra.setFont(font);
		txtfconfirmarContra.setForeground(colorFuente);
		txtfconfirmarContra.setSize(tamañoRect);
		txtfconfirmarContra.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		txtfconfirmarContra.setBackground(colorFondos);
		txtfconfirmarContra.setBorder(BorderFactory.createLineBorder(colorFondos)); //Da color al borde
		txtfconfirmarContra.setHorizontalAlignment(SwingConstants.LEFT);

		add(txtfNombre);
		add(txtfApellido);
		add(txtfUsuario);
		add(txtfEmail);
		add(txtfContraseña);
		add(txtfconfirmarContra);
		
		ImageIcon icon = new ImageIcon(ruta+"borrar.png");
		
		//Botones inferiores
		intervalo*=1.5;
		cancelar = new JButton(icon); //Boton eliminar
		cancelar.setSize(42,45);
		cancelar.setLocation(385,500);
		cancelar.setBorderPainted(false);
		
		crear = new JButton("Crear Usuario"); //Boton para crear un usuario
		crear.setFont(font);
		crear.setForeground(Color.gray);
		crear.setBackground(Color.white);
		crear.setSize(131,55);
		crear.setLocation(180, 470);
		
		add(cancelar);
		add(crear);
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.white);
		fondo.setSize(510, 610);
		fondo.setLocation(-5,-30);
		add(fondo);
		Imagen fondoInicio = new Imagen(ruta+"registro.png",500,610,fondo);
		
		//Metodo para ocultar y mostrar el texto de los recuadros
		listenerTxtf();
	}
		
	//Getters del panel
	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getCrear() {
		return crear;
	}

	public String getNombre() {
		return txtfNombre.getText();
	}

	public String getApellido() {
		return txtfApellido.getText();
	}

	public String getUsuario() {
		return txtfUsuario.getText();
	}

	public String getEmail() {
		return txtfEmail.getText();
	}

	public String getContraseña() {
		return new String(txtfContraseña.getPassword());
	}

	public String getConfirmarContra() {
		return new String(txtfconfirmarContra.getPassword());
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
		
		txtfUsuario.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txtfUsuario.getText().equals("Usuario")){
					txtfUsuario.setText(null);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtfUsuario.getText().equals("")) {
					txtfUsuario.setText("Usuario");					
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
		
		txtfconfirmarContra.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(new String(txtfconfirmarContra.getPassword()).equals("********")){
					txtfconfirmarContra.setText(null);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(new String(txtfconfirmarContra.getPassword()).equals("")){
					txtfconfirmarContra.setText("********");
				}
			}
		});	
	}
	
	public void vaciarDatos() {
		txtfNombre.setText("Nombre");
		txtfApellido.setText("Apellido");
		txtfUsuario.setText("Usuario");
		txtfEmail.setText("Correo electrónico");
		txtfContraseña.setText("********");
		txtfconfirmarContra.setText("********");
	}
}
