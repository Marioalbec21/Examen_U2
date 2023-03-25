import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JScrollPane{
	//Propiedades de la tabla
	private Point ubicacion = new Point(0,0);
	private int filas = 0;
	private int columnas = 3;
	
	public Tabla(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;

		setSize(250,200);
		setLocation(ubicacion);
		
		DefaultTableModel modeloTabla = new DefaultTableModel(filas, columnas);
	    modeloTabla.setColumnIdentifiers(new Object[]{"Usuario", "Nombre", "Acciones"});
	    
	    JTable tabla = new JTable(modeloTabla);
	    tabla.setSize(250,200);
	    tabla.setLocation(ubicacion);
	    add(tabla);
	}

	//Getters and setters de la tabla
	public Tabla getTabla() {
		return this;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public Point getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Point ubicacion) {
		this.ubicacion = ubicacion;
		setLocation(ubicacion);
	}
}
