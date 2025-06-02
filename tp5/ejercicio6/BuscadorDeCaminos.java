package tp5.ejercicio6;
import practica1.ej8.Queue;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;
import java.util.*;


public class BuscadorDeCaminos {
    
    private Graph<String> bosque;
    
    public BuscadorDeCaminos(Graph<String> bosque){
        this.bosque = bosque;
    }
    
    public List<List<String>> recorridoMasSeguro(){
        List<List<String>> caminos = new LinkedList<List<String>>();
        if (!this.bosque.isEmpty()){
            Vertex<String> inicio = bosque.search("Casa Caperucita");
            // SI ENCUENTRO LA CASA, INICIALIZO MARCAS Y LARGO BFS CON CAMINO Y CAMINO ACTUAL
            if (inicio != null){
                boolean [] visitados = new boolean [bosque.getSize()];
                bfs(inicio,visitados,caminos, new LinkedList<String>());
            }
        }
        
        return caminos;
    }
    
    private void bfs (Vertex<String> inicio, boolean [] visitados, List<List<String>> caminos,List<String> camAct){
        visitados[inicio.getPosition()] = true;
        camAct.add(inicio.getData());
        
        // SI LLEGO AL FINAL, AGREGO EL CAMINO A LA LISTA DE CAMINOS
        if (inicio.getData().equals("Casa Abuelita")){
            caminos.add(new LinkedList(camAct));
        }
        
        // ENCOLO ADYACENTES Y CHECKEO CONDICION DEL CAMINO
        List<Edge<String>> adyacentes = bosque.getEdges(inicio);
        for (Edge<String> a: adyacentes ){
            Vertex<String> ady = a.getTarget();
            int j = a.getTarget().getPosition();
            // SI NO LO VISITE Y LAS FRUTAS SON MENOS DE 5
            if (!visitados[j] && a.getWeight() < 5){
                bfs(a.getTarget(),visitados,caminos,camAct);
            }
        }
        
        visitados[inicio.getPosition()] = false;
        camAct.remove(camAct.size() - 1);
    }
    
    // PRUEBAS COPIADO GH
        public static void main (String[] args) {
        Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        BuscadorDeCaminos bos = new BuscadorDeCaminos(bosque);
        List<List<String>> lis = bos.recorridoMasSeguro();
        for(List<String> l: lis) {
            System.out.println(l);
        }

    }
}
