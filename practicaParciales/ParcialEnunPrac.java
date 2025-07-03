package practicaParciales;
import practica2.BinaryTree;

public class ParcialEnunPrac {
    public int sumaImparesPosOrdenMayorA(BinaryTree<Integer> ab , int tope){
        int suma = 0;
        if (ab != null && !ab.isEmpty()){
           suma = sumaImparesPosOrdenMayorA(ab,tope,suma);
        }
        
        return suma;
    }
    public int sumaImparesPosOrdenMayorA(BinaryTree<Integer> ab, int tope, int suma){
        int sumaT = suma;
        
        if (ab.hasLeftChild()){
            sumaT = sumaImparesPosOrdenMayorA(ab.getLeftChild(),tope, sumaT);
        }
        if (ab.hasRightChild()){
            sumaT = sumaImparesPosOrdenMayorA(ab.getRightChild(),tope,sumaT);
        }
        
        if (ab.getData() % 2 != 0 && ab.getData() > tope){
            sumaT += ab.getData();
        }
        
        return sumaT;
    }
    
    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(5);
        BinaryTree<Integer> leftChild = new BinaryTree<>(3);
        BinaryTree<Integer> rightChild = new BinaryTree<>(8);
        root.addLeftChild(leftChild);
        root.addRightChild(rightChild);
        leftChild.addLeftChild(new BinaryTree<>(1));
        leftChild.addRightChild(new BinaryTree<>(6));
        rightChild.addLeftChild(new BinaryTree<>(10));
        rightChild.addRightChild(new BinaryTree<>(11));

        // 
        //         5
        //       /   \
        //      3     8
        //     / \   /  \
        //    1   6 10   11


        ParcialEnunPrac parcial = new ParcialEnunPrac();
        int tope = 2;
        int resultado = parcial.sumaImparesPosOrdenMayorA(root, tope);

        System.out.println("Suma de los numeros impares mayores que " + tope + " es: " + resultado);
    }
}
