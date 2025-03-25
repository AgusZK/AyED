package practica1.ej3;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        // DEFINO
        Estudiante e1 = new Estudiante ("Pepe", "Gonzalez", "pepe@gmail.com" , 1 , "511 17");
        Estudiante e2 = new Estudiante ("Jorge", "Perez", "jorge@gmail.com" , 13 , "1 48");
        
        Profesor p1 = new Profesor ("Hugo ", "Perez", "hugo@gmail.com" , 11 , "uba");
        Profesor p2 = new Profesor ("Carlos", "Rodriguez", "carlos@gmail.com" , 40 , "unlp");
        Profesor p3 = new Profesor ("Rodrigo", "Garcia", "rodri@gmail.com" , 60 , "utn");
        
        ArrayList<Estudiante> estudiantes = new ArrayList<>();       
        ArrayList<Profesor> profesores = new ArrayList<>();
        
        // INICIALIZO
        estudiantes.add(e1);
        estudiantes.add(e2);
   
        profesores.add(p1);
        profesores.add(p2);
        profesores.add(p3);
        
        // IMPRIMO LO PEDIDO
        for (Estudiante estu: estudiantes){
            System.out.println(estu.tusDatos());
        }
        
        for (Profesor profe: profesores){
            System.out.println(profe.tusDatos());
        }
    }   
}
