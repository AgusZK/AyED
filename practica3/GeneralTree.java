package practica3;
import practica1.ej8.Queue;
import java.util.List;
import java.util.LinkedList;

public class GeneralTree<T> {
    private final T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    // EJERCICIO 1
    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this.data = data;
        this.children = children;
    }

    public T getData() {
        return data;
    }
    
    public List<GeneralTree<T>> getChildren() {
        return children;
    }
    
    public void addChild(GeneralTree<T> child){
        getChildren().add(child);
    }
    
    public void removeChilld(GeneralTree<T> child){
        if (this.hasChildren()){
            children.remove(child);
        }
    }
    
    public boolean hasChildren(){
       return !children.isEmpty();
    }
    
    public boolean isLeaf() {
        return !this.hasChildren();
    }
    
    public boolean isEmpty(){
        return this.data == null && !this.hasChildren();
    }
    
    // EJERCICIO 3
    
    public int altura(){
        if (this.hasChildren()){
            int maxAltura = -1;
            // RECORRO LOS HIJOS Y COMPARO CON MAXIMO
            for (GeneralTree<T> child: this.getChildren()){
                int childAltura = child.altura();
                if (childAltura > maxAltura){
                    maxAltura = childAltura;
                }
            }
            
            return 1 + maxAltura;
        }
        // SI NO TIENE HIJOS RETORNO 0
        return 0;
    }
    
    public int nivel (T dato){
        // SI EL DATO ACTUAL ES EL BUSCADO DEVUELVE 0, SI NO LO ENCUENTRA DEVUELVE -1
        if (this.getData().equals(dato)){
            return 0;
        }
        
        // SI TIENE HIJOS BUSCO EN CADA UNO RECURSIVAMENTE
        if (this.hasChildren()){
            for (GeneralTree<T> child: this.getChildren()){
                int nivelCount = child.nivel(dato);
                // COMPARO CON DISTINTO DE -1 QUE SERIA EL CASO DE QUE NO LO ENCUENTRE PARA SUMAR,
                if (nivelCount != -1){
                    return 1 + nivelCount;
                }
            }
        }
        // SI NO TIENE HIJOS NO LO ENCONTRE RETORNO -1
        return -1;
    }
    
    public int ancho(){
        GeneralTree<T> aux;
        int max = -1;
        Queue<GeneralTree<T>> queue = new Queue<>();
        
        queue.enqueue(this);
        while (!queue.isEmpty()){
            // ME GUARDO CANTIDAD DE NODOS DEL ARBOL ACTUAL
            int size = queue.size();
            // ACTUALIZO MAXIMO
            max = Math.max(max,size);
            
            // POPEO EL NODO DE LA QUEUE Y AGREGO HIJOS A LA QUEUE SI TIENE
            for (int i = 0 ; i < size ; i++){
                aux = queue.dequeue();
                for (GeneralTree<T> child : aux.getChildren()){
                    queue.enqueue(child);
                }
            }     
        }
        
        return max;
    }
    
    // EJERCICIO 5
    
    public boolean esAncestro(T a, T b){
        // SI EL DATO ACTUAL ES A, BUSCO B EN SU DESCENDENCIA
        if (this.getData().equals(a)){
            return searchDescendant(b);
        }
        
        // SI NO ES, BUSCO EN LOS HIJOS 
        for(GeneralTree<T> child: this.getChildren())
            if (child.esAncestro(a, b)){
                return true;
            }
        
        // SI B NO ESTA EN LA DESCENDENCIA DE A, DEVUELVE FALSE
        return false;
    }
    
    public boolean searchDescendant(T b){
        // SI ENCUENTRA B DEVUELVE TRUE
        if (this.getData().equals(b)){
            return true;
        }
        
        // SI NO LO ENCUENTRA BUSCA EN SUS HIJOS Y DEUVELVE TRUE SI LO ENCUENTRA
        for (GeneralTree<T> child: this.getChildren()){
            if (child.searchDescendant(b)){
                return true;
            }
        }
        
        // SI NO ESTA ENTRE SUS DESCENDIENTES DEVUELVE FALSE
        return false;
    }
    
    public static void main(String[] args) {
        GeneralTree<String> A = new GeneralTree<>("A");
        GeneralTree<String> B = new GeneralTree<>("B");
        GeneralTree<String> C = new GeneralTree<>("C");
        GeneralTree<String> D = new GeneralTree<>("D");
        GeneralTree<String> E = new GeneralTree<>("E");
        GeneralTree<String> F = new GeneralTree<>("F");
        GeneralTree<String> G = new GeneralTree<>("G");
        GeneralTree<String> H = new GeneralTree<>("H");
        
        A.addChild(B);
        A.addChild(C);
        A.addChild(D);
        B.addChild(E);
        B.addChild(F);
        F.addChild(G);
        G.addChild(H);
              
        /*
            A
          / |  \
         B  C   D
        / \
       E   F
          /
         G
         /
        H
        */
        
        // ALTURA = 4 , NIVEL = 2, ANCHO = 3
        System.out.println(A.altura());
        System.out.println(A.nivel("E"));
        System.out.println(A.ancho());

        // TRUE, TRUE, FALSE, TRUE
        System.out.println(A.esAncestro("A", "G")); 
        System.out.println(A.esAncestro("B", "G"));  
        System.out.println(A.esAncestro("C", "G"));
        System.out.println(A.esAncestro("F", "H"));       
    }
    
}

