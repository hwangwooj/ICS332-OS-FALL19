package paths;

public class ComputePaths {
    
    public class Worker implements Runnable {
        private int graph_size;
        private int limit;
        private int head;
        
        public Worker(int graph_size, int limit, int head){
            this.graph_size = graph_size;
            this.limit = limit;
            this.head = head;
        }
        
        @Override
        public void run(){
            try {
                for (long i = head; i < head + limit ; i++) {
                    new FloydWarshall(graph_size, i).floydWarshall();
                }
            } catch (Exception e) {
                System.out.println ("Exception is caught");
            }
        }
    }


    public void compute(int graph_size, int num_threads) {
        
        Thread TArray[] = new Thread[num_threads];
        int graphs_per_thread = 2520/num_threads;
        int first = 0;
        
        for(int i=0; i <num_threads; i++) {
            TArray[i] = new Thread(new Worker(graph_size, graphs_per_thread, first));
            TArray[i].start();
            first = first + graphs_per_thread;
        }
        
        for(int i=0; i <num_threads; i++) {
            try {
                TArray[i].join();
                
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Usage: java ComputePaths <graph size> <# threads>");
            System.exit(1);
        }

        int graph_size = 0;
        int num_threads = 0;
        try {
            graph_size = Integer.parseInt(args[0]);
            num_threads = Integer.parseInt(args[1]);
            if ((graph_size <= 0) || (num_threads < 1)) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid command-line arguments");
            System.exit(1);
        }

        double now = System.currentTimeMillis();

        new ComputePaths().compute(graph_size, num_threads);

        System.out.println("All graphs computed in " + (System.currentTimeMillis() - now) / 1000 + " seconds");

    }
}

