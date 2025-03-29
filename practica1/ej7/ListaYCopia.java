package practica1.ej7;
import java.util.ArrayList;
// ME TRAIGO LOS ESTUDIANTES PARA NO HACERLOS DENUEVO
import practica1.ej3.Estudiante;

public class ListaYCopia {
    
    public static void addEstudiante (ArrayList<Estudiante> list, Estudiante e ){
        if (!list.contains(e)){
            list.add(e);
        }
        else {
            System.out.println("Estudiante ya esta en la lista");
        }
    }
    
    public static void printLista(ArrayList<Estudiante> list){
        for (Estudiante e : list){
            System.out.println(e.tusDatos());
        }
    }
    

    public static void main(String[] args) {
        ArrayList<Estudiante> list = new ArrayList<>();
        
        Estudiante e1 = new Estudiante ("Pepe", "Gonzalez", "pepe@gmail.com" , 1 , "511 17");
        Estudiante e2 = new Estudiante ("Jorge", "Perez", "jorge@gmail.com" , 13 , "1 48");
        Estudiante e3= new Estudiante ("Santi", "Ubeid" , "santi@gmail.com", 10 , "508");
        
        // INCISO D
            // PRIMER INCISO, GENERO ARRAYLIST CON 3 ESTUDIANTES
        list.add(e1);
        list.add(e2);
        list.add (e3);
        
            // SEGUNDO INCISO, CREAR UNA LISTA COPIADA
        ArrayList<Estudiante> copylist = new ArrayList<>(list);
                                    // = ArrayList<Estudiante> list.clone()
       
            // TERCER INCISO (AMBAS SON IGUALES)        
        printLista(list);
        printLista(copylist);
        
            // CUARTO INCISO, MODIFICO UN CAMPO
        e2.setNombre("TE MODIFICO");
        
            // QUINTO INCISO, IMPRIMO LISTAS, AMBAS SE MODIFICAN PQ EN MEMORIA APUNTAN A LO MISMO
        printLista(list);
        printLista(copylist);
        
        // INCISO E
            // CREO NUEVO ESTUDIANTE Y LO AGREGO, LUEGO MANDO UNO YA EXISTENTE PARA TESTEAR
        Estudiante e4 = new Estudiante("NUEVO E","APELLIDO","lala@gmail.com",10,"Belgrano");
        addEstudiante(list,e4);
        addEstudiante(list,e3);
    }
    
}
