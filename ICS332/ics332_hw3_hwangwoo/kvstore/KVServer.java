package kvstore;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class KVServer extends UnicastRemoteObject implements KVInterface {

    private static final String serverName = "rmi://localhost/Server";
    
    protected HashMap<String, String> Hash_data = new HashMap<> ();

    // Custom constructor that throws the required exception
    protected KVServer() throws RemoteException {
        super();
    }

    @Override
    public void insert(String key, String value) throws RemoteException {
        try {
            Hash_data.put(key, value);
        } catch(Exception e) {
        }
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

    public static void main(String[] args) {

        try {
            // Register myself to the RMI Registry
            System.err.println("KVServer: Registering to RMI Registry...");
            Naming.rebind(serverName, new KVServer());
            System.err.println("KVServer: Registered to RMI Registry...");
        } catch (Exception e) {
            System.err.println("KVServer: exception: " + e.toString());
            e.printStackTrace();
            System.exit(0);
        }
    }
}
