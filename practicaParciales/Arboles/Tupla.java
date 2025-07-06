package practicaParciales.Arboles;
public class Tupla {
    private int suma;
    private int diferencia;
    
    public Tupla(int suma, int diferencia){
        this.suma = suma;
        this.diferencia = diferencia;
    }
    
    public String toString() {
        return "(" + suma + " | " + diferencia +")" ;
    }

}
