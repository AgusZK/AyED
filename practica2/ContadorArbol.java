package practica2;
import java.util.ArrayList;


// EJERCICIO 3
public class ContadorArbol {
    private final BinaryTree<Integer> ab;

    public ContadorArbol(BinaryTree<Integer> ab) {
        this.ab = ab;
    }
    
    // METODOS PARA MODIFICAR LISTA EN LOS DOS RECORRIDOS
    public void paresInOrden (BinaryTree<Integer> ab, ArrayList<Integer> list){
        if (ab.hasLeftChild()){
            paresInOrden(ab.getLeftChild(), list);
        }
        if (ab.getData() % 2 == 0){
            list.add(ab.getData());
        }
        if (ab.hasRightChild()){
            paresInOrden(ab.getRightChild(),list);
        }
        
    }
   
    public void paresPostOrden (BinaryTree<Integer> ab , ArrayList<Integer> list){
        if (ab.hasLeftChild()){
            paresPostOrden(ab.getLeftChild(),list);
        }  
        if (ab.hasRightChild()){
            paresPostOrden(ab.getRightChild(),list);
        }
        if (ab.getData() % 2 == 0){
            list.add(ab.getData());
        }
    }
    
    // METODO NUMEROS PARES QUE INVOCA A CADA UNO DE LOS RECORRIDOS
    // ADENTRO CREO LIST PARA MANDARLA COMO PARAMETRO
    public ArrayList<Integer> numerosParesInOrden(){
        ArrayList<Integer> list = new ArrayList<>();
        paresInOrden(ab,list);
        return list;
    }
    
    public ArrayList<Integer> numerosParesPostOrden(){
        ArrayList<Integer> list = new ArrayList<>();
        paresPostOrden(ab,list);
        return list;
    }
    
    
        
}
