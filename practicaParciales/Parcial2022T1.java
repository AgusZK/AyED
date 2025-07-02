package practicaParciales;
import java.util.List;
import java.util.LinkedList;
import practica2.BinaryTree;

public class Parcial2022T1 {
    public List<Integer> resolver (BinaryTree<Integer> ab , int min){
        List<Integer> camino = new LinkedList<>();
        if (!ab.isEmpty() && ab != null){
            resolver(ab,min,camino);
        }
        
        return camino;
    }
    
    private boolean resolver (BinaryTree<Integer> ab, int min , List<Integer> camino){
        boolean encontre = false;
        
        if (ab.getData() % 2 == 0){
            min-= 1;
            camino.add(ab.getData());
        }
        
        if (ab.isLeaf()){
            if (min <= 0){
                encontre = true;
                return encontre;
            }
            else{
                camino.remove(camino.size() - 1);
            }
        }
        
        if (ab.hasLeftChild()){
            encontre = resolver(ab.getLeftChild(), min, camino);
        }
        
        if (ab.hasRightChild()){
            encontre = resolver(ab.getRightChild(), min, camino);
        }
        
        if (!encontre){
            camino.remove(camino.size() - 1);
        }
        
        return encontre;
    }
   
}
