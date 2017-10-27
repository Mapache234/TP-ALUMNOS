/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import miCalendar.MiCalendar;

/**
 *
 * @author nestor
 */
public class Alumno extends Persona
{
	public Alumno(int dni, String apyn, char sexo, MiCalendar fechaNac, int cantMatAprob, double promedio, String carrera, MiCalendar fechaIngreso, char estado) throws PersonaInvalidaException
	{
		super(dni, apyn, sexo, fechaNac);
		setCantMatAprob(cantMatAprob);
		setPromedio(promedio);
		setCarrera(carrera);
                setFechaIngreso(fechaIngreso);
                setEstado(estado);
	}
	
	
	public Alumno(String linea) throws PersonaInvalidaException
	{
		super(linea.substring(0, 52));
		String[] campos = linea.substring(53).split("\t");
		setCantMatAprob(Integer.valueOf(campos[0]));
		setPromedio(Double.valueOf(campos[1]));
		setCarrera(campos[2]);
                setFechaIngreso(new MiCalendar(campos[3]));
                setEstado(campos[4].charAt(0));
	}
	
	
	private int cantMatAprob;
	private double promedio;
	private String carrera;
	private MiCalendar fechaIngreso;
        private char estado;
        //private char[] Estados = new char[] {'A', 'B', 'E'};
	private static final String[] CARRERAS = new String[] {"INF", "CON", "ELE", "MED"};
        //private static final String[] ESTADOS = new String[] {"A","B","E"};

	public Alumno()
	{
	//	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	
	public int getCantMatAprob()
	{
		return cantMatAprob;
	}

	public final void setCantMatAprob(int cantMatAprob)
	{
		this.cantMatAprob = cantMatAprob;
	}

	public double getPromedio()
	{
		return promedio;
	}

	public final void setPromedio(double promedio)
	{
		this.promedio = promedio;
	}

	public String getCarrera()
	{
		return carrera;
	}

	public final void setCarrera(String carrera)
	{
		this.carrera = carrera;
	}

	public MiCalendar getFechaIngreso()
	{
		return fechaIngreso;
	}

	public final void setFechaIngreso(MiCalendar fechaIngreso)
	{
		this.fechaIngreso = fechaIngreso;
	}
	
        public char getEstado()
	{
		return estado;
	}

	public final void setEstado(char estado)
	{
                this.estado = estado;
        }
	
	@Override
	public String toString()
	{
		return super.toString() + "\t" + cantMatAprob + "\t" + promedio + "\t" + carrera + "\t" + fechaIngreso + "\t" + estado;
	}

	
	
	
	
}
