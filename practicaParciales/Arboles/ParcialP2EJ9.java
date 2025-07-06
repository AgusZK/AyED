package practicaParciales.Arboles;
import practica2.BinaryTree;
import practica1.ej8.Queue;

public class ParcialP2EJ9 {
    public BinaryTree<Tupla> sumAndDif (BinaryTree<Integer> ab){
        BinaryTree<Tupla> nuevo = new BinaryTree<>();
        if (!ab.isEmpty() && ab != null){
            sumAndDif(ab,0,0, nuevo);
        }
        return nuevo;
    }
    
    public static void printPorNiveles(BinaryTree<?> tree) {
        Queue<BinaryTree<?>> cola = new Queue<>();
        cola.enqueue(tree);

        while (!cola.isEmpty()) {
            int cantidadNivel = cola.size();

            for (int i = 0; i < cantidadNivel; i++) {
                BinaryTree<?> actual = cola.dequeue();
                System.out.print(actual.getData() + " ");

                if (actual.hasLeftChild()) {
                    cola.enqueue(actual.getLeftChild());
                }
                if (actual.hasRightChild()) {
                    cola.enqueue(actual.getRightChild());
                }
            }

            System.out.println();
        }
    }
    
    private void sumAndDif(BinaryTree<Integer>ab,int suma, int padre, BinaryTree<Tupla> nuevo){
        int sumaT = suma + ab.getData();
        Tupla t = new Tupla(sumaT,ab.getData() - padre);
        nuevo.setData(t);
        
        if (ab.hasLeftChild()){
            nuevo.addLeftChild(new BinaryTree<>());
            sumAndDif(ab.getLeftChild(), sumaT, ab.getData(), nuevo.getLeftChild());
        }
        
        if (ab.hasRightChild()){
            nuevo.addRightChild(new BinaryTree<>());
            sumAndDif(ab.getRightChild(), sumaT, ab.getData(), nuevo.getRightChild());
        }
    }
    
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo15 = new BinaryTree<>(15);
        arbol.addLeftChild(nodo6);
        arbol.addRightChild(nodo15);

        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
        nodo6.addLeftChild(nodo3);
        nodo6.addRightChild(nodo8);

        BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
        nodo3.addLeftChild(nodo1);

        BinaryTree<Integer> nodo12 = new BinaryTree<>(12);
        BinaryTree<Integer> nodo20 = new BinaryTree<>(20);
        nodo15.addLeftChild(nodo12);
        nodo15.addRightChild(nodo20);

        BinaryTree<Integer> nodo13 = new BinaryTree<>(13);
        nodo12.addRightChild(nodo13);
        
        System.out.println("Arbol original");
        printPorNiveles(arbol);
        
        ParcialP2EJ9 parcial = new ParcialP2EJ9();
        BinaryTree<?> resultado = parcial.sumAndDif(arbol);
        System.out.println("Arbol resultante (suma, diferencia)");
        printPorNiveles(resultado);
    }

}

