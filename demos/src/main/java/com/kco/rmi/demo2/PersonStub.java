package com.kco.rmi.demo2;

import org.apache.taglibs.standard.tag.common.core.OutSupport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2017/7/24.
 */
public class PersonStub implements Person{
    private Socket socket;
    public PersonStub() throws IOException {
        socket = new Socket("127.0.0.1", 9000);
    }

    @Override
    public int getAge() throws Throwable {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject("age");
        out.flush();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return in.readInt();
    }

    @Override
    public String getName() throws Throwable {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject("name");
        out.flush();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return (String) in.readObject();
    }
}
