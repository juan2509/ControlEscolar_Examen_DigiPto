package dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Materia;
import conexion.Conexion;

public class MateriaADOImpl implements IMateriaDAO {

    @Override
    public List<Materia> GetAll() {
        List<Materia> materias = new ArrayList<>();
        Materia materia = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("CALL MateriaGetAll()");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("IdMateria");
                String nombre = rs.getString("Nombre");
                double costo = rs.getDouble("Costo");
                
                materia = new Materia(id, nombre, costo);
                
                materias.add(materia);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        
        return materias;
    }

    @Override
    public Materia GetById(int idMateria) {
        Materia materia = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("CALL MateriaGetById(?) ");
            
            stmt.setInt(1, idMateria);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("IdMateria");
                String nombre = rs.getString("Nombre");
                double costo = rs.getDouble("Costo");
                
                materia = new Materia(id, nombre, costo);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        
        return materia;
    }

    @Override
    public int Add(Materia materia) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("CALL MateriaAdd(?,?)");
            
            stmt.setString(1, materia.getNombre());
            stmt.setDouble(2, materia.getCosto());
            
            rowsAffected = stmt.executeUpdate();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }  finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        
        return rowsAffected;
    }

    @Override
    public int Update(Materia materia) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("CALL MateriaUpdate(?,?,?)");
            
            stmt.setInt(1, materia.getIdMateria());
            stmt.setString(2, materia.getNombre());
            stmt.setDouble(3, materia.getCosto());
            
            rowsAffected = stmt.executeUpdate();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }  finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        
        return rowsAffected;
    }

    @Override
    public int Delete(int idMateria) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement("CALL MateriaDelete(?)");
            
            stmt.setInt(1, idMateria);
            
            rowsAffected = stmt.executeUpdate();
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }  finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        
        return rowsAffected;
    }
    
}
