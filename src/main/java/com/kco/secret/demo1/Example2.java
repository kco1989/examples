package com.kco.secret.demo1;

import java.util.Arrays;

/**
 * 异或加密
 * Created by pc on 2017/5/8.
 */
public class Example2 {
    public static void main(String[] args) {
        String context = "Hello, I'm Jack.";
        byte[] encryp = encryp(context.getBytes(), (byte)200);
        byte[] encryp1 = encryp(encryp, (byte)200);
        System.out.println("原文: " + context);
        System.out.println("加密: " + Arrays.toString(encryp));
        System.out.println("解密: " + new String(encryp1));
    }

    /**
     * 异或加密
     * @param context 原文
     * @param count   异或值
     * @return 加密后的数据
     */
    public static byte[] encryp(byte[] context, byte count){
        byte[] encryp = new byte[context.length];
        int index = 0;
        for (byte b : context){
            encryp[index ++] = (byte)(b ^ count);
        }
        return encryp;
    }
}
