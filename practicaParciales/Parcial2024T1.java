package practicaParciales;
import practica2.BinaryTree;
import practica1.ej8.Queue;

public class Parcial2024T1 {
    private BinaryTree<Integer> ab;
    
    public Parcial2024T1(BinaryTree<Integer> ab){
        this.ab = ab;
    }
    
    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> nuevoAb = new BinaryTree<>();
        
        if (this.ab != null && !this.ab.isEmpty()){
            nuevoTree(this.ab,nuevoAb, 0);
        }
        
        return nuevoAb;
    }
    
    private void nuevoTree(BinaryTree<Integer> ab, BinaryTree<Integer> nuevo, int padre){
        nuevo.setData(ab.getData() + padre);
        
        if (ab.hasLeftChild()){
            nuevo.addLeftChild(new BinaryTree<Integer>());
            nuevoTree(ab.getLeftChild(), nuevo.getLeftChild(), ab.getData());
        }
        
        if (ab.hasRightChild()){
            nuevo.addRightChild(new BinaryTree<Integer>());
            nuevoTree(ab.getRightChild(),nuevo.getRightChild(), 0);
        }
    }
    
    public static void printPorNiveles(BinaryTree<Integer> tree) {
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(tree);

        while (!cola.isEmpty()) {
            int cantidadNivel = cola.size();

            for (int i = 0; i < cantidadNivel; i++) {
                BinaryTree<Integer> actual = cola.dequeue();
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
    
    public static void main(String[] args) {
        BinaryTree<Integer> original = new BinaryTree<>(10);
        original.addLeftChild(new BinaryTree<>(5));
        original.addRightChild(new BinaryTree<>(15));
        original.getLeftChild().addLeftChild(new BinaryTree<>(2));
        original.getLeftChild().addRightChild(new BinaryTree<>(7));
        original.getRightChild().addRightChild(new BinaryTree<>(20));

        System.out.println("Arbol original");
        printPorNiveles(original);

        Parcial2024T1 parcial = new Parcial2024T1(original);
        BinaryTree<Integer> nuevo = parcial.nuevoTree();

        System.out.println("\nNuevo arbol:");
        printPorNiveles(nuevo);
    }

}


