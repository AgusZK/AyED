package tp5.ejercicio3;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.adjList.AdjListGraph;
import java.util.*;
public class Mapa {
    private final Graph<String> grafoCiudades;
    
    public Mapa(Graph<String> ciudades){
        this.grafoCiudades = ciudades;
    }
    
    
    /*--------------------------------------------------------------------------*/
        // INCISO 1
    public List<String> devolverCamino(String ciudad1, String ciudad2){
        List<String> path = new LinkedList<>();
        if (!this.grafoCiudades.isEmpty()){
            // BUSCO EN EL GRAFO EL ORIGEN Y EL DESTINO
            Vertex<String> inicio = grafoCiudades.search(ciudad1);
            Vertex<String> fin = grafoCiudades.search(ciudad2);
            boolean [] visitados = new boolean[grafoCiudades.getSize()];

            // SI LAS 2 CIUDADES EXISTEN, LARGO DFS
            if (inicio != null && fin != null){
                dfsCamino(inicio,fin,visitados,path);
            }
        }
        return path;
    }
    
    private boolean dfsCamino (Vertex<String> inicio, Vertex<String> fin, boolean[] visitados, List<String> path){
        // MARCO COMO VISITADO EL ORIGEN
        boolean encontre = false;
        visitados[inicio.getPosition()] = true;
        path.add(inicio.getData());
        
        // SI LLEGO AL FINAL CORTO
        if (inicio == fin){
            return true;
        }
        // AGARRO LISTA DE ADYACENTES DEL ORIGEN E ITERO
        List<Edge<String>> ady = grafoCiudades.getEdges(inicio);
        Iterator<Edge<String>> it = ady.iterator();
        while (it.hasNext() && !encontre){
            // AGARRO EL VERTICE Y ME QUEDO SU POSICION
            Vertex<String> v = it.next().getTarget();
            int j = v.getPosition();
            // SI NO FUE VISITADO RECORRO RECURSIVO
            if (!visitados[j]){
                encontre = dfsCamino(v,fin,visitados,path);
            }
        }
        if (!encontre){
            path.remove(path.size() - 1);
        }
        
        return encontre;
    }
    
/*--------------------------------------------------------------------------*/
    // INCISO 2
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
        List<String> path = new LinkedList<>();
        if (!this.grafoCiudades.isEmpty()){
            Vertex<String> inicio = grafoCiudades.search(ciudad1);
            Vertex<String> fin = grafoCiudades.search(ciudad2);
            boolean [] visitados = new boolean[grafoCiudades.getSize()];     
            if (inicio != null && fin != null ){
                // MARCO COMO VISITADOS LAS QUE NO PUEDO VISITAR
                for(String nom: ciudades){
                    Vertex<String> v = grafoCiudades.search(nom);
                    if(v != null){
                        visitados[v.getPosition()] = true;
                    }
                }
                // LARGO DFS
                dfsExc(inicio,fin,visitados,ciudades,path);
            }
        } 
        return path;
    }
    
    private boolean dfsExc(Vertex<String> inicio, Vertex<String> fin, boolean [] visitados, List<String> ciudades, List<String> path){
        boolean encontre = false;
        path.add(inicio.getData());
        visitados[inicio.getPosition()] = true;
        
        if (inicio == fin){
            return true;
        }
        
        List<Edge<String>> ady = grafoCiudades.getEdges(inicio);
        Iterator<Edge<String>> it = ady.iterator();
        while (it.hasNext() && !encontre){
            Edge<String> v = it.next();
            int j = v.getTarget().getPosition();
            if (!visitados[j]){
                encontre = dfsExc(v.getTarget(),fin,visitados,ciudades,path);
            }
        }
        
        if (!encontre){
            path.remove(path.size() - 1);
        }
        
        return encontre;
    }
    
  /*--------------------------------------------------------------------------*/
    // INCISO 3
   public List<String> caminoMasCorto(String ciudad1, String ciudad2){
       List<String> pathMin = new LinkedList<>();
       if (!this.grafoCiudades.isEmpty()){
        Vertex<String> inicio = grafoCiudades.search(ciudad1);
        Vertex<String> fin = grafoCiudades.search(ciudad2);
        boolean [] visitados = new boolean [grafoCiudades.getSize()];
        if (inicio != null && fin != null){
            dfsCorto(inicio,fin,visitados, pathMin, new LinkedList<>(),0 , Integer.MAX_VALUE);
        }
       } 
       return pathMin;
   }
   
   private int dfsCorto (Vertex<String> inicio, Vertex<String> fin, boolean [] visitados,List<String> pathMin, List<String> pathAct, int total, int min){
       pathAct.add(inicio.getData());
       visitados[inicio.getPosition()] = true;
       
       // SI LLEGO A DESTINO, ME FIJO SI ES MAS CHICO QUE EL QUE YA TENGO
       if (inicio == fin){
           if (total < min){
               pathMin.removeAll(pathMin);
               pathMin.addAll(pathAct);
               min = total;
           }
       }
       
       List<Edge<String>> ady = grafoCiudades.getEdges(inicio);
       Iterator<Edge<String>> it = ady.iterator();
       while (it.hasNext() && total < min){
           // AGARRO LA ARISTA
           Edge<String> v = it.next();
           // GUARDO LA POS
           int j = v.getTarget().getPosition();
           // SUMO EL PESO DE LA ARISTA
           int auxSum = total + v.getWeight();
           // SI NO FUE VISITADO Y EL PESO ES MENOR, RECORRO RECURSIVO
           // PASO AUXSUM = TOTAL PARA NO PERDER LA CUENTA
           if (!visitados[j] && auxSum < min){
               min = dfsCorto(v.getTarget(),fin,visitados,pathMin, pathAct, auxSum, min);
           }
       }
       
       // BACK TRACKING PERO DESMARCO YA QUE TENGO QUE FIJARME TODAS LAS POSIBILIDADES
       visitados[inicio.getPosition()] = false;
       pathAct.remove(pathAct.size() - 1);
       
       return min;
   }
   /*--------------------------------------------------------------------------*/
    // INCISO 4
   public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
       List<String> path = new LinkedList<>();
       if (!this.grafoCiudades.isEmpty()){
        Vertex<String> inicio = grafoCiudades.search(ciudad1);
        Vertex<String> fin = grafoCiudades.search(ciudad2);
        boolean [] visitados = new boolean [grafoCiudades.getSize()];

        if (inicio != null && fin != null){
            dfsSinCargar(inicio,fin,visitados,path,tanqueAuto);
        }
       }
       
       return path;
   }
   
   private boolean dfsSinCargar (Vertex<String> inicio , Vertex<String> fin , boolean[] visitados, List<String> path, int tanqueAuto){
       boolean encontre = false;
       visitados[inicio.getPosition()] = true;
       path.add(inicio.getData());
       
       if (inicio == fin){
           return true;
       }
       
       List<Edge<String>> ady = grafoCiudades.getEdges(inicio);
       Iterator<Edge<String>> it = ady.iterator();
       while (it.hasNext() && !encontre){
           Edge<String> v = it.next();
           int j = v.getTarget().getPosition();
           // SI NO ESTA VISITADO, ME FIJO QUE EL TRAYECTO ALCANCE PARA EL TANQUE
           // ACTUALIZO COMBUSTIBLE DEL TANQUE Y LO PASO PARA NO PERDERLO
           if (!visitados[j] && tanqueAuto - v.getWeight() > 0){
               encontre = dfsSinCargar(v.getTarget(),fin,visitados,path,tanqueAuto - v.getWeight());
           }
       }
       
       if (!encontre){
           path.remove(path.size() - 1);
       }
       visitados[inicio.getPosition()] = false;
       return encontre;
   }
   /*--------------------------------------------------------------------------*/
    // INCISO 5
   public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
       List<String> pathMin = new LinkedList<>();
       if (!this.grafoCiudades.isEmpty()){
           Vertex<String> inicio = grafoCiudades.search(ciudad1);
           Vertex<String> fin = grafoCiudades.search(ciudad2);
           boolean [] visitados = new boolean[grafoCiudades.getSize()];
           if (inicio != null && fin != null){
               dfsMenorCarga(inicio,fin,visitados,pathMin, new LinkedList<String>(), tanqueAuto, tanqueAuto, 0 , Integer.MAX_VALUE);
           }
       }
       
       return pathMin;
   }
   
   private int dfsMenorCarga(Vertex<String> inicio, Vertex<String> fin, boolean [] visitados, List<String> pathMin , List<String> pathAct, int tanqueActual, int tanque, int recargas, int recargasMin){
       visitados[inicio.getPosition()] = true;
       pathAct.add(inicio.getData());
       
       if (inicio == fin){
           // ME QUEDO CON EL CAMINO QUE TENGA MENOS RECARGAS, ES DECIR, QUE SE TUVO QUE RELLENAR MENOS
           if (recargas < recargasMin){
               pathMin.removeAll(pathMin);
               pathMin.addAll(pathAct);
               recargasMin = recargas;
           }
       }
       
       List<Edge<String>> ady = grafoCiudades.getEdges(inicio);
       Iterator<Edge<String>> it = ady.iterator();
       while (it.hasNext() && recargas < recargasMin){
           Edge<String> v = it.next();
           int j = v.getTarget().getPosition();
           int dis = v.getWeight();
           // SI NO ESTA VISITADO ME FIJO:
           if (!visitados[j]){
               // SI EL TANQUE ACTUAL ALCANZA PARA LA DISTANCIA, ACTUALIZO CON TANQUEACT - DIS
               if (tanqueActual >= dis){
                   recargasMin = dfsMenorCarga(v.getTarget(),fin,visitados,pathMin,pathAct, tanqueActual - dis, tanque, recargas, recargasMin);       
               }
               // SINO SUMO 1 EN RECARGAS, Y EL TANQUE ACTUAL ES EL LLENO - DISTANCIA
               else if (tanque >= dis){
                   recargasMin = dfsMenorCarga (v.getTarget(),fin,visitados,pathMin,pathAct, tanque - dis, tanque, recargas + 1, recargasMin);
               }
           }
        }
       
        visitados[inicio.getPosition()] = false;
        pathAct.remove(pathAct.size() - 1);
        return recargasMin;
    }
   
   // PRUEBAS COPIADO DE GH PQ NI GANAS DE HACER EL MAIN
    public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        Mapa mapa = new Mapa(mapaCiudades);
        
        System.out.print("LISTA DEVOLVER CAMINO: ");
        System.out.println(mapa.devolverCamino("La Plata", "San Vicente"));

        
        System.out.print("LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:");
        List<String> restringidos = new LinkedList<String>();
        restringidos.add("Berisso");
        System.out.println(mapa.devolverCaminoExceptuando("La Plata", "San Vicente", restringidos));
        
        
        System.out.print("LISTA CAMINO MAS CORTO EN DISTANCIA: ");
        System.out.println(mapa.caminoMasCorto("La Plata", "San Vicente"));

        System.out.print("LISTA CAMINO SIN CARGAR COMBUSTIBLE: ");
        System.out.println(mapa.caminoSinCargarCombustible("La Plata", "San Vicente", 30));
        
        System.out.print("LISTA CAMINO CON MENOR CARGA DE COMBUSTIBLE: ");
        System.out.println(mapa.caminoConMenorCargaDeCombustible("La Plata", "San Vicente", 10));

    }
}
