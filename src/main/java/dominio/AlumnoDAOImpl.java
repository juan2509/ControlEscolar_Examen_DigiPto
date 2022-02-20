package dominio;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;

public class AlumnoDAOImpl implements IAlumnoDAO {

    @Override
    public List<Alumno> GetAll() {
        List<Alumno> alumnos = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumno alumno = null;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("CALL AlumnoGetAll");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                int idAlumno = rs.getInt("IdAlumno");
                String nombre = rs.getString("Nombre");
                String apellidoPaterno = rs.getString("ApellidoPaterno");
                String apellidoMaterno = rs.getString("ApellidoMaterno");
                
                alumno = new Alumno(idAlumno, nombre, apellidoPaterno, apellidoMaterno);
                
                alumnos.add(alumno);
            }
            
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        
        return alumnos;
    }

    @Override
    public Alumno GetById(int idAlumno) {
        Alumno alumno = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("SELECT IdAlumno, Nombre, ApellidoPaterno, ApellidoMaterno FROM alumno WHERE IdAlumno = ?");
            
            stmt.setInt(1, idAlumno);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("IdAlumno");
                String nombre = rs.getString("Nombre");
                String apellidoPaterno = rs.getString("ApellidoPaterno");
                String apellidoMaterno = rs.getString("ApellidoMaterno");
                
                alumno = new Alumno(id, nombre, apellidoPaterno, apellidoMaterno);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        
        return alumno;
    }

    @Override
    public int Add(Alumno alumno) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("INSERT INTO alumno(Nombre, ApellidoPaterno, ApellidoMaterno) VALUES (?,?,?)");
            
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellidoPaterno());
            stmt.setString(3, alumno.getApellidoMaterno());
            
            rowsAffected = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        
        return rowsAffected;
    }

    @Override
    public int Update(Alumno alumno) {        
        Connection con = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("UPDATE alumno SET Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ? WHERE IdAlumno = ?");
            
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellidoPaterno());
            stmt.setString(3, alumno.getApellidoMaterno());
            stmt.setInt(4, alumno.getIdAlumno());
            
            rowsAffected = stmt.executeUpdate();
            
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
                
        return rowsAffected;
    }

    @Override
    public int Delete(int idAlumno) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("DELETE FROM alumno WHERE IdAlumno = ?");
            
            stmt.setInt(1, idAlumno);
            
            rowsAffected = stmt.executeUpdate();
            
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }        
        
        return rowsAffected;
    }
    
}
