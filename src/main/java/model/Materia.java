package model;

public class Materia {
    private int idMateria;
    private String nombre;
    private double costo;
    
    // constructores
    
    public Materia(){
        
    }
    
    public Materia(int idMateria) {
        this.idMateria = idMateria;
    }
    
    public Materia(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }
    
    public Materia(int idMateria, String nombre, double costo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.costo = costo;
    }
    
    //getters y setters

    public int getIdMateria() {
        return idMateria;
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
