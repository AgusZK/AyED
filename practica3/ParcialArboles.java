package practica3;
import practica1.ej8.Queue;
import java.util.List;
import java.util.LinkedList;


public class ParcialArboles {
    public static int max = -1;

    public static GeneralTree<Integer> crearArbolSeleccion() {
        GeneralTree<Integer> raiz = new GeneralTree<>(12);

        GeneralTree<Integer> n12_1 = new GeneralTree<>(12);
        GeneralTree<Integer> n25_1 = new GeneralTree<>(25);
        raiz.addChild(n12_1);
        raiz.addChild(n25_1);

        GeneralTree<Integer> n35_1 = new GeneralTree<>(35);
        GeneralTree<Integer> n12_2 = new GeneralTree<>(12);
        n12_1.addChild(n35_1);
        n12_1.addChild(n12_2);

        GeneralTree<Integer> n25_2 = new GeneralTree<>(25);
        n25_1.addChild(n25_2);

        GeneralTree<Integer> n35_2 = new GeneralTree<>(35);
        n35_1.addChild(n35_2);

        GeneralTree<Integer> n14 = new GeneralTree<>(14);
        GeneralTree<Integer> n12_3 = new GeneralTree<>(12);
        GeneralTree<Integer> n33_1 = new GeneralTree<>(33);
        n12_2.addChild(n14);
        n12_2.addChild(n12_3);
        n12_2.addChild(n33_1);

        GeneralTree<Integer> n35_3 = new GeneralTree<>(35);
        GeneralTree<Integer> n83 = new GeneralTree<>(83);
        GeneralTree<Integer> n90 = new GeneralTree<>(90);
        GeneralTree<Integer> n33_2 = new GeneralTree<>(33);
        n33_1.addChild(n35_3);
        n33_1.addChild(n83);
        n33_1.addChild(n90);
        n33_1.addChild(n33_2);

        return raiz;
    }
    
    public static GeneralTree<Integer> crearArbolResolver() {
        GeneralTree<Integer> raiz = new GeneralTree<>(1);

        GeneralTree<Integer> n1 = new GeneralTree<>(0);
        GeneralTree<Integer> n2 = new GeneralTree<>(1);
        GeneralTree<Integer> n3= new GeneralTree<>(1);
        raiz.addChild(n1); raiz.addChild(n2); raiz.addChild(n3);
        
        GeneralTree<Integer> n4 = new GeneralTree<>(1);
        GeneralTree<Integer> n5= new GeneralTree<>(1);
        GeneralTree<Integer> n7 = new GeneralTree<>(1);
        GeneralTree<Integer> n8= new GeneralTree<>(0);
        GeneralTree<Integer> n9= new GeneralTree<>(0);
        n1.addChild(n4); n1.addChild(n5);
        n2.addChild(n7); n2.addChild(n8);
        n3.addChild(n9);
        
        GeneralTree<Integer> n10 = new GeneralTree<>(1);
        GeneralTree<Integer> n11= new GeneralTree<>(1);
        GeneralTree<Integer> n12 = new GeneralTree<>(1);
        GeneralTree<Integer> n13 = new GeneralTree<>(0);
        GeneralTree<Integer> n14 = new GeneralTree<>(0);    
        n4.addChild(n10); n4.addChild(n11); n4.addChild(n12);
        n8.addChild(n13);
        n9.addChild(n14);
        
        GeneralTree<Integer> n15 = new GeneralTree<>(0);
        GeneralTree<Integer> n16 = new GeneralTree<>(0);        
        n13.addChild(n15);
        n14.addChild(n16);
        
        GeneralTree<Integer> n17 = new GeneralTree<>(1);        
        GeneralTree<Integer> n18 = new GeneralTree<>(0);
        GeneralTree<Integer> n19 = new GeneralTree<>(0);
        
        n15.addChild(n17);
        n16.addChild(n18); n16.addChild(n19);
        return raiz;
    }
    
