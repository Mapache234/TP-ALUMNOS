/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import miCalendar.MiCalendar;
import persona.Alumno;
import persona.PersonaInvalidaException;

/**
 *
 * @author nestor
 */
public class AlumnoDAOBD extends DAO<Alumno, Integer>
{
	public AlumnoDAOBD(String server, Integer port, String bd, String user, String password) throws SQLException
	{
		
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + bd, user, password);
		
		System.out.println("Conexión exitosa!");
		
		String sentencia =
			"insert into alumnos\n" +
			"(dni, apyn, fechaNac, sexo, fechaIngr, carrera, cantMatAprob, promedio)\n" +
			"values(?, ?, ?, ?, ?, ?, ?, ?)\n";
		
		insertarPS = conexion.prepareStatement(sentencia);
		
                sentencia =
                        "SELECT 1 value FROM alumnos WHERE dni = ?\n";
                
                existePS = conexion.prepareStatement(sentencia);
                
                sentencia = 
                        "DELETE FROM alumnos WHERE dni = ?\n";
                
                eliminarPS = conexion.prepareStatement(sentencia);
                
                sentencia = 
                        "SELECT * FROM alumnos WHERE dni = ?\n";
                
                buscarPS = conexion.prepareStatement(sentencia);
                
		sentencia =
			"update alumnos\n" +
			"set\n" +
			"apyn = ?,\n" +
			"fechaNac = ?,\n" +
			"sexo = ?,\n" +
			"fechaIngr = ?,\n" +
			"carrera = ?,\n" +
			"cantMatAprob = ?,\n" +
			"promedio = ?,\n" +
			"estado = ?\n" +
			"where dni = ?\n";
		
                
 		actualizarPS = conexion.prepareStatement(sentencia);
		
		sentencia =
			"select *\n" +
			"from alumnos\n";
		
		getTodosPS = conexion.prepareStatement(sentencia);
                
                sentencia =
                        "select *\n" +
                        "from alumnos\n" + 
                        "where estado = 'A'\n";
                
                getAltasPS = conexion.prepareStatement(sentencia);
                
                sentencia =
                        "select *\n" +
                        "from alumnos\n" +
                        "where estado = 'B'\n";
                
