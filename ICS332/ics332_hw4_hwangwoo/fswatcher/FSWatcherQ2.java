package fswatcher;

import java.util.function.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;

public class FSWatcherQ2 {
    
    public class Worker implements Runnable {
        
        private Process p;
        private Consumer<String> method;

        public Worker(Process p, Consumer<String> method) {
            this.p = p;
            this.method = method;
        }

        @Override
        public void run() {
            
            InputStream sstdout = p.getInputStream();
            BufferedReader stdout = new BufferedReader(new InputStreamReader(sstdout));
            String line;
            
            while(true) {
                try {
                    line = stdout.readLine();
                    if (line == null) {
                        break;
                    } else {
                        method.accept(line);
                    }
                } catch (IOException e) {
                }
            }
        }
    }
    
    public void watch(String dirname, Consumer<String> method) {
        String[] tokens = ("inotifywait -e create -m " + dirname).split("[ \t\n]+");
        Process p = null;
        ProcessBuilder pb = new ProcessBuilder(tokens);

        try {
            p = pb.start();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        Worker worker = new Worker(p, method);
        Thread thread = new Thread(worker);
        thread.start();
    }
}
