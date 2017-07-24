package com.kco.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Administrator on 2017/7/24.
 */
public class Server {
    public static void main(String[] args) {
        Registry registry = null;
        try{
            registry = LocateRegistry.createRegistry(8088);
            ServiceImpl service = new ServiceImpl();
            registry.rebind("vince", service);
            System.out.println("bind server");
        }catch (RemoteException e){

        }
    }
}
