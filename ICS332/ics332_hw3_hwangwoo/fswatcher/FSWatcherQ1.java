package fswatcher;

import java.util.function.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;

public class FSWatcherQ1 {
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

        InputStream  sstdout = p.getInputStream();
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
