package practica1.ej5;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
        // VAR GLOBALES PARA INCISO C
    private static  double min,max,avg;
    public static double promedio (ArrayList<Integer> arreglo){
        int total = 0;
        for (int elem : arreglo){
            total += elem;
        }
        return total/arreglo.size();
    }
    
    public static ArrayList<Double> incisoA(ArrayList<Integer> arreglo, ArrayList<Double> retorno){
        // PODRIA PASAR LA FUNCION COMO PARAMETRO AL ADD EN VEZ DE VAR
        // CASTEO PQ NO ANDA SINO
        retorno.add((double)Collections.min(arreglo));
        retorno.add((double)Collections.max(arreglo));
        retorno.add((double)promedio(arreglo));
        
        return retorno;
    }
    
    
    public static void incisoB (ArrayList<Integer> arreglo, RetornoB retorno){
        retorno.setMin(Collections.min(arreglo));
        retorno.setMax(Collections.max(arreglo));
        retorno.setAvg(promedio(arreglo));
        
        // MODOFICO LOS VALORES AL PARAMETRO PASADO
    }
    
    public static void incisoC(ArrayList<Integer> arreglo){
        min = Collections.min(arreglo);
        max = Collections.max(arreglo);
        avg = promedio(arreglo);
    }
    
    
    public static void main(String[] args) {
      
        // INICIALIZO ARRAYLIST
        ArrayList<Integer> arreglo = new ArrayList<>();
        
        arreglo.add(300);
        arreglo.add(20);
        arreglo.add(58);
        arreglo.add(65);
        arreglo.add(36);
        arreglo.add(43);
        
        // A
        ArrayList<Double> retorno = new ArrayList(3);
        incisoA(arreglo,retorno);
        System.out.println(retorno);
        
        //B
        RetornoB retB = new RetornoB();
        incisoB(arreglo,retB);
        System.out.println(retB.toString());
        
        //C
        incisoC(arreglo);
        System.out.println("Minimo: " + min + " Maximo: " + max + " Promedio: " + avg);
  
    }
}
