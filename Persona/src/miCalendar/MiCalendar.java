/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miCalendar;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author nestor
 */
public class MiCalendar extends GregorianCalendar
{
	public MiCalendar(int dia, int mes, int año) throws ExcFechaInvalida
	{
		super(año, mes - 1, dia);
		setLenient(false);
		
		try
		{
			get(DAY_OF_MONTH);
		//	get(MONTH);
		//	get(YEAR);
		}
		catch(Exception ex)
		{
			throw new ExcFechaInvalida("La fecha " + dia + "/" + mes + "/" + año + " es Inválida");
		}
		
	}
	
	
	public MiCalendar(String linea)
	{
		String[] campos = linea.split("/");
		
		setDia(Integer.valueOf(campos[0]));
		setMes(Integer.valueOf(campos[1]));
		setAño(Integer.valueOf(campos[2]));
	}
	
	
	public MiCalendar(Calendar cal)
	{
		setDia(cal.get(DAY_OF_MONTH));
		setMes(cal.get(MONTH) + 1);
		setAño(cal.get(YEAR));
	}

	public MiCalendar(Date date)
	{
		setTimeInMillis(date.getTime());
	}
	
	
	public int getDia()
	{
		return get(DAY_OF_MONTH);
	}
	
	
	public int getMes()
	{
		return get(MONTH) + 1;
	}
	
	
	public int getAño()
	{
		return get(YEAR);
	}
	
	
	public void setDia(int dia)
	{
		set(DAY_OF_MONTH, dia);
	}
	
	
	public void setMes(int mes)
	{
		set(MONTH, mes-1);
	}
	
	
	public void setAño(int año)
	{
		set(YEAR, año);
	}
	
	
	@Override
	public String toString()
	{
		return String.format("%02d/%02d/%04d", getDia(), getMes(), getAño());
	}

	public Date toDate()
	{
		return new Date(getTimeInMillis());
	}
}
