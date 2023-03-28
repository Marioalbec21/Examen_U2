import java.util.List;

import javax.swing.JButton;
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
			
			this.setDefaultRenderer(Object.class, new Render());
			
			JButton editar = new JButton("Eliminar");
			this.setRowHeight(30);
			modeloTabla.addRow(new Object[]{datos[0], datos[1], editar});
			isCellEditable(modeloTabla.getRowCount(),4);
		}
	}
	
	//Metodo para limpiar la tabla
	public void limpiarTabla() {
		modeloTabla.setRowCount(0);
	}
	
	 public boolean isCellEditable(int row, int columnas) {
	    	return false;
	 }
}
