package practica1.ej7;

import java.util.Scanner;
import java.util.LinkedList;


public class SumaElementos {
    
    public static int sumarLinkedList(LinkedList<Integer> list, int i){
        // SI LLEGO AL TOPE DE LA LISTA RETORNO 0
        if (i == list.size()){
            return 0;
        }
        // SINO SUMO Y MANDO CON EL INDICE + 1
        else 
            return list.get(i) + sumarLinkedList(list, i + 1); 
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Ingrese un numero (-1 para cortar)");
        int num = scan.nextInt();
        while (num != -1){
            list.add(num);
            System.out.println("Ingrese un numero (-1 para cortar)");
            num = scan.nextInt();
        }
        
        // LE MANDO 0 PARA QUE EMPIECE A RECORRER RECURSIVAMENTE DESDE EL INICIO
        System.out.println("SUMA DE ELEMENTOS: " + sumarLinkedList(list,0));
    }
    
}
