package practica3;
import java.util.List;

// EJERCICIO 6
public class RedDeAguaPotable {
    private GeneralTree<Character> red;
    
    public RedDeAguaPotable(GeneralTree<Character> red){
        this.red = red;
    }
    
    public double minimoCaudal(double caudal){
        return minimoCaudal(caudal,red);
    }
    
    public double minimoCaudal(double caudal, GeneralTree<Character> red){
        if (red.isLeaf()){
            return caudal;
        }
        
        double min = 9999;
        if (red.hasChildren()){
            // GUARDO LOS HIJOS EN UNA LISTA Y CALCULO CUANTO TIENE QUE IR A CADA HIJO
            List<GeneralTree<Character>> listC = red.getChildren();
            double childrenCaudal = caudal / listC.size();
            
            for (GeneralTree<Character> child: listC){
                // RECORRO HIJO CON CAUDAL DIVIDIDO
                double minActual = minimoCaudal(childrenCaudal,child);
                
                if (minActual < min){
                    min = minActual;
                }
            }
        }
        
        return min;
    }
    
public static void main(String[] args) {
    GeneralTree<Character> A = new GeneralTree<>('A');
    GeneralTree<Character> B = new GeneralTree<>('B');
    GeneralTree<Character> C = new GeneralTree<>('C');
    GeneralTree<Character> D = new GeneralTree<>('D');
    GeneralTree<Character> E = new GeneralTree<>('E');
    GeneralTree<Character> F = new GeneralTree<>('F');
    GeneralTree<Character> G = new GeneralTree<>('G');
    GeneralTree<Character> H = new GeneralTree<>('H');
    GeneralTree<Character> I = new GeneralTree<>('I');
    GeneralTree<Character> J = new GeneralTree<>('J');
    GeneralTree<Character> K = new GeneralTree<>('K');
    GeneralTree<Character> P = new GeneralTree<>('P');
    GeneralTree<Character> L = new GeneralTree<>('L');
    GeneralTree<Character> M = new GeneralTree<>('M');
    GeneralTree<Character> N = new GeneralTree<>('N');

     A.addChild(B); A.addChild(C); A.addChild(D); A.addChild(E);
     C.addChild(F); C.addChild(G);
     G.addChild(L);
     D.addChild(H); D.addChild(I); D.addChild(J); D.addChild(K); D.addChild(P);
     J.addChild(M); J.addChild(N);

    /*
            A
       /    |    \      \
      B     C       D        E
           / \      /|\   
          F   G     H I J
              \   | \
               L   M N
    */
    
    RedDeAguaPotable red = new RedDeAguaPotable(A);
    double caudalMin = red.minimoCaudal(1000);
    // 25.0
    System.out.println("CAUDAL MINIMO: " + caudalMin);
    }
}




    
