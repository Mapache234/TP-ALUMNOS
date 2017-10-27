/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import dao.AlumnoDAOTxt;
import dao.DAO;
import dao.DAOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import miCalendar.ExcFechaInvalida;
import miCalendar.MiCalendar;
import persona.Alumno;
import persona.PersonaInvalidaException;

/**
 *
 * @author nestor
 */
public class TestDAO
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		DAO<Alumno, Integer> dao;
		try
		{
			dao = new AlumnoDAOTxt(new File("Alumnos.txt"));
		}
		catch(FileNotFoundException ex)
		{
			Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
			return;
		}
		
		Alumno pepe;
/*		
		try
		{
			pepe = new Alumno(55555555, "Cinco", 'M', new MiCalendar(20, 5, 2000), 21, 7, "ELE");
		}
		catch(ExcFechaInvalida | PersonaInvalidaException ex)
		{
			Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
			return;
		}
		
			
		try
		{
			dao.insertar(pepe);
		}
		catch(DAOException ex)
		{
			Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
			return;
		}
*/			
		
		List<Alumno> alumnos;
		try
		{
			alumnos = dao.getTodos();
		}
		catch(DAOException ex)
		{
			Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
			return;
		}
		
		for(Alumno alumno : alumnos)
		{
			System.out.println(alumno.toString());
		}
	}
	
}
