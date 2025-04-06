package practica2;

// EJERCICIO 4
public class RedBinariaLlena {
    private final BinaryTree<Integer> ab;

    public RedBinariaLlena(BinaryTree<Integer> ab) {
        this.ab = ab;
    }
    
    public int retardoReenvio(){
        return retardoReenvio(ab);
    }
    
    public int retardoReenvio(BinaryTree<Integer> ab){
        if (ab.isLeaf()){
            return ab.getData();
        }
        // INICIALIZO
        int left = 0; int right = 0;
        if (ab.hasLeftChild()){
            left = retardoReenvio(ab.getLeftChild());
        }
        if (ab.hasRightChild()){
            right = retardoReenvio(ab.getRightChild());
        }
        // PRIMERA ITERACION, LEFT = HIJO IZQ DEL ULTIMO NODO, RIGHT = HIJO DER DEL LTIMO NODO
        // TERMINA LA RECURSION Y ME VOY QUEDANDO CON EL MAS GRANDE DE LOS 2 HIJOS SUCESIVAMENTE
        // RETORNO SUMA DEL CAMINO MAS LRGO
        return Math.max(left, right) + ab.getData();
    }


}
