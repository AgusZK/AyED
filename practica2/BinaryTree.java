package practica2;
import practica1.ej8.Queue;

// EJERCICIOS 1 Y 2
public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftchild;
    private BinaryTree<T> rightchild;    
    
    public BinaryTree() {
        super();
    }
    
    public BinaryTree(T data) {
        this.data = data;
    }
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    public boolean hasLeftChild(){
        return this.leftchild != null;
    }
    
    public boolean hasRightChild(){
        return this.rightchild != null;
    }
    
    public BinaryTree<T> getLeftChild(){
         return this.leftchild;
    }
    
    public BinaryTree<T> getRightChild(){
        return this.rightchild;
    }
    
    public void addLeftChild (BinaryTree<T> c){
        this.leftchild = c;
    }
    
    public void addRightChild (BinaryTree<T> c){
        this.rightchild = c;
    }
    
    public void removeLeftChild(){
        this.leftchild = null;
    }
    
    public void removeRightChild(){
        this.rightchild = null;
    }
    
    // Si no tiene hijos retorna true
    public boolean isLeaf(){
        return (!this.hasLeftChild() && this.hasRightChild());
    }
    
    // Si no tiene ni hijos ni padre retorna true
    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }
    
    public int contarHojas(){
        int sum = 0;
        if (isLeaf()){
            return 1;
        }
        if (hasLeftChild()){
            sum += getLeftChild().contarHojas();
        }
        if (hasRightChild()){
            sum += getRightChild().contarHojas();
        }
        
        return sum;
    }
    
    public BinaryTree<T> espejo (){
        // CREO NUEVO ARBOL PARA DEVOLVERLO INVERTIDO
        BinaryTree<T> invertido = new BinaryTree<>();
        
        // SI LLEGO A NODO NO NULO, LE AGREGO EL DATO EN EL ARBOL AUXILIAR
        if (!isEmpty()){
            invertido.setData(getData());
        }
        // SI TIENE HIJO DERECHO, AGREGO EN INVERTIDO EN EL HIJO IZQUIERDO
        // RECORRO RECURSIVAMENTE HASTA LLEGAR A HOJA
        if (hasRightChild()){
            invertido.addLeftChild(getLeftChild().espejo());
        }
        
        // LO MISMO CON EL IZQUIERDO
        if (hasLeftChild()){
            invertido.addRightChild(getRightChild().espejo());
        }
        
        return invertido;
    }
    
    public void entreNiveles (int n, int m){
        Queue<BinaryTree<T>> queue = new Queue<>();
        BinaryTree<T> ab = null;
        // METO DATO
        queue.enqueue(this);
        // NO PONGO NULL PORQUE EL LIMITE ES M
        int level = 0; 
        while (!queue.isEmpty()){
            // SUMO EN NIVEL PARA FIJARME SI ESTOY N RANGO
            level++;
            // EN SIZE TE GUARDAS LOS NODOS DEL NIVEL
            int size = queue.size();
            while (size != 0){
                ab = queue.dequeue();
                if (n <= level && level <= m){
                    System.out.println(ab + " ");
                }
                // SI TIENE HIJO IZQ/DERECHO LOS PUSHEO
                if (ab.hasLeftChild()){
                    queue.enqueue(ab.getLeftChild());
                }
                if (ab.hasRightChild()){
                    queue.enqueue(ab.getRightChild());
                }
                size--;
            }
            // SALGO SI SIZE = 0, PROCESO EL ULTIMO
            if (n <= level && level <= m){
                System.out.println(ab + " ");
            }
        }
    }
    
    @Override
    public String toString(){
        return this.getData().toString();
    }
}

