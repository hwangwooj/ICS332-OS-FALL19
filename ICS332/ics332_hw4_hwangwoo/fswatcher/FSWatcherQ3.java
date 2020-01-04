package fswatcher;

import java.util.function.*;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;

public class FSWatcherQ3 {
    private static HashMap<String, Process> Hash_watcher = new HashMap<> ();
    

    public void watch(String dirname, Consumer<String> method) {
        String[] tokens = ("inotifywait -e create -m " + dirname).split("[ \t\n]+");
        Process p = null;
        ProcessBuilder pb = new ProcessBuilder(tokens);

        try {
            Hash_watcher.put(dirname, pb.start());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        Worker worker = new Worker(Hash_watcher.get(dirname), method);
        Thread thread = new Thread(worker);
        thread.start();
    }
    
    public void stopWatch(String dirname) {
        Hash_watcher.get(dirname).destroy();
    }
}
