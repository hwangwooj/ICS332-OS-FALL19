package kvstore;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.io.*;

public class KVServer2 extends UnicastRemoteObject implements KVInterface {

    private static final String serverName = "rmi://localhost/Server";
    
    protected HashMap<String, String> Hash_data = new HashMap<> ();

    // Custom constructor that throws the required exception
    protected KVServer2() throws RemoteException {
        super();
    }

    @Override
    public void insert(String key, String value) throws RemoteException {
        Hash_data.put(key, value);
    }

    @Override
    public String lookup(String key) throws RemoteException, KeyNotFound {
        String temp = null;
        try {
            temp = Hash_data.get(key);
            if(temp == null) {
                temp = "Unknown key";
            }
        } catch(Exception e) {
        }
        return temp;
    }

    public void shutdown() throws RemoteException  {
        try{
            // Unregister ourself
            Naming.unbind(serverName);
            // Unexport; this will also remove us from the RMI runtime
            UnicastRemoteObject.unexportObject(this, true);
            System.out.println("KVServer: exiting!");
        } catch(Exception e) {
            // too bad
        }
    }
    
    public static int check_rmi() {
        int on = 1;
        String[] tokens1 = ("ps -o pid= -C rmiregistry").split("[ \t\n]+");
        String temp = null;
        Process p1 = null;
        ProcessBuilder pb1 = new ProcessBuilder(tokens1);
        try {
            p1 = pb1.start();
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        InputStream sstdout = p1.getInputStream();
        BufferedReader stdout = new BufferedReader(new InputStreamReader(sstdout));
        
        try {
            if (stdout.readLine() == null) {
                on = 0;
        }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return on;
    }
    
    public static void start_rmi() {
        String[] tokens2 = ("rmiregistry 1099").split("[ \t\n]+");
        Process p2 = null;
        ProcessBuilder pb2 = new ProcessBuilder(tokens2);
        try {
            p2 = pb2.start();
            Thread.sleep(1000);
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        
    }

    public static void main(String[] args) {
        
        int ready = check_rmi();
        
        if (ready == 0) {
            System.out.println("KVServer: Starting RMI Registry…");
            start_rmi();
            System.out.println("KVServer: RMI Registry started");
        } else {
            System.out.println("KVServer: RMI Registry already running!");
        }
        
        try {
            // Register myself to the RMI Registry
            System.err.println("KVServer: Registering to RMI Registry...");
            Naming.rebind(serverName, new KVServer2());
            System.err.println("KVServer: Registered to RMI Registry...");
        } catch (Exception e) {
            System.err.println("KVServer: exception: " + e.toString());
            e.printStackTrace();
            System.exit(0);
        }
    }
}
