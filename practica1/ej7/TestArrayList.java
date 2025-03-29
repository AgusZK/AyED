package practica1.ej7;
import java.util.ArrayList;
import java.util.Scanner;
       

public class TestArrayList {

    public static void generarLista(){
        
    }
    
    public static void printLista(ArrayList<Integer> list){
        for (int num: list){
            System.out.println(num);
        }
    }
    
    
    public static void main(String[] args) {
        // CREO SCAN PARA DETECTAR EL INPUT
        Scanner scan = new Scanner(System.in);
        // CREO ARRAYLIST
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Ingrese un numero (-1 para cortar)");
        int num = scan.nextInt();
        while (num != -1){
            list.add(num);
            System.out.println("Ingrese un numero (-1 para cortar)");
            num = scan.nextInt();
        }
        
        printLista(list);   
    }
    
}
