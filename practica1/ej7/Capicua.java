package practica1.ej7;
import java.util.ArrayList;
import java.util.Scanner;

public class Capicua {
    
    public static boolean esCapicua(ArrayList<Integer> list){
        int len = list.size();
        // RECORRE DESDE 0 AL MEDIO Y DESDE EL ULTIMO AL MEDIO
        for (int i = 0 ; i < len/2 ; i++){
            // AGARRA (en i) EL PRIMER ELEMENTO Y EN LIST.SIZE -1 - I EL ULTIMO(EL PARALELO), Y LOS COMPARA
            // SI NO SON IGUALES TIRA FALSE Y SALE, SINO AVANZA EN i Y SIGUE COMPARANDO
            if (!list.get(i).equals(list.get(list.size() - 1 - i))){
                return false;
            }      
        }
        return true;
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
        // INCISO F, MANDO LISTA DEVUELVE TRUE SI ES CAPICUA
        System.out.println(esCapicua(list));
    }
    
}
