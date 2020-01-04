package kvstore;

import java.rmi.*;
import java.util.*;
import java.io.*;

public class KVClient {

    public static void main(String[] args) {
        
        try {
            
            Object obj = Naming.lookup("rmi://localhost/Server");
            KVInterface remoteObj = (KVInterface)obj;
            int args_num = args.length;
            
            if(args_num == 0 || args_num > 3 ) {
                System.out.println("Usage: java kvstore.KVClient [ shutdown | insert <key> <value> | lookup <key> ]");
            } else {
                  if(args[0].equals("insert") && args_num == 3) {
                      remoteObj.insert(args[1], args[2]);
                  }
                  else if(args[0].equals("lookup") && args_num == 2) {
                      System.out.println(remoteObj.lookup(args[1]));
                  }
                  else if(args[0].equals("shutdown") && args_num == 1) {
                      remoteObj.shutdown();
                  }
                  else {
                      System.out.println("Usage: java kvstore.KVClient [ shutdown | insert <key> <value> | lookup <key> ]");
                  }
            }
        }
        catch(Exception e) {
        }
    }
}
