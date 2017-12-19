package com.kco.book;

import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by 666666 on 2017/11/28.
 */
public class BookCrawlerRun {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("H:\\testWork\\allExample\\example\\demos\\src\\main\\java\\com\\kco\\book\\config.yml");
        BookInfo bookInfo = Yaml.loadType(file, BookInfo.class);
        System.out.println(bookInfo);
    }
}
