package practica3;
import practica1.ej8.Queue;
import java.util.LinkedList;
import java.util.List;

// EJERCICIO 2
public class RecorridosAG {

    // PRE ORDEN
    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> l = new LinkedList<>();
        // LLAMO AL METODO CON 3 PARAMETROS PARA NO PERDER LISTA
        numerosImparesMayoresQuePreOrden(a,n,l);
        return l;     
    }
    
    public void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n,List l){
        if (a.isEmpty()){
            return;
        }
        
        if (a.getData() > n && a.getData() % 2 != 0){
            l.add(a.getData());
        }
        
        if (a.hasChildren()){
            for (GeneralTree<Integer> child: a.getChildren()){
                numerosImparesMayoresQuePreOrden(child,n,l);
            }
        }
    }
    
    // IN ORDEN
    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> l = new LinkedList<>();
        // LLAMO AL METODO CON 3 PARAMETROS PARA NO PERDER LISTA
        numerosImparesMayoresQueInOrden(a,n,l);
        return l;     
    }
    
    public void numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n, List l){
        if (a.isEmpty()){
           return;
        }
        
        // SE PROCESA PRIMER HIJO (0), RAIZ Y DESPUES EL RESTO DE HIJOS  
        if (a.hasChildren()){
            numerosImparesMayoresQueInOrden(a.getChildren().get(0),n,l);
        }
        
        if (a.getData() > n && a.getData() % 2 != 0){
            l.add(a.getData());
        }
        
        // SI TIENE HIJOS DESPUES DE PROCESAR DEL PRIMERO, PROCESO A PARTIR DEL 2DO EN ADELANTE
        if (a.hasChildren()){
            for (int i = 1; i < a.getChildren().size() ; i++){
                numerosImparesMayoresQueInOrden(a.getChildren().get(i),n,l);
            }              
        }       
    }
    
    // POST ORDEN
    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> l = new LinkedList<>();
        // LLAMO AL METODO CON 3 PARAMETROS PARA NO PERDER LISTA
        numerosImparesMayoresQuePostOrden(a,n,l);
        return l;     
    }
    
    public void numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n, List l){
        if (a.isEmpty()){
            return;
        }
        
        // SE PROCESAN TODOS LOS HIJOS Y DPS RAIZ
        if (a.hasChildren()){
            for (GeneralTree<Integer> child: a.getChildren()){
                numerosImparesMayoresQuePostOrden(child,n,l);
            }
        }
       
        if (a.getData() > n && a.getData() % 2 != 0){
            l.add(a.getData());
        }
    }
    
    // POR NIVELES
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
        List<Integer> l = new LinkedList<>();
        // LLAMO AL METODO CON 3 PARAMETROS PARA NO PERDER LISTA
        numerosImparesMayoresQuePorNiveles(a,n,l);
        return l;     
    } 
    
    public void numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n, List l){
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> queue = new Queue<>();
        // ENCOLO RAIZ DEL ARBOL
        queue.enqueue(a); 
        while (!queue.isEmpty()){
            // DESENCOLO EL DATO Y CHECKEO CONDICION
            aux = queue.dequeue();
            if (aux.getData() > n && aux.getData() % 2 != 0){
                l.add(aux.getData());
            }
            
            // PONGO TODOS LOS HIJOS EN LA COLA
            if (aux.hasChildren()){
                for (GeneralTree<Integer> child: aux.getChildren()){
                    queue.enqueue(child);
                }
            }
        }
        
    }    
}
