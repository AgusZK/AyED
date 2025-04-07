package practica2;

public class ParcialArboles {
    private final BinaryTree <Integer> ab;

    public  ParcialArboles (BinaryTree<Integer> ab) {
        this.ab = ab;
    }
    
    // ---------------------------------------------------//
    // EJERCICIO 7
    public int countChilds(BinaryTree<Integer> ab){  
        // SI ES UN HOJA NO SUMO NADA
        if (ab.isLeaf()){
            return 0;
        }
        
        int count = 0;
        // SUMO 1 SI SOLO TIENE HIJO IZQ
        if (ab.hasLeftChild() && !ab.hasRightChild()) {
            count = 1;  
        }
        // SUMO 1 SI SOLO TIENE HIJO DERECHO
        else if (!ab.hasLeftChild() && ab.hasRightChild()) {
            count = 1;  
        }
        // BUSCO EN SUS HIJOS
        else {   
            if (ab.hasLeftChild()) {
                count += countChilds(ab.getLeftChild());
            }
            if (ab.hasRightChild()) {
                count += countChilds(ab.getRightChild());
            }
        }
        return count;
    }
    
    public BinaryTree<Integer> findNode(BinaryTree<Integer> ab, int num){
        if (ab.getData() == num){
            return ab;
        }
        
        BinaryTree<Integer> aux = null;
        if (ab.hasLeftChild()){
            aux = findNode(ab.getLeftChild(), num);
        }
        
        // CORTO SI LO ENCUENTRA (SIN ESTO NO ANDA)
        if (aux != null){
            return aux;
        }
        
        if (ab.hasRightChild()){
            aux = findNode(ab.getRightChild(), num);
        }

        return aux;
    }
    
    
    public boolean isLeftTree(int num){
        // BUSCO EL NODO EN EL ARBOL
        BinaryTree<Integer> node = findNode(ab,num);
        if (node == null){
            System.out.println("El nodo no esta");
            return false;
        }

        int left = -1;
        int right = -1;
        
        if (node.hasLeftChild()){
            left = countChilds(node.getLeftChild());
        }
        
        if (node.hasRightChild()){
            right = countChilds(node.getRightChild());
        }
        
        return left > right;
    }
    // ---------------------------------------------------//
    // EJERCICIO 8
       public boolean esPrefijo (BinaryTree<Integer> ab1, BinaryTree<Integer> ab2){
           // CONDICIONES DE FALSO
           if (ab1.getData() != ab2.getData()){
               return false;
           }
           if (ab1.hasLeftChild() && !ab2.hasLeftChild()){
               return false;
           }
           if (ab1.hasRightChild() && !ab2.hasRightChild()){
               return false;
           }
           
           // SI ES HOJA DEVUELVO TRUE, NO HAY QUE BUSCAR,
           // SOLO CHECKEO AB1 PORQUE TIENE Q SER PREFIJO DE AB2
           if (ab1.isLeaf()){
               return true;
           }
           
           // INICIALIZO Y BUSCO EN HIJOS
           boolean left = true; boolean right= true;
           if (ab1.hasLeftChild() && ab2.hasLeftChild()){
               left = esPrefijo(ab1.getLeftChild(),ab2.getLeftChild());
           }
           
           if (ab1.hasRightChild() && ab2.hasRightChild()){
               right = esPrefijo(ab1.getLeftChild(), ab2.getLeftChild());
           }
           
           return left && right;
       } 
    // ---------------------------------------------------//
    public static void main(String[] args) {
        // EJERCICIO 7 CREO ARBOL AB
        
        // ROOT
        BinaryTree<Integer> ab = new BinaryTree<>(2); 
        // LVL 1
        BinaryTree<Integer> node7 = new BinaryTree<>(7);
        BinaryTree<Integer> node5 = new BinaryTree<>(-5);
        ab.addLeftChild(node7);
        ab.addRightChild(node5);
        
        // LVL 2
        BinaryTree<Integer> node23 = new BinaryTree<>(23);
        BinaryTree<Integer> node6 = new BinaryTree<>(6);
        node7.addLeftChild(node23);
        node7.addRightChild(node6);        

        BinaryTree<Integer> node19 = new BinaryTree<>(19);
        node5.addLeftChild(node19);
        
        // LVL 3
        BinaryTree<Integer> node3 = new BinaryTree<>(-3);
        BinaryTree<Integer> node55 = new BinaryTree<>(55);
        BinaryTree<Integer> node11 = new BinaryTree<>(11);
        node23.addLeftChild(node3);
        node6.addLeftChild(node55);
        node6.addRightChild(node11);

        BinaryTree<Integer> node4 = new BinaryTree<>(4);
        node19.addRightChild(node4);
        
        // LVL 4
        BinaryTree<Integer> node18 = new BinaryTree<>(18);
        node4.addLeftChild(node18);
        
        ParcialArboles lt = new ParcialArboles(ab);
        System.out.println(lt.isLeftTree(7));
        System.out.println(lt.isLeftTree(2));
        System.out.println(lt.isLeftTree(-5));
        System.out.println(lt.isLeftTree(19));
        System.out.println(lt.isLeftTree(-3));
        
        // ---------------------------------------------------//
        
        // EJERCICIO 8 ME COPIO EL PRIMER NIVEL
        BinaryTree<Integer> ab2 = new BinaryTree<>(2); 

        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(-5);
        ab2.addLeftChild(nodo7);
        ab2.addRightChild(nodo5);

        // CREO INSTANCIA P Y LE MANDO AB2 CON LOS PRIMEROS 2 NIVELES COPIADOS Y EL VIEJO LLENO
        ParcialArboles p = new ParcialArboles(ab2);
        System.out.println("ARBOLES PREFIJOS: " + p.esPrefijo(ab2, ab));
        
        // ---------------------------------------------------//
    }   
}
