package practica3;
import java.util.List;

public class Navidad {
    private GeneralTree<Integer> abeto;

    public Navidad(GeneralTree<Integer> abeto) {
        this.abeto = abeto;
    }
    
    public String esAbetoNavidenio(){
        if (esAbeto(this.abeto)){
            return "Yes";
        }
        else
            return "No";
    }
    
    public boolean esAbeto (GeneralTree<Integer> a){
        if (a.isLeaf()){
            return true;
        }
        
        // CUENTO CANTIDAD DE HIJOS HOJAS
        int count = 0;
        for (GeneralTree<Integer> child : a.getChildren()){
            if (child.isLeaf()){
             count++;   
            }
            
            // SI ALGUNO DE LOS HIJOS NO ES ABETO RETORNO FALSE
            if (!esAbeto(child)){
                return false;
            }
        }
       
        return count >= 3;
    }

    public static void main(String[] args) {
        GeneralTree<Integer> nodo2 = new GeneralTree<>(2, List.of(
                new GeneralTree<>(5),
                new GeneralTree<>(6),
                new GeneralTree<>(7)
        ));
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
        GeneralTree<Integer> raiz = new GeneralTree<>(1, List.of(nodo2, nodo3, nodo4, nodo8));

        Navidad navidad = new Navidad(raiz);
        System.out.println(navidad.esAbetoNavidenio()); // DEVUELVE YES
    }
}
