/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.PersonaInvalidaException;

/**
 *
 * @author nestor
 */
public class AlumnoDAOTxt extends DAO<Alumno, Integer>
{
	public AlumnoDAOTxt(File archivo) throws FileNotFoundException
	{
		archivoRandomAccessFile = new RandomAccessFile(archivo, "rws");
	}
	
	
	@Override
	public void insertar(Alumno alu) throws DAOException
	{
		if(existe(alu.getDni()))
			throw new DAOException("El Alumno ya existe.");
		
		try
		{
			archivoRandomAccessFile.seek(archivoRandomAccessFile.length()); //Me posiciono al final del archivo.
			archivoRandomAccessFile.writeBytes(alu.toString() + System.lineSeparator());
		}
		catch(IOException ex)
		{
			Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException("No se pudo insertar: " + ex.getMessage());
		}
		
		
	}

	@Override
	public Alumno buscar(Integer id) throws DAOException
	{
		try
		{
			archivoRandomAccessFile.seek(0);
			String linea;
			while((linea = archivoRandomAccessFile.readLine()) != null)
			{
				if(Integer.valueOf(linea.substring(0, 8)).equals(id))
				{
					Alumno alu = new Alumno(linea);
					return alu;
				}
			}
		}
		catch(IOException | PersonaInvalidaException ex)
		{
			Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
		
		return null;
	}

	
	@Override
	public boolean existe(Integer id) throws DAOException
	{
		try
		{
			archivoRandomAccessFile.seek(0);
			String linea;
			while((linea = archivoRandomAccessFile.readLine()) != null)
			{
				if(Integer.valueOf(linea.substring(0, 8)).equals(id))
				{
					return true;
				}	
			}
		}
		catch(IOException ex)
		{
			Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
		
		return false;
	}
	
	
	@Override
	public void eliminar(Alumno obj) throws DAOException
	{       //paraborrar
                try
		{
                        archivoRandomAccessFile.seek(0);
			long pos = archivoRandomAccessFile.getFilePointer(); //Devuelve la posición del cursor.
                        
			String linea;
			while((linea = archivoRandomAccessFile.readLine()) != null)
			{
				if(Integer.valueOf(linea.substring(0, 8)).equals(obj.getDni()))
				{
                                        archivoRandomAccessFile.seek(pos);
					archivoRandomAccessFile.writeBytes(obj.toString() + System.lineSeparator());
					return;
				}
                                pos = archivoRandomAccessFile.getFilePointer(); //Devuelve la posición del cursor.
			}
		}
		catch(IOException ex)
		{
			Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
		}
                //paraborrar
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void actualizar(Alumno obj) throws DAOException
	{

		try
		{
                        archivoRandomAccessFile.seek(0);
			long pos = 0; //Devuelve la posición del cursor.
                        
			String linea;
			while((linea = archivoRandomAccessFile.readLine()) != null)
			{
				if(Integer.valueOf(linea.substring(0, 8)).equals(obj.getDni()))
				{
                                        archivoRandomAccessFile.seek(pos);
					archivoRandomAccessFile.writeBytes(obj.toString() + System.lineSeparator());
					return;
				}
                                pos = archivoRandomAccessFile.getFilePointer(); //Devuelve la posición del cursor.
			}
		}
		catch(IOException ex)
		{
			Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	@Override
	public List<Alumno> getTodos() throws DAOException
	{
		List<Alumno> alumnos = new LinkedList<>();
		
		try
		{
			archivoRandomAccessFile.seek(0);
			
			String linea;
			Alumno alu;
			while((linea = archivoRandomAccessFile.readLine()) != null)
			{
				alu = new Alumno(linea);
                                if (alu.getEstado() != 'E')//paraborrar
				alumnos.add(alu);
			}
			
			return alumnos;
		}
		catch(IOException | PersonaInvalidaException ex)
		{
			Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
	}
	
	
	private RandomAccessFile archivoRandomAccessFile;

    @Override
    public List<Alumno> getAltas() throws DAOException {
        List<Alumno> alumnos = new LinkedList<>();
		
		try
		{
			archivoRandomAccessFile.seek(0);
			
			String linea;
			Alumno alu;
			while((linea = archivoRandomAccessFile.readLine()) != null)
			{
                                alu = new Alumno(linea);
				if (alu.getEstado() == 'A')
                                    alumnos.add(alu);
			}
			
			return alumnos;
		}
		catch(IOException | PersonaInvalidaException ex)
		{
			Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
    }

    @Override
    public List<Alumno> getBajas() throws DAOException {
        List<Alumno> alumnos = new LinkedList<>();
		
		try
		{
			archivoRandomAccessFile.seek(0);
			
			String linea;
			Alumno alu;
			while((linea = archivoRandomAccessFile.readLine()) != null)
			{
                                alu = new Alumno(linea);
				if (alu.getEstado() == 'B')
                                    alumnos.add(alu);
			}
			
			return alumnos;
		}
		catch(IOException | PersonaInvalidaException ex)
		{
			Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
    }
}
