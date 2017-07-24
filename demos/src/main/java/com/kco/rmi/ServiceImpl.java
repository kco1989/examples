package com.kco.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Administrator on 2017/7/24.
 */
public class ServiceImpl extends UnicastRemoteObject implements IService {

    protected ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String queryName(String no) throws RemoteException {
        System.out.println("Hello " + no);
        return no + " --> " + System.currentTimeMillis();
    }
}
