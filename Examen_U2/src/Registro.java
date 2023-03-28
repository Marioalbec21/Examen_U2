import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registro extends JPanel{

	private Color colorFuente = Color.white;
	private Dimension tamañoLbl = new Dimension(140, 40);
	private Dimension tamañoRect = new Dimension(250, 25);
	private Point ubicacion = new Point(120, 80);  //modifica la ubicacion de los componentes
	private int intervalo = 35;
	
	//Botones de acción
	private JButton cancelar;
	private JButton crear;
	private JTextField txtfNombre ;
	private JTextField txtfApellido;
	private JTextField txtfUsuario;
	private JTextField txtfEmail;
	private JPasswordField txtfContraseña;
	private JPasswordField txtfconfirmarContra;
	
	public Registro() {
		//Propiedades del panel
		setBackground(Color.decode("#293845"));
		setLayout(null);
		
		//Componentes del panel
		JLabel titulo = new JLabel("Crear Usuario", JLabel.CENTER);
		titulo.setForeground(colorFuente);
		titulo.setSize(150, 40);
		titulo.setLocation(170,30);
		add(titulo);

		txtfNombre = new JTextField("Nombre");
		txtfNombre.setSize(tamañoRect);
		txtfNombre.setLocation(ubicacion.x, ubicacion.y+=intervalo);
	
		txtfApellido = new JTextField("Apellido");
		txtfApellido.setSize(tamañoRect);
		txtfApellido.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
	    txtfUsuario = new JTextField("Usuario");
		txtfUsuario.setSize(tamañoRect);
		txtfUsuario.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		txtfEmail = new JTextField("Correo electrónico");
		txtfEmail.setSize(tamañoRect);
		txtfEmail.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		
		txtfContraseña = new JPasswordField("********");
		txtfContraseña.setSize(tamañoRect);
		txtfContraseña.setLocation(ubicacion.x, ubicacion.y+=intervalo);
	
		txtfconfirmarContra = new JPasswordField("********");
		txtfconfirmarContra.setSize(tamañoRect);
		txtfconfirmarContra.setLocation(ubicacion.x, ubicacion.y+=intervalo);

		add(txtfNombre);
		add(txtfApellido);
		add(txtfUsuario);
		add(txtfEmail);
		add(txtfContraseña);
		add(txtfconfirmarContra);
		
		//Botones inferiores
		intervalo*=1.5;
		cancelar = new JButton("Cancelar");
		cancelar.setSize(90,25);
		cancelar.setLocation(ubicacion.x, ubicacion.y+=intervalo);
		crear = new JButton("Crear Usuario");
		crear.setSize(131,25);
		crear.setLocation(ubicacion.x+ubicacion.x, ubicacion.y);

		add(cancelar);
		add(crear);
		
		//Fondo componentes del panel
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.decode("#526687"));
		fondo.setSize(300, 420);
		fondo.setLocation(100,80);
		add(fondo);
		
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
}
