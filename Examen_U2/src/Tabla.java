import java.awt.Point;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JTable{
	//Propiedades de la tabla
	private int filas = 0;
	
	public Tabla(int filas, int columnas) {
		this.filas = filas;

		setSize(250,300);
		
		DefaultTableModel modeloTabla = new DefaultTableModel(filas, columnas);
		modeloTabla.setColumnIdentifiers(new Object[]{"Usuario", "Nombre", "Acciones"});
		setModel(modeloTabla);
		
		//Añadir algunos datos a la tabla
        modeloTabla.setValueAt("Juan", 0, 0);
        modeloTabla.setValueAt("Pérez", 0, 1);
        modeloTabla.setValueAt("Editar", 0, 2);
        modeloTabla.setValueAt("Ana", 1, 0);
        modeloTabla.setValueAt("Gómez", 1, 1);
        modeloTabla.setValueAt("Eliminar", 1, 2);
	}

	//Getters and setters de la tabla
	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}
}
