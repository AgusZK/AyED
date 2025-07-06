package practicaParciales.Arboles;
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
            nuevoTree(this.ab, nuevoAb, 0);
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
            nuevoTree(ab.getRightChild(), nuevo.getRightChild(), 0);
        }
    }

    /*
    Método nuevo con chatgpt:
    Este método debe devolver otro nuevo árbol con una condición diferente a la del primero:

    Si el árbol dado tiene un hijo izquierdo, el nuevo árbol tendrá un hijo izquierdo cuyo valor será el doble del valor del hijo izquierdo.

    Si el árbol dado no tiene hijo izquierdo, el nuevo árbol tendrá un hijo izquierdo cuyo valor será igual al valor del padre del árbol dado.

    Los hijos derechos del nuevo árbol seguirán siendo los mismos que los del árbol original.

    Las hojas del árbol dado se transformarán en nodos internos en el nuevo árbol, donde su valor será el valor de la hoja multiplicado por 3.
    */
    public BinaryTree<Integer> nuevoTree2(){
        BinaryTree<Integer> nuevoAb = new BinaryTree<>();
        if (this.ab != null && !this.ab.isEmpty()){
            nuevoTree2(this.ab, nuevoAb, ab.getData());
        }
        
        return nuevoAb;
    }

    private void nuevoTree2(BinaryTree<Integer> ab, BinaryTree<Integer> nuevo, int dato) {
        nuevo.setData(dato);
        if (!ab.hasLeftChild() && !ab.hasRightChild()) {
           nuevo.setData(ab.getData() * 3);
           return;
        }

        if (ab.hasLeftChild()) {
            nuevo.addLeftChild(new BinaryTree<>());
            nuevoTree2(ab.getLeftChild(), nuevo.getLeftChild(), ab.getData() * 2);
        } else {
            nuevo.addLeftChild(new BinaryTree<>(ab.getData()));
        }

        if (ab.hasRightChild()) {
            nuevo.addRightChild(new BinaryTree<>(ab.getRightChild().getData()));
            nuevoTree2(ab.getRightChild(), nuevo.getRightChild(), ab.getRightChild().getData());
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

        System.out.println("Arbol original:");
        printPorNiveles(original);

        Parcial2024T1 parcial = new Parcial2024T1(original);
        BinaryTree<Integer> nuevo1 = parcial.nuevoTree();
        BinaryTree<Integer> nuevo2 = parcial.nuevoTree2();

        System.out.println("\nNuevo arbol (segun primera condicion):");
        printPorNiveles(nuevo1);

        System.out.println("\nNuevo arbol (segun segunda condicion):");
        printPorNiveles(nuevo2);
    }
}
