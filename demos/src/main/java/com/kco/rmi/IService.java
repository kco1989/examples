package com.kco.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2017/7/24.
 */
public interface IService extends Remote{

    String queryName(String no) throws RemoteException;
}
