package model;

public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    
    //constructores
    
    public Alumno() {
    }
    
    public Alumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public Alumno(int idAlumno, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    } 
    
    //setters y getters

    public int getIdAlumno() {
        return idAlumno;
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    
}
