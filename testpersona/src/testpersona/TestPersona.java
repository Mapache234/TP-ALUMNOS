/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpersona;

import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import miCalendar.ExcFechaInvalida;
import miCalendar.MiCalendar;
import persona.Alumno;
import persona.Persona;
import persona.PersonaInvalidaException;

/**
 *
 * @author nestor
 */
public class TestPersona
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		Persona pepe;
		
		try
		{
			pepe = new Alumno(23456789, "Pepe",'M', new MiCalendar(10, 2, 1998), 20, 6, "INF");
		}
		catch(PersonaInvalidaException | ExcFechaInvalida ex)
		{
			Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
			return;
		}

/*		
		Persona toto = new Persona();
		
		try
		{
			pepe.setDni(22333444);
		}
		catch(PersonaInvalidaException ex)
		{
			Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
		
		try
		{
			toto.setDni(33777888);
			toto.setApyn("Toto");
			pepe.setApyn("Pepe");
		}
		catch(PersonaInvalidaException ex)
		{
			Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
		
		
		
		System.out.println("DNI de pepe: " + pepe.getDni());
		System.out.println("DNI de toto: " + toto.getDni());
*/		
		System.out.println("Pepe: " + pepe);
		
		
		
		MiCalendar fecha;
		
		try
		{
			fecha = new MiCalendar(5, 13, 1999);
		}
		catch(ExcFechaInvalida ex)
		{
			Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
			return;
		}
		
		System.out.println("Fecha: " + fecha);
	}

}
