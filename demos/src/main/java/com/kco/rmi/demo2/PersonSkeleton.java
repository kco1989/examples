package com.kco.rmi.demo2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/7/24.
 */
public class PersonSkeleton extends Thread {
    private PersonServer myServer;
    public PersonSkeleton(PersonServer server){
        this.myServer = server;
    }
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            Socket socket = serverSocket.accept();
            while (socket != null){
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                String method = (String) in.readObject();

                if (method.equals("age")){
                    int age = myServer.getAge();
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeInt(age);
                    oos.flush();
                }else if(method.equals("name")){
                    String name = myServer.getName();
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(name);
                    oos.flush();
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
