package practicaParciales.Grafos;
import practica1.ej8.Queue;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;
import java.util.*;

public class ParcialGrafos {

    public List<Camino> todosLosCaminosConMayorRiesgo(Graph<String> mapaCiudad, String inicio, String fin){
        List<Camino> caminos = new ArrayList<>();
        if(mapaCiudad != null && !mapaCiudad.isEmpty()){
            Vertex<String> origen = mapaCiudad.search(inicio);
            Vertex<String> destino = mapaCiudad.search(fin);
            if(origen != null && fin != null)
                buscar(mapaCiudad, origen,destino, caminos, new ArrayList<>(), -1,new boolean[mapaCiudad.getSize()]);
        }
        return caminos;
    }

    private void buscar(Graph<String> grafo, Vertex<String> actual, Vertex<String> destino, List<Camino> caminos,
                        List<String> caminoActual, int maxNivel, boolean[] marcas){
        marcas[actual.getPosition()] = true;
        caminoActual.add(actual.getData());
        if (actual.getData().equals(destino.getData())){
            Camino caminoNuevo = new Camino(new ArrayList<>(caminoActual), maxNivel);
            caminos.add(caminoNuevo);
        }
        else {
            List<Edge<String>> aristas = grafo.getEdges(actual);
            for(Edge<String> a: aristas){
                Vertex<String> ady = a.getTarget();
                int nuevoMax = maxNivel;
                if (a.getWeight() > nuevoMax) {
                    nuevoMax = a.getWeight();
                }
                if (!marcas[ady.getPosition()]) {
                    buscar(grafo, ady, destino, caminos, caminoActual, nuevoMax, marcas);
                }
            }
        }
        marcas[actual.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }
    
    public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> mendoza = grafo.createVertex("Mendoza");
        Vertex<String> tunuyan = grafo.createVertex("Tunuyan");
        Vertex<String> malargue = grafo.createVertex("Malargue");
        Vertex<String> sanMartin = grafo.createVertex("San Martin");
        Vertex<String> sanRafael = grafo.createVertex("San Rafael");
        Vertex<String> generalAlvear = grafo.createVertex("General Alvear");
        Vertex<String> laPaz = grafo.createVertex("La Paz");
        Vertex<String> santaRosa = grafo.createVertex("Santa Rosa");

        grafo.connect(mendoza, tunuyan, 10);
        grafo.connect(mendoza, sanMartin, 6);
        grafo.connect(tunuyan, malargue, 24);
        grafo.connect(tunuyan, sanMartin, 10);
        grafo.connect(generalAlvear, malargue, 6);
        grafo.connect(sanMartin, sanRafael, 15);
        grafo.connect(sanMartin, laPaz, 8);
        grafo.connect(sanRafael, generalAlvear, 7);
        grafo.connect(sanRafael, tunuyan, 11);
        grafo.connect(laPaz, santaRosa, 2);


        ParcialGrafos parcial = new ParcialGrafos();
        List<Camino> caminos = parcial.todosLosCaminosConMayorRiesgo(grafo, "Mendoza", "Malargue");

        System.out.println("Caminos de Mendoza a Malargue:");
        for (Camino c : caminos) {
            System.out.println("Camino: " + c.getCamino() + " | Max. nivel de agua: " + c.getMax());
            System.out.println(" ");
        }
    }
}
