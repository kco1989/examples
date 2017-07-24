package com.kco.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteRef;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/24.
 */
public class Client {
    public static void main(String[] args) {
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1", 8088);
            String[] list = registry.list();
            System.out.println(Arrays.toString(list));
            IService service = (IService)registry.lookup("vince");
            String result = service.queryName("ha ha ha");
            System.out.println("result from remote: " + result);
        }catch (Exception e){

        }
    }
}
