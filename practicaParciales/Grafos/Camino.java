package practicaParciales.Grafos;
import java.util.*;
public class Camino {
    private List<String> camino;
    private int max;

    public Camino(List<String> camino, int max) {
        this.max = max;
        this.camino = camino;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<String> getCamino() {
        return camino;
    }

    public void setCamino(List<String> camino) {
        this.camino = camino;
    }
}
