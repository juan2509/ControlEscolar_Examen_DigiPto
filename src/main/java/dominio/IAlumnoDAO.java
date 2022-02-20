package dominio;

import java.util.List;
import model.Alumno;

public interface IAlumnoDAO {
    public List<Alumno> GetAll();
    
    public Alumno GetById(int idAlumno);
    
    public int Add(Alumno alumno);
    
    public int Update(Alumno alumno);
    
    public int Delete(int idAlumno);
}
