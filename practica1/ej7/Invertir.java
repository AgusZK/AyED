package practica1.ej7;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Invertir {

    public static void invertirArrayList(ArrayList<Integer> list){
        // LISTA AUXILIAR
        ArrayList<Integer> invertedlist = new ArrayList<>();
        // RECORRO DE ATRAS PARA ADELANTE Y ME GUARDO LOS ELEMENTOS INVERTIDOS EN LISTA AUX
        for (int i = list.size() - 1 ; i >= 0 ; i--){
            invertedlist.add(list.get(i));
        }
        // EN LA LISTA VIEJA, REEMPLAZO LOS NUM CON LOS DE LA INVERTIDA
        for (int i = 0 ; i < list.size() ; i++){
            list.set(i,invertedlist.get(i));
        }
        
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Ingrese un numero (-1 para cortar)");
        int num = scan.nextInt();
        while (num != -1){
            list.add(num);
            System.out.println("Ingrese un numero (-1 para cortar)");
            num = scan.nextInt();
        }
        System.out.println("LISTA NORMAL: ");
        System.out.println(list);
        invertirArrayList(list);
        System.out.println("LISTA INVERTIDA");
        System.out.println(list);
    }
    
}
