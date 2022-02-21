package dominio;

import java.util.List;
import model.Materia;

public interface IMateriaDAO {
    public List<Materia> GetAll();
    
    public Materia GetById(int idMateria);
    
    public int Add(Materia materia);
    
    public int Update(Materia materia);
    
    public int Delete(int idMateria);
}
