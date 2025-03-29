package practica1.ej8;


public class CircularQueue<T> extends Queue<T>{
    public T shift(){
        // SACA AL PRIMERO Y LO PONE AL FINAL Y LO RETORNA (O ESO ENTENDI)
        T data = dequeue();
        enqueue(data);
        return data;
    }
}
