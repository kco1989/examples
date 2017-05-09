package com.kco.secret.demo2;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by Administrator on 2017/5/9.
 */
public class Example1 {
    public static void main(String[] args) {
        Base64 base64 = new Base64();
        Base32 base32 = new Base32();
        String s = base32.encodeToString("I'm jack".getBytes());
        System.out.println(s);
        byte[] ENCODE_TABLE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
        for (byte b : ENCODE_TABLE){
            System.out.println((char) b);
        }
    }
}
