package com.kco.secret.demo1;

/**
 * 移位加密
 * Created by pc on 2017/5/8.
 */
public class Example1 {
    public static final String ASCII = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String context = "Hello, I'm Jack.";
        String encryp = encryp(context, 200);
        String encryp1 = encryp(encryp, -200);
        System.out.println("原文: " + context);
        System.out.println("加密: " + encryp);
        System.out.println("解密: " + encryp1);
    }

    /**
     * 加密/解密算法
     * @param context 原文
     * @param count   位移数
     * @return  加密/解密后的字符串
     */
    public static String encryp(String context, int count){
        StringBuilder sb = new StringBuilder();
        for (char ch : context.toCharArray()){
            int i = ASCII.indexOf(ch);
            if (i == -1){
                sb.append(ch);
            }else{
                i = ((i + count % ASCII.length()) + ASCII.length()) % ASCII.length();
                sb.append(ASCII.charAt(i));
            }
        }
        return sb.toString();
    }


}
