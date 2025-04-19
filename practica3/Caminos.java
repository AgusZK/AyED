package practica3;
import java.util.LinkedList;
import java.util.List;

// EJERCICIO 7
public class Caminos {
    private GeneralTree<Integer> camino;

    public Caminos(GeneralTree<Integer> camino) {
        this.camino = camino;
    }
    
    public List<Integer> caminoAHojaMasLejana(){
        List<Integer> path = new LinkedList<>();
        List<Integer> pathMax = new LinkedList<>();
        caminoAHojaMasLejana(camino,path,pathMax);
        return pathMax;
    }
    
    public void caminoAHojaMasLejana(GeneralTree<Integer> camino, List<Integer> path, List<Integer> pathMax){
        path.add(camino.getData());
        
        // SI ES HOJA, VEO SI EL CAMINO ACTUAL ES MAS LARGO QUE EL MAXIMO
        // SI ES MAS LARGO, MODIFICO PATHMAX PORQUE ES EL PRIMERO
        if (camino.isLeaf() && path.size() > pathMax.size()){
            pathMax.addAll(path);
        }
        // SINO RECORRO HIJOS
        else{
            for (GeneralTree<Integer> child: camino.getChildren()){
                caminoAHojaMasLejana(child,path,pathMax);
            }
            // VOY BORRANDO EL NODO A MEDIDA QUE LAS RECURSIONES VUELVEN
            path.remove(path.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        GeneralTree<Integer> root = new GeneralTree<>(12);  
        GeneralTree<Integer> node17 = new GeneralTree<>(17);
        GeneralTree<Integer> node9 = new GeneralTree<>(9);
        GeneralTree<Integer> node15 = new GeneralTree<>(15);
        GeneralTree<Integer> node10 = new GeneralTree<>(10);
        GeneralTree<Integer> node6 = new GeneralTree<>(6);
        GeneralTree<Integer> node1 = new GeneralTree<>(1);
        GeneralTree<Integer> node8 = new GeneralTree<>(8);
        GeneralTree<Integer> node14 = new GeneralTree<>(14);
        GeneralTree<Integer> node18 = new GeneralTree<>(18);
        GeneralTree<Integer> node16 = new GeneralTree<>(16);
        GeneralTree<Integer> node7 = new GeneralTree<>(7);

        root.addChild(node17);
        root.addChild(node9);
        root.addChild(node15);
        
        node17.addChild(node10);
        node17.addChild(node6);
        
        node6.addChild(node1);  
        
        node9.addChild(node8);
        
        node15.addChild(node14);
        node15.addChild(node18);
        node14.addChild(node16);
        node14.addChild(node7);

        /*
              12
            /  |  \
          17   9   15
         /  \       /  \
       10    6    14   18
             |    /  \
             1   16   7
        */
        Caminos caminos = new Caminos(root);
        List<Integer> caminoMasLejano = caminos.caminoAHojaMasLejana();
        System.out.println("CAMINO MAS LEJANJO: " + caminoMasLejano);
    }
}
