package practica3;
import practica1.ej8.Queue;

// EJERCCIIO 4
public class AnalizadorArbol {
    public static class AreaEmpresa {
        private String id;
        private int delay;

        public AreaEmpresa(String id, int delay) {
            this.id = id;
            this.delay = delay;
        }

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
    
    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol){
        GeneralTree<AreaEmpresa> aux;
        Queue<GeneralTree<AreaEmpresa>> queue = new Queue<>();
        double max = -1;
        
        queue.enqueue(arbol);
        while (!queue.isEmpty()){
            int size = queue.size();
            int nodes = 0;
            int sum = 0;
            
            while (size != 0){
                aux = queue.dequeue();
                // SUMO NODOS Y AGREGO EN LA SUMATORIA EL DELAY
                nodes++;
                sum += aux.getData().getDelay();
                
                // PONGO TODOS LOS HIJOS EN LA QUEUE
                if(aux.hasChildren()){
                    for(GeneralTree<AreaEmpresa> child: aux.getChildren()){
                        queue.enqueue(child);
                    }
                }
                
                size--;
            }
            // TERMINO LOS NODOS Y ME GUARDO EL PROMEDIO DEL NIVEL ACTUAL
            double avg = sum/nodes;
            max = Math.max(max,avg); 
        }
        
        // CUANDO TERMINA DE PROCESAR TODO DEVUELVO EL MAXIMO PROMEDIO
        return max;
    }
}
    
    

