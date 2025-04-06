package practica2;

// EJERCICIO 6
public class Transformacion {
    private final BinaryTree<Integer> ab;

    public Transformacion (BinaryTree<Integer> ab) {
        this.ab = ab;
    }
    
    public BinaryTree<Integer> suma(){
        return suma(ab);
    }
    
    public BinaryTree<Integer> suma (BinaryTree<Integer> ab){
        this.sumaArbol(ab);
        return ab;
    }
    
    public int sumaArbol (BinaryTree<Integer> ab){
        int sum = 0;
        // SI ES HOJA ASUMO Y LE PONGO 0 AL ARBOL, EN SUM ME GUARDO EL DATO
        if (ab.isLeaf()){
            sum += ab.getData();
            ab.setData(0);
            return sum;
        }
        if (ab.hasLeftChild()){
            sum += sumaArbol(ab.getLeftChild());
        }
        
        if (ab.hasRightChild()){
            sum += sumaArbol(ab.getRightChild());
        }
        // TERMINA DE RECORRER AMBOS LADOS Y EN SUM TENGO LA SUMA DE LOS NODOS
        // ME GUARDO EN PADRE EL NODO PADRE ANTES DE PISARLO
        // DEVUELVO PADRE + SUMA DE HIJOS
        int padre = ab.getData();
        ab.setData(sum);
        return padre + sum;
    }
    

}
