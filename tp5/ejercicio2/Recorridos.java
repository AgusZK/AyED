package tp5.ejercicio2;
import practica1.ej8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.adjList.AdjListGraph;
import java.util.ArrayList;
import java.util.List;

public class Recorridos<T> {
    public List<T> dfs (Graph<T> graph){
        boolean[] marca = new boolean[graph.getSize()];
        List<T> path = new ArrayList<>();
        for (int i = 0 ; i < graph.getSize(); i++){
            if(!marca[i]){
                dfs(graph,i,marca,path);
            }
        }

        return path;
    }

    public void dfs(Graph<T> graph, int i, boolean[] marca , List<T> path){
        // MARCO COMO VISITADO
        marca[i] = true;
        // AGARRO EL VERTICE
        Vertex<T> v = graph.getVertex(i);
        // AGARRO SU LISTA DE ADYACENCIAS
        List<Edge<T>> ady = graph.getEdges(v);

        // AGREGO A LA LISTA EL DATO DEL VERTICE
        path.add(v.getData());
        for (Edge<T> e: ady){
            // AGARRO LA POSICION AL QUE APUNTA EL VERTICE
            int adyPos = e.getTarget().getPosition();
            // SI NO ESTA VISITADO, RECORRO RECURSIVO CON ESE
            if (!marca[adyPos]){
                dfs(graph,adyPos,marca,path);
            }
        }
    }

    public List<T> bfs (Graph<T> graph){
        boolean[] marca = new boolean[graph.getSize()];
        List<T> path = new ArrayList<>();
        for (int i = 0 ; i < graph.getSize(); i++){
            if(!marca[i]){
                bfs(graph,i,marca,path);
            }
        }
        return path;
    }

    public void bfs (Graph<T> graph, int i, boolean[] marca, List<T> path){
        Queue<Vertex<T>> queue = new Queue<>();
        // ENCOLO Y MARCO COMO VISITADO
        queue.enqueue(graph.getVertex(i));
        marca[i] = true;

        while (!queue.isEmpty()){
            // AGARRO EL VERTICE
            Vertex<T> v = queue.dequeue();
            // AGREGO EL DATO DEL VERTICE
            path.add(v.getData());
            // PARA CADA UNO DE SU LISTA DE ADYACENTES, RECORRO SI NO ESTA VISITADO
            for (Edge<T> ady: graph.getEdges(v)){
                int adyPos = ady.getTarget().getPosition();
                // SI NO ESTA VISITADO, LO ENCOLO Y LO MARCO COMO VISITADO
                if (!marca[adyPos]){
                    marca[adyPos] = true;
                    queue.enqueue(ady.getTarget());
                }
            }
        }
    }
    
     public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> a = grafo.createVertex("A");
        Vertex<String> b = grafo.createVertex("B");
        Vertex<String> c = grafo.createVertex("C");
        Vertex<String> d = grafo.createVertex("D");
        Vertex<String> e = grafo.createVertex("E");


        grafo.connect(a, b);
        grafo.connect(a, c);
        grafo.connect(b, d);
        grafo.connect(c, d);
        grafo.connect(d, e);

        grafo.connect(b, a);
        grafo.connect(c, a);
        grafo.connect(d, b);
        grafo.connect(d, c);
        grafo.connect(e, d);

        Recorridos<String> recorridos = new Recorridos<>();
        List<String> dfsResult = recorridos.dfs(grafo);
        System.out.println(dfsResult);
        List<String> bfsResult = recorridos.bfs(grafo);
        System.out.println(bfsResult);
    }
}
