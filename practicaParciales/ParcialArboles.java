package practicaParciales;
import java.util.List;
import java.util.LinkedList;
import practica3.GeneralTree;
import practica1.ej8.Queue;

// PARCIAL 1ER FECHA 2024 T2 https://www.notion.so/Parciales-Arboles-1e8a1f8f4ab380c79c43ef363a1dfc84

// EJERCICIO 1 
// LOS DEMAS EN EXCALIDRAW: https://excalidraw.com/#json=zR52Ob7IhPsAEHT5xaiGS,c8ymS5hdnu3HQnfEO-vb0w
public class ParcialArboles {
    private final GeneralTree<Integer> ab;

    public ParcialArboles(GeneralTree<Integer> ab) {
        this.ab = ab;
    }
    
    public List<Integer> nivel(int num){
        List<Integer> l = new LinkedList<>();
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> queue = new Queue<>();
        if (this.ab == null || this.ab.isEmpty()) return l;
        
        queue.enqueue(this.ab);
        while (!queue.isEmpty()){
            // GUARDO CANT DE NODOS DEL NIVEL
            int size = queue.size();
            boolean cumple = true;
            // LIMPIO LISTA PARA PROCESAR POR NIVEL
            l.clear();
            
            while (size != 0){
                aux = queue.dequeue();
                l.add(aux.getData());
                
                // SI TIENE MENOS QUE 'NUM' HIJOS EL NIVEL YA NO CUMPLE
                if (aux.getChildren().size() < num){
                    cumple = false;
                }
                
                for (GeneralTree<Integer> child: aux.getChildren()){
                    queue.enqueue(child);
                }
                
                size--;
            }     
            // SI TODO EL NIVEL CUMPLE, DEVUELVO L CARGADA
            if (cumple){
                return l;
            }
        }
        // SI NO CUMPLE NINGUNA DEVUELVO UNA NUEVA LISTA, SI PONGO CLEAR LO TOMA VACIO Y NO DEJA
        return new LinkedList<>();
    }
  
    public static void main(String[] args) {
        GeneralTree<Integer> nMenos6 = new GeneralTree<>(-6);
        GeneralTree<Integer> n2_a = new GeneralTree<>(2);
        GeneralTree<Integer> n8_a = new GeneralTree<>(8);
        GeneralTree<Integer> n5 = new GeneralTree<>(5);
        n5.addChild(nMenos6);
        n5.addChild(n2_a);
        n5.addChild(n8_a);

        GeneralTree<Integer> n28 = new GeneralTree<>(28);
        GeneralTree<Integer> n55 = new GeneralTree<>(55);
        GeneralTree<Integer> n18 = new GeneralTree<>(18);
        GeneralTree<Integer> n22 = new GeneralTree<>(22);
        n22.addChild(n28);
        n22.addChild(n55);
        n22.addChild(n18);

        GeneralTree<Integer> n8 = new GeneralTree<>(8);
        n8.addChild(n5);
        n8.addChild(n22);


        GeneralTree<Integer> n4 = new GeneralTree<>(4);
        GeneralTree<Integer> n2_b = new GeneralTree<>(2);
        GeneralTree<Integer> n9 = new GeneralTree<>(9);
        GeneralTree<Integer> n19 = new GeneralTree<>(19);
        n19.addChild(n4);
        n19.addChild(n2_b);
        n19.addChild(n9);


        GeneralTree<Integer> nMenos5 = new GeneralTree<>(-5);
        nMenos5.addChild(n19);
        GeneralTree<Integer> raiz = new GeneralTree<>(10);
        raiz.addChild(n8);
        raiz.addChild(nMenos5);

        ParcialArboles parcial = new ParcialArboles(raiz);
        List<Integer> resultado = parcial.nivel(3);
        System.out.println(resultado);  //[5, 22, 19]
    }
}