    public static GeneralTree<Integer> crearArbolCreciente() {
    GeneralTree<Integer> raiz = new GeneralTree<>(2);

    GeneralTree<Integer> n5 = new GeneralTree<>(5);
    GeneralTree<Integer> n6 = new GeneralTree<>(6);
    raiz.addChild(n5);
    raiz.addChild(n6);


    GeneralTree<Integer> n7 = new GeneralTree<>(7);
    GeneralTree<Integer> n8 = new GeneralTree<>(8);
    GeneralTree<Integer> n9 = new GeneralTree<>(9);
    n5.addChild(n7);
    n5.addChild(n8);
    n6.addChild(n9);

    GeneralTree<Integer> n10 = new GeneralTree<>(10);
    GeneralTree<Integer> n11 = new GeneralTree<>(11);
    GeneralTree<Integer> n12 = new GeneralTree<>(12);
    GeneralTree<Integer> n13 = new GeneralTree<>(13);
    n7.addChild(n10);
    n7.addChild(n11);
    n8.addChild(n12);
    n9.addChild(n13);

    return raiz;
}
    
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if (arbol.isLeaf()){
            return true;
        }
        // INICIALIZO Y ME QUEDO CON EL MAS CHICO DE LOS HIJOS
        int min = 999999;
        for (GeneralTree<Integer> child: arbol.getChildren()){
            if (child.getData() < min){
                min = child.getData();
            }
        }
        // DEVUELVE TRUE SI EL MAS CHICO DE LOS HIJOS = PADRE
        return min == arbol.getData();
    }
    
    public static List<Integer> resolver (GeneralTree<Integer> arbol){
        List<Integer> path = new LinkedList<>();
        List<Integer> pathMax = new LinkedList<>();
        // LLAMO A OTRO METODO PARA PASARLE LOS PATHS, LEVEL Y SUMATORIA POR PARAMETRO Y NO PISARLOS
        resolver(arbol,path,pathMax,0,0);
        return pathMax;
    }
    
   public static void resolver (GeneralTree<Integer> arbol,List<Integer> path , List<Integer> pathMax, int level, int sum){
       int valorMaximo = sum + (arbol.getData() * level);

       if (arbol.getData() == 1){
           path.add(arbol.getData());
       }
       
       // SI ES HOJA GUARDO MAXIMO
       if (arbol.isLeaf()){
           if (valorMaximo > max){
            max = valorMaximo;
            pathMax.clear();
            pathMax.addAll(path);
           }
       }
       // SI TIENE HIJOS LLAMO CON NIVEL + 1 Y LA SUMA ACTUALIZADA PARA NO PISARLA
       else{
           for (GeneralTree<Integer> child: arbol.getChildren()){
               resolver(child,path,pathMax, level + 1, valorMaximo);
           }
       }
       
       if (arbol.getData() == 1){
           path.remove(path.size() - 1);
       }   
    }
   public static boolean esCreciente (GeneralTree<Integer> arbol){
       GeneralTree<Integer> aux;
       boolean corte = true;
       int previous = 0;
       Queue<GeneralTree<Integer>> queue = new Queue<>();
       
       queue.enqueue(arbol);
       while (!queue.isEmpty() && corte){
           int size = queue.size();
           int thisLevel = 0;
           
           while (size != 0){
               thisLevel++;
               aux = queue.dequeue();
               for (GeneralTree<Integer> child: aux.getChildren()){
                   queue.enqueue(child);
               }
               
               size--;
           }
        // ME FIJO SI EL NIVEL ACTUAL ES 1 MAS AL ANTERIOR, SI DA LO ACTUALIZO
        // SI NO DA CORTO LA EJECUCION Y DEVUELVO FALSE
         if (previous + 1 != thisLevel){
             corte = false;
         }
         else{
             previous = thisLevel;
         }
       }
       
       return corte;
   }
    
    public static void main(String[] args) {  
        /*
                12
              /    \
            12      25
           /  \       \
         35   12      25
         |   / | \
        35 14 12 33
                 / | | \
               35 83 90 33
        */
        GeneralTree<Integer> raiz = crearArbolSeleccion();        
        System.out.println(ParcialArboles.esDeSeleccion(raiz)); // DEVUELVE SI CUMPLE
        
        /*
                        1
                /       |       \
              0         1         1S
             / \       / \         \
            1   1     1   0         0
           /|\           |         |
          1 1 1          0         0
                        |         |
                        0         0
                        |        / \
                        1       0   0
        */
        GeneralTree<Integer> raiz2 = crearArbolResolver();
        System.out.println(ParcialArboles.resolver(raiz2)); // DEVUELVE LA LISTA
        
        /*
                  2
                /   \
              5       6
             / \      |
            7   8     9
           / \   |     |
         10 11  12    13
        
        */
        GeneralTree<Integer> arbolCreciente = crearArbolCreciente();
        System.out.println(ParcialArboles.esCreciente(arbolCreciente)); // DEVUELVE SI CUMPLE
    }
}




