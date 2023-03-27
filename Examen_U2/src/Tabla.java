import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JTable{
	//Propiedades de la tabla
	private DefaultTableModel modeloTabla;
	
	public Tabla() {
		
		//Crea el modelo de la tabla y lo añade a la tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(new Object[]{"Usuario", "Nombre", "Acciones"});
	    setModel(modeloTabla);
	}
	
	//Metodo para actualizar la tabla
	public void actualizarTabla(List <String> usuarios) {		
		for (int i = 0; i < usuarios.size(); i++) {			

			String[] datos = usuarios.get(i).split(",");
			modeloTabla.addRow(new Object[]{datos[0], datos[1], null});
		}
	}
	
	//Metodo para limpiar la tabla
	public void limpiarTabla() {
		modeloTabla.setRowCount(0);
	}
}
