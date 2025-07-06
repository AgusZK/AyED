package practicaParciales.Arboles;
import practica2.BinaryTree;
import java.util.List;
import java.util.LinkedList;

public class ParcialProg3T1 {
    private BinaryTree<Integer> ab;
    
    public ParcialProg3T1(BinaryTree<Integer> arbol){
        this.ab = arbol;
    }
    
    public List<Integer> procesar(){
        List<Integer> lista = new LinkedList<>();
        if (this.ab != null && !this.ab.isEmpty()){
            procesar(ab,lista);
        }
        
        return lista;
    }
    
    private void procesar (BinaryTree<Integer> ab , List<Integer> lista){
        if (ab.hasLeftChild() && ab.hasRightChild()){
            if (ab.getData() % 2 == 0){
                lista.add(ab.getData());
            }
        }
        
        if (ab.hasLeftChild()){
            procesar(ab.getLeftChild(),lista);
        }
        if (ab.hasRightChild()){
            procesar(ab.getRightChild(),lista);
        }
    }
    
        public static void main(String[] args) {
        // Construir el árbol de prueba
        BinaryTree<Integer> root = new BinaryTree<>(6);
        BinaryTree<Integer> node4 = new BinaryTree<>(4);
        BinaryTree<Integer> node8 = new BinaryTree<>(8);
        BinaryTree<Integer> node2 = new BinaryTree<>(2);
        BinaryTree<Integer> node5 = new BinaryTree<>(5);
        BinaryTree<Integer> node10 = new BinaryTree<>(10);
        BinaryTree<Integer> node12 = new BinaryTree<>(12);
        root.addLeftChild(node4);
        root.addRightChild(node8);
        node4.addLeftChild(node2);
        node4.addRightChild(node5);
        node8.addLeftChild(node10);
        node8.addRightChild(node12);

        /*
                 6
                / \
               4   8
              / \   / \
             2   5  10  12
         */
        ParcialProg3T1 test = new ParcialProg3T1(root);
        List<Integer> resultado = test.procesar();
        System.out.println("Nodos que tienen dos hijos y son pares: " + resultado);
        }
}
        