                getBajasPS = conexion.prepareStatement(sentencia);
	}		
	
	
	
	@Override
	public void insertar(Alumno alu) throws DAOException
	{
		try
		{
			insertarPS.setInt(1, alu.getDni());
			insertarPS.setString(2, alu.getApyn());
			insertarPS.setDate(3, alu.getFechaNac().toDate());
			insertarPS.setString(4, String.valueOf(alu.getSexo()));
			insertarPS.setDate(5, alu.getFechaIngreso().toDate());
			insertarPS.setString(6, alu.getCarrera());
			insertarPS.setInt(7, alu.getCantMatAprob());
			insertarPS.setDouble(8, alu.getPromedio());
			
			insertarPS.executeUpdate();
		}
		catch(SQLException ex)
		{
			Logger.getLogger(AlumnoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
		
	}

	@Override
	public Alumno buscar(Integer id) throws DAOException
	{
            Alumno alu = new Alumno();
            try {
                existePS.setInt(1, id);
                ResultSet rs = existePS.executeQuery();
                if(rs.next()){
                    alu.setDni(rs.getInt("dni"));
                    alu.setApyn(rs.getString("apyn"));
                    alu.setFechaNac(new MiCalendar(rs.getDate("fechaNac")));
                    alu.setSexo(rs.getString("sexo").charAt(0));
                    alu.setCarrera(rs.getString("carrera"));
                    alu.setFechaIngreso(new MiCalendar(rs.getDate("fechaIngr")));
                    alu.setCantMatAprob(rs.getInt("cantMatAprob"));
                    alu.setPromedio(rs.getDouble("promedio"));
                    alu.setEstado(rs.getString("estado").charAt(0));
                }
            }catch(SQLException | PersonaInvalidaException ex)
            {
                    Logger.getLogger(AlumnoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DAOException(ex.getMessage());
            }
            
            return alu;
	}

	@Override
	public boolean existe(Integer id) throws DAOException
	{
            try {
                existePS.setInt(1, id);
                ResultSet rs = existePS.executeQuery();
                //return rs.getInt("value")>0;
                return rs.next();
            }catch(SQLException ex)
            {
                    Logger.getLogger(AlumnoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DAOException(ex.getMessage());
            }
            
            
        }

	@Override
	public void eliminar(Alumno alu) throws DAOException
	{
            try {
                eliminarPS.setInt(1, alu.getDni());
                eliminarPS.executeUpdate();
            }catch(SQLException ex)
            {
                    Logger.getLogger(AlumnoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DAOException(ex.getMessage());
            }		
        }

	@Override
	public void actualizar(Alumno alu) throws DAOException
	{
		int nro = 1;
		try
		{
			actualizarPS.setString(nro++, alu.getApyn());
			actualizarPS.setDate(nro++, alu.getFechaNac().toDate());
			actualizarPS.setString(nro++, String.valueOf(alu.getSexo()));
			actualizarPS.setDate(nro++, alu.getFechaIngreso().toDate());
			actualizarPS.setString(nro++, alu.getCarrera());
			actualizarPS.setInt(nro++, alu.getCantMatAprob());
			actualizarPS.setDouble(nro++, alu.getPromedio());
			actualizarPS.setString(nro++, String.valueOf(alu.getEstado()));
			actualizarPS.setInt(nro++, alu.getDni());
			
			actualizarPS.executeUpdate();
		}
		catch(SQLException ex)
		{
			Logger.getLogger(AlumnoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}		
	}

	@Override
	public List<Alumno> getTodos() throws DAOException
	{
		List<Alumno> alumnos = new LinkedList<>();
		
		try
		{
			ResultSet rs = getTodosPS.executeQuery();
			Alumno alu;
			while(rs.next())
			{
				alu = new Alumno();
				
				alu.setDni(rs.getInt("dni"));
				alu.setApyn(rs.getString("apyn"));
				alu.setFechaNac(new MiCalendar(rs.getDate("fechaNac")));
				alu.setSexo(rs.getString("sexo").charAt(0));
				alu.setCarrera(rs.getString("carrera"));
				alu.setFechaIngreso(new MiCalendar(rs.getDate("fechaIngr")));
				alu.setCantMatAprob(rs.getInt("cantMatAprob"));
				alu.setPromedio(rs.getDouble("promedio"));
				alu.setEstado(rs.getString("estado").charAt(0));
				
				alumnos.add(alu);
			}
		}
		catch(SQLException | PersonaInvalidaException ex)
		{
			Logger.getLogger(AlumnoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
		
		return alumnos;
	}
	
	
	@Override
	public List<Alumno> getAltas() throws DAOException
	{
                List<Alumno> alumnos = new LinkedList<>();
		
		try
		{
			ResultSet rs = getAltasPS.executeQuery();
			Alumno alu;
			while(rs.next())
			{
				alu = new Alumno();
				
				alu.setDni(rs.getInt("dni"));
				alu.setApyn(rs.getString("apyn"));
				alu.setFechaNac(new MiCalendar(rs.getDate("fechaNac")));
				alu.setSexo(rs.getString("sexo").charAt(0));
				alu.setCarrera(rs.getString("carrera"));
				alu.setFechaIngreso(new MiCalendar(rs.getDate("fechaIngr")));
				alu.setCantMatAprob(rs.getInt("cantMatAprob"));
				alu.setPromedio(rs.getDouble("promedio"));
				alu.setEstado(rs.getString("estado").charAt(0));
				
				alumnos.add(alu);
			}
		}
		catch(SQLException | PersonaInvalidaException ex)
		{
			Logger.getLogger(AlumnoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
		
		return alumnos;
        }

	@Override
	public List<Alumno> getBajas() throws DAOException
	{
                List<Alumno> alumnos = new LinkedList<>();
		
		try
		{
			ResultSet rs = getBajasPS.executeQuery();
			Alumno alu;
			while(rs.next())
			{
				alu = new Alumno();
				
				alu.setDni(rs.getInt("dni"));
				alu.setApyn(rs.getString("apyn"));
				alu.setFechaNac(new MiCalendar(rs.getDate("fechaNac")));
				alu.setSexo(rs.getString("sexo").charAt(0));
				alu.setCarrera(rs.getString("carrera"));
				alu.setFechaIngreso(new MiCalendar(rs.getDate("fechaIngr")));
				alu.setCantMatAprob(rs.getInt("cantMatAprob"));
				alu.setPromedio(rs.getDouble("promedio"));
				alu.setEstado(rs.getString("estado").charAt(0));
				
				alumnos.add(alu);
			}
		}
		catch(SQLException | PersonaInvalidaException ex)
		{
			Logger.getLogger(AlumnoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
		
		return alumnos;
        }
	
	
	
	private PreparedStatement insertarPS;
        private PreparedStatement buscarPS;
        private PreparedStatement existePS;
        private PreparedStatement eliminarPS; 
	private PreparedStatement actualizarPS;
	private PreparedStatement getTodosPS;
        private PreparedStatement getAltasPS;
        private PreparedStatement getBajasPS;
}
