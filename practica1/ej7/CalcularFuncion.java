package practica1.ej7;
import java.util.ArrayList;
import java.util.Scanner;

public class CalcularFuncion {
    public static ArrayList<Integer> list;
    
    public static ArrayList<Integer> calcularSucesion(int n){
        // AGREGO SIN IMPORTAR TIPO
        list.add(n);
        // SI N = 1 LO AGREGUE Y CORTO
        if (n > 1) {
            // SI ES PAR LE MANDO N/2
            if ( n % 2 == 0){
                calcularSucesion(n/2);
            }
            // IMPAR LE MANDO LA FUNCION
            else
                calcularSucesion(3*n+1);
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese numero para iniciar sucesion");
        int n = scan.nextInt();
        
        // MANDO N PARA INICIAR SUCESION
        calcularSucesion(n);
        // MUESTRO EL ARRAY CON TODOS LOS NUM
        System.out.println(list);
    }
    
}
