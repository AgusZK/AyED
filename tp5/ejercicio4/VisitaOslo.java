package tp5.ejercicio4;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.adjList.AdjListGraph;
import java.util.*;

public class VisitaOslo {
    
    public List<String> paseoEnBici(Graph<String> lugares, String destino,int maxTiempo, List<String> lugaresRestringidos){
        List<String> path = new LinkedList<>();
        if (!lugares.isEmpty()){
            Vertex<String> inicio = lugares.search("Ayuntamiento");
            Vertex<String> fin = lugares.search(destino);
            boolean [] visitados = new boolean[lugares.getSize()];
            if (inicio != null && fin != null){
                // MARCO COMO VISITADOS LOS QUE NO PUEDO PISAR
                for (String nom: lugaresRestringidos){
                    Vertex<String> v = lugares.search(nom);
                    if (v != null){
                        visitados[v.getPosition()] = true;
                    }
                }
                // LARGO DFS
                dfsBici(lugares,inicio,fin,visitados,path,maxTiempo);
            }
        }
        
        return path;
    }
    
    private boolean dfsBici(Graph<String> lugares, Vertex<String> inicio, Vertex<String> fin, boolean [] visitados, List<String> path, int maxTiempo){
        boolean encontre = false;
        visitados[inicio.getPosition()] = true;
        path.add(inicio.getData());
        
        if (inicio == fin){
            return true;
        }
        
        List<Edge<String>> ady = lugares.getEdges(inicio);
        Iterator<Edge<String>> it = ady.iterator();
        
        while (it.hasNext() && !encontre){
            Edge<String> v = it.next();
            int j = v.getTarget().getPosition();
            // SI NO ESTA VISITADO Y EL TIEMPO - TARDANZA ALCANZA, RECORRO LOS DEMAS
            if (!visitados[j] && maxTiempo - v.getWeight() > 0){
                encontre = dfsBici(lugares,v.getTarget(),fin,visitados,path,maxTiempo - v.getWeight());
            }
        }
        if (!encontre){
            path.remove(path.size() - 1);
        }
        
        visitados[inicio.getPosition()] = false;
        return encontre;
    }
    
    // PRUEBA EN EL MAIN
    public static void main(String[] args) {
        Graph<String> lugares = new AdjListGraph<String>();
        Vertex<String> v1 = lugares.createVertex("Holmenkollen");
        Vertex<String> v2 = lugares.createVertex("Parque Vigeland");
        Vertex<String> v3 = lugares.createVertex("Galería Nacional");
        Vertex<String> v4 = lugares.createVertex("Parque Botánico");
        Vertex<String> v5 = lugares.createVertex("Museo Munch");
        Vertex<String> v6 = lugares.createVertex("FolkMuseum");
        Vertex<String> v7 = lugares.createVertex("Palacio Real");
        Vertex<String> v8 = lugares.createVertex("Ayuntamiento");
        Vertex<String> v9 = lugares.createVertex("El Tigre");
        Vertex<String> v10 = lugares.createVertex("Akker Brigge");
        Vertex<String> v11 = lugares.createVertex("Museo Fram");
        Vertex<String> v12 = lugares.createVertex("Museo Vikingo");
        Vertex<String> v13 = lugares.createVertex("La Opera");
        Vertex<String> v14 = lugares.createVertex("Museo del Barco Polar");
        Vertex<String> v15 = lugares.createVertex("Fortaleza Akershus");   
        
        lugares.connect(v1, v2, 30);
        lugares.connect(v2, v1, 30);
        lugares.connect(v2, v3, 10);
        lugares.connect(v3, v2, 10);
        lugares.connect(v3, v4, 15);
        lugares.connect(v4, v3, 15);
        lugares.connect(v4, v5, 1);
        lugares.connect(v5, v4, 1);
        
        lugares.connect(v5, v9, 15);
        lugares.connect(v9, v5, 15);
        lugares.connect(v9, v13, 5);
        lugares.connect(v13, v9, 5);
        lugares.connect(v13, v15, 10);
        lugares.connect(v15, v13, 10);
        
        lugares.connect(v2, v6, 20);
        lugares.connect(v6, v2, 20);
        lugares.connect(v6, v7, 5);
        lugares.connect(v7, v6, 5);
        lugares.connect(v7, v8, 5);
        lugares.connect(v8, v7, 5);
        lugares.connect(v6, v10, 30);
        lugares.connect(v10, v6, 30);
        lugares.connect(v10, v8, 20);
        lugares.connect(v8, v10, 20);
        lugares.connect(v8, v4, 10);
        lugares.connect(v4, v8, 10);
        lugares.connect(v8, v9, 15);
        lugares.connect(v9, v8, 15);
        
        lugares.connect(v6, v11, 5);
        lugares.connect(v11, v6, 5);
        lugares.connect(v10, v12, 30);
        lugares.connect(v12, v10, 30);
        lugares.connect(v11, v14, 5);
        lugares.connect(v14, v11, 5);
        lugares.connect(v12, v14, 5);
        lugares.connect(v14, v12, 5);
        
        List<String> lugaresRestringidos = new LinkedList<String>();
        //Debe retornar el primer camino que encuentre que cumple las restricciones
        //Ejemplos de posibles caminos a retornar, sin pasar por “Akker Brigge” y “Palacio Real” 
        // en no más de120 min (maxTiempo)
        lugaresRestringidos.add("Akker Brigge");
        lugaresRestringidos.add("Palacio Real");
        VisitaOslo vis = new VisitaOslo();
        List<String> path = vis.paseoEnBici(lugares, "Museo Vikingo", 120, lugaresRestringidos);
        
        System.out.println("Camino sin pasar por Akker Brigge ni por Palacio Real con limite de 120 minutos");
        System.out.println("(modificar int para probar menos tiempo (20 es el minimo), y strings para ciudades restringides)");
        System.out.println(path);
    }
}
