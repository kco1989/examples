package com.kco.multicast;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class MulticastClient extends JFrame implements Runnable, ActionListener {
    private static final long serialVersionUID = -5923790809266120014L;
    int port;
    InetAddress group = null;
    MulticastSocket socket = null;
    JButton startButton;
    JButton stopButton;
    JButton cleanButton;
    JButton sendButton;
    JTextArea currentMsg;
    JTextArea receiveMsg;
    JTextArea sendField;
    Thread thread;
    boolean isStop = false;//停止接收广播信息的标志  

    public MulticastClient() {
        setTitle("接收广播信息");
        Container container = this.getContentPane();
        startButton = new JButton("开始接收");
        stopButton = new JButton("停止接收");
        cleanButton = new JButton("清空信息");
        sendButton = new JButton("发送数据");
        sendField = new JTextArea(1,20);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        cleanButton.addActionListener(this);
        sendButton.addActionListener(this);
        currentMsg = new JTextArea(3, 20);//创建3行20列的多行文本框
        currentMsg.setForeground(Color.red);//设置字体颜色为红色  
        receiveMsg = new JTextArea(8, 20);//默认字体颜色为黑色
        container.setLayout(new BorderLayout());
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);//创建一带水平分隔条的面板
        JScrollPane currScrollPane = new JScrollPane();
        currScrollPane.setViewportView(currentMsg);
        JScrollPane recvScrollPane = new JScrollPane();
        recvScrollPane.setViewportView(receiveMsg);
        JScrollPane sendScrollPane = new JScrollPane();
        sendScrollPane.setViewportView(sendField);

        currentMsg.setEditable(false);
        receiveMsg.setEditable(false);

        sp.add(currScrollPane);
        sp.add(recvScrollPane);

        JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);//创建一带水平分隔条的面板
        sp2.add(sp);
        sp2.add(sendScrollPane);
//        sp.add(sendScrollPane);

        container.add(sp2, BorderLayout.CENTER);
        JPanel bottomJPanel = new JPanel();
        bottomJPanel.add(startButton);
        bottomJPanel.add(stopButton);
        bottomJPanel.add(cleanButton);
        bottomJPanel.add(sendButton);
        container.add(bottomJPanel, BorderLayout.SOUTH);
        setSize(500, 400);
        setVisible(true);
        thread = new Thread(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        port = 9876;
        try {
            group = InetAddress.getByName("230.198.112.0");
            socket = new MulticastSocket(port);
//            socket.joinGroup(group);
        } catch (Exception e) {

        }
    }

    public void actionPerformed(ActionEvent e1) {
        if (e1.getSource() == startButton) {
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            if (!(thread.isAlive())) {
                thread = new Thread(this);
            }
            try {
                thread.start();
                System.out.println("重新启动....");
                isStop = false;
            } catch (Exception ee) {

            }
        }
        if (e1.getSource() == stopButton) {
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            isStop = true;
        }
        if (e1.getSource() == cleanButton) {
            receiveMsg.setText("");
        }
        if (e1.getSource() == sendButton){

            byte[] buff = sendField.getText().getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length, group, port);
            try {
                socket.send(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        try {
            socket.joinGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            byte buff[] = new byte[8192];
            DatagramPacket packet = null;
            packet = new DatagramPacket(buff, buff.length, group, port);
            try {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                currentMsg.setText("正在接收的内容：\n" + message);
                receiveMsg.append(message + "\n");
            } catch (Exception e) {

            }
            if (isStop == true) {
                try {
                    socket.leaveGroup(group);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        System.out.println("退出....");
    }

    public static void main(String[] args) {
        new MulticastClient();
    }
}  