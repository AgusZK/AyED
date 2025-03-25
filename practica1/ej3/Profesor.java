package practica1.ej3;


public class Profesor extends Persona{
    private int catedra;
    private String facultad;

    public Profesor(String nombre,String apellido, String email,int catedra, String facultad) {
        super(nombre, apellido, email);
        this.catedra = catedra;
        this.facultad = facultad;
    }

    public int getCatedra() {
        return catedra;
    }

    public void setCatedra(int catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    @Override
    public String tusDatos(){
        String s = super.tusDatos() + " catedra " + this.getCatedra() + " facultad: " + this.getFacultad();
        return s;
    }
}
