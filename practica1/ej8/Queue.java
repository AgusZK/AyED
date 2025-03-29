package practica1.ej8;
import java.util.LinkedList;
import java.util.List;

public class Queue<T> extends Sequence {
    protected List<T> data;
    // INCISO A
    // CONSTRUCTOR
    public Queue (){
        this.data = new LinkedList<T>();
    }
    
    // AGREGA UN DATO AL FINAL
    public void enqueue(T dato){
        data.add(dato);
    }
    
    // ELIMINA DEL FRENTE DE LA PILA Y LO RETORNA
    public T dequeue(){
        return data.remove(0);
    }
    
    // DEVUELVE EL PRIMERO DE LA FILA, ERROR SI NO HAY NADA
    public T head(){
        return data.get(0);
    }
    
    // RETORNA TRUE SI COMPARA Y EL TAMAÑO DA 0
    @Override
    public boolean isEmpty(){
        return data.isEmpty();
    }
    
    // RETORNA CANT DE ELEMENTOS
    @Override
    public int size(){
        return data.size();
    }
    
    // DEVUELVE EN UN STRING LOS ITEMS DE LA COLA
    @Override
    public String toString(){
        String s = "{";
        for (T dato: data){
            s = s + dato + " ";
        }
        return s;
    }
}
