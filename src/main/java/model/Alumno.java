package model;

public class Alumno {
    private int idAlumno;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    
    public Alumno() {
    }
    
    public Alumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    public Alumno(String nombre, String ApellidoPaterno, String ApellidoMaterno) {
        this.Nombre = nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public Alumno(int idAlumno, String Nombre, String ApellidoPaterno, String ApellidoMaterno) {
        this.idAlumno = idAlumno;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
    } 

    public int getIdAlumno() {
        return idAlumno;
    }    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }
    
    
    
}
