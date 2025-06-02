package tp5.ejercicio5;
import practica1.ej8.Queue;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;
import java.util.*;

public class BancoItau {    
    private Vertex<Persona> buscarEmp(Graph<Persona> grafo, String empleado){
        // AGARRO LISTA DE VERTICES
        List<Vertex<Persona>> v = grafo.getVertices();
        Iterator<Vertex<Persona>> it = v.iterator();
        // CREO AUXILIAR DE PERSONA PARA DEVOLVERLO
        Vertex<Persona> per = null;
        boolean encontre = false;
        while (it.hasNext() && !encontre){
            Vertex<Persona> aux = it.next();
            if (aux.getData().getNombre().equals(empleado)){
                per = aux;
                encontre = true;
            }
        }
        
        return per;
    }    
    
    public List<Persona> listaJubilados(Graph<Persona> grafo, String empleado, int grado){
        if (!grafo.isEmpty()){
            // BUSCO AL EMPLEADO EN EL GRAFO
            Vertex<Persona> emp = buscarEmp(grafo,empleado);
            if (emp != null){
                List<Persona> jubilados = bfs(grafo,emp,grado);               
                return jubilados;
            }
        }
        return new LinkedList<>();
    }
    
    private List<Persona> bfs (Graph<Persona> grafo, Vertex<Persona> inicio, int grado){
        boolean [] visitados = new boolean [grafo.getSize()];
        List<Persona> jubilados = new LinkedList<>();
        // MARCO COMO VISITADO EL EMPLEADO
        visitados[inicio.getPosition()] = true;
        int gradoAct = 0;
        
        Queue<Vertex<Persona>> queue = new Queue<>();
        queue.enqueue(inicio);
        queue.enqueue(null);
        // CREO LA QUEUE Y ME FIJO SI EL GRADO ES EL CORRECTO Y SI NO ME PASE DE 40
        while (!queue.isEmpty() && gradoAct <= grado && jubilados.size() < 40){
            Vertex<Persona> v = queue.dequeue();
            if (v != null){
                // AGARRO EL VERTICE, ME FIJO SI ES UN JUBILADO Y LO AGREGO (.cumple())
                Persona per = v.getData();
                if (per.cumple()){
                    jubilados.add(per);
                }
                // ENCOLO ADYACENTES NO VISITADOS DEL VERTICE EN PROCESO
                List<Edge<Persona>> adyacentes = grafo.getEdges(v);
                for (Edge<Persona> edge : adyacentes){
                    Vertex<Persona> ady = edge.getTarget();
                    int j = edge.getTarget().getPosition();
                    if (!visitados[j]){
                        visitados[j] = true;
                        queue.enqueue(ady);
                    }                
                }
            // AUMENTO EL GRADO PAAR PROCESAR EL PROXIMO NIVEL, ENCOLO NULL MARCA DE NIVEL
            } else if (!queue.isEmpty()){
                gradoAct++;
                queue.enqueue(null);
            }
        }
        
        return jubilados;
    }

    // PRUEBAS
     public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex v1 = grafo.createVertex(new Persona("Empleado", "Matias", "AAA", true));
        Vertex v2 = grafo.createVertex(new Persona("Jubilado", "Julian", "BBB", false));
        Vertex v3 = grafo.createVertex(new Persona("Jubilado", "Francisco", "CCC", false));
        Vertex v4 = grafo.createVertex(new Persona("Empleado", "Valentin", "DDD", true));
        Vertex v5 = grafo.createVertex(new Persona("Jubilado", "Omar", "EEE", true));
        Vertex v6 = grafo.createVertex(new Persona("Empleado", "Rosana", "FFF", true));
        Vertex v7 = grafo.createVertex(new Persona("Jubilado", "Maria", "GGG", false));
        Vertex v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", "HHH", true));
        Vertex v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", "III", false));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);  
        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);  
        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
        
        BancoItau banco = new BancoItau();
        System.out.println(banco.listaJubilados(grafo, "Matias", 2));

    }   
}




