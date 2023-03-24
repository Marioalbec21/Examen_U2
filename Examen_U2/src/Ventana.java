//EXAMEN UNIDAD 2
//JOSÉ MIGUEL MENDOZA ANAYA
//MARIO ALBERTO CASTELLANOS

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	private int largo = 500;
	private int ancho = 600;
	
	public Ventana() {
		super("Ventana");
		setSize(largo, ancho);
		setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //Inicia panel login
	    add(new Login());
	}
	
	public void actualizar(){
		repaint();
		revalidate();
	}
}
