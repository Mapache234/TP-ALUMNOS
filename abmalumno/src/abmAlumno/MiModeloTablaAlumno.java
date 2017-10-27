/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmAlumno;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import persona.Alumno;

/**
 *
 * @author nestor
 */
public class MiModeloTablaAlumno extends AbstractTableModel
{
	public MiModeloTablaAlumno()
	{
		alumnos = new ArrayList<>();
	}
	
	
	@Override
	public int getRowCount()
	{
		return alumnos.size();
	}
	
	
	@Override
	public int getColumnCount()
	{
		return 9;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Alumno alu = alumnos.get(rowIndex);
		
		switch(columnIndex)
		{
			case 0: return alu.getDni();
			case 1: return alu.getApyn();
			case 2: return alu.getFechaNac();
			case 3: return alu.getSexo();
			case 4: return alu.getFechaIngreso();
			case 5: return alu.getCantMatAprob();
			case 6: return alu.getCarrera();
			case 7: return alu.getPromedio();
			case 8: return alu.getEstado();
			default: return null;
		}
	}
	
	
	@Override
	public String getColumnName(int column)
	{
		return nomCols[column];
	}
	
	
	
	
	public void setLista(List<Alumno> alumnos)
	{
		this.alumnos = alumnos;
		fireTableDataChanged();
	}
	
	
	public void actualizarTabla()
	{
		fireTableDataChanged();
	}
	
	
	
	private List<Alumno> alumnos;
	
	private static final String[] nomCols = new String[]{"DNI", "Apellido y Nombres", "Fecha Nac.", "Sexo", "Fecha Ingr.", "Cant. Mat. Aprob.", "Carrera", "Promedio", "Estado"};
}
