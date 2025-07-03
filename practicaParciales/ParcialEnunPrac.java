package practicaParciales;
import practica2.BinaryTree;
import java.util.List;
import java.util.LinkedList;

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
    
    public List<Integer> resolver (BinaryTree<Integer> ab){
        List<Integer> lista = new LinkedList<>();
        if (ab != null && !ab.isEmpty()){
            resolver(ab,lista);
        }
        
        return lista;
    }
    
    public int resolver (BinaryTree<Integer> ab , List<Integer> lista){
        int izq = 0; int der = 0;
        if (ab.isLeaf()){
            return 0;
        }         
        if (ab.hasLeftChild()){
            izq = resolver(ab.getLeftChild(), lista);
        }
            
        if (ab.hasRightChild()){
            der = resolver(ab.getRightChild(),lista);
        }
        
        if (izq == der){
            lista.add(ab.getData());
        }
        
        return 1 + izq + der;
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

        ParcialEnunPrac parcial = new ParcialEnunPrac();
        int tope = 2;  
        int resultadoSuma = parcial.sumaImparesPosOrdenMayorA(root, tope);
        System.out.println("Suma de los numeros impares mayores que " + tope + " es: " + resultadoSuma);

        List<Integer> resultadoLista = parcial.resolver(root);
        System.out.println("Lista de caminos con el mismo número de descendientes en ambos lados: " + resultadoLista);
    }
}
