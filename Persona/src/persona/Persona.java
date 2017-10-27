/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import miCalendar.ExcFechaInvalida;
import miCalendar.MiCalendar;

/**
 *
 * @author nestor
 */
public class Persona
{
	private int dni;
	private String apyn;
	private char sexo;
	private MiCalendar fechaNac;
	
	
	public Persona()
	{
		this.dni = 0;
		this.apyn = "";
		this.sexo = 'M';
		
		try
		{
			this.fechaNac = new MiCalendar(1, 1, 1900);
		}
		catch(ExcFechaInvalida ex)
		{}
	}
	
	
	public Persona(int dni) throws PersonaInvalidaException
	{
		this.setDni(dni);
		this.apyn = "";
		this.sexo = 'M';
		
		try
		{
			this.fechaNac = new MiCalendar(1, 1, 1900);
		}
		catch(ExcFechaInvalida ex)
		{}
	}
	
	
	public Persona(int dni, String apyn, char sexo, MiCalendar fechaNac) throws PersonaInvalidaException
	{
		this.setDni(dni);
		this.setApyn(apyn);
		this.setSexo(sexo);
		this.setFechaNac(fechaNac);
	}
	
	
	public Persona(String linea) throws PersonaInvalidaException
	{
		String[] campos = linea.split("\t");
		
		setDni(Integer.valueOf(campos[0]));
		setApyn(campos[1]);
		setSexo(campos[2].charAt(0));
		setFechaNac(new MiCalendar(campos[3]));
		
	}
	
	
	public int getDni()
	{
		return dni;
	}

	public final void setDni(int dni) throws PersonaInvalidaException
	{
		if(dni <= 0)
			throw new PersonaInvalidaException("DNI inválido");
		
		this.dni = dni;
	}

	public String getApyn()
	{
		return apyn;
	}

	public final void setApyn(String apyn) throws PersonaInvalidaException
	{
		if(apyn == null)
			throw new PersonaInvalidaException("Apellido y Nombres nulo");
		
		
		
		this.apyn = apyn.trim();
	}

	public char getSexo()
	{
		return sexo;
	}

	public final void setSexo(char sexo)
	{
		this.sexo = sexo;
	}

	public MiCalendar getFechaNac()
	{
		return fechaNac;
	}

	public final void setFechaNac(MiCalendar fechaNac)
	{
		this.fechaNac = fechaNac;
	}
	
	
	@Override
	public String toString()
	{
		String apeYNom = apyn.length() > 30? apyn.substring(0, 30) : apyn;
		return String.format("%08d", dni) + "\t" + String.format("%-30s", apeYNom) + "\t" + sexo + "\t" + fechaNac;
	}
	
	
	
}
