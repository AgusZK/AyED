package practica2;
import practica1.ej8.Queue;

// EJERCICIO 5
public class ProfundidadDeArbolBinario {
    private final BinaryTree<Integer> ab;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> ab) {
        this.ab = ab;
    }
    
    // RECIBE PROFUNDIDAD, DEVUELVE SUMA EN ESA ALTURA, BREAK CUANDO LA SUPERA
    public int SumaElementosProfundidad (int p){
        Queue<BinaryTree<Integer>> queue = new Queue<>();
        queue.enqueue(ab);
        
        int level = 0;
        BinaryTree<Integer> ab2 = null;
        int sum = 0;
        
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            while (size != 0){
                ab2 = queue.dequeue();
                // CHECKEO SI ESTOY EN LA ALTURA Y SUMO LOS NODOS DE ESE LVL
                if (level == p){
                    sum += ab2.getData();
                }
                // PUSHEO HIJOS SI TIENE
                if (ab2.hasLeftChild()){
                    queue.enqueue(ab2.getLeftChild());
                }
                if (ab2.hasRightChild()){
                    queue.enqueue(ab2.getRightChild());
                }
               
                size--;
            }
            // SI SALGO DEL WHILE TERMINE DE PROCESAR LA ALTURA Y HAGO BREAK
            if (level >= p){
                break;
            }
        }     
        return sum;
    }
}
