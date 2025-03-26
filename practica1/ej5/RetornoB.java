package practica1.ej5;


public class RetornoB {
    private double min,max,avg;

    public void setMin(double min) {
        this.min = min;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
    
    public String toString(){
        String s;
        s="Minimo: " + this.min + " Max: " + this.max + " Promedio: " + this.avg;
        return s;
    }
}
