package com.kco.book;

import java.util.List;

/**
 * Created by 666666 on 2017/11/28.
 */
public class BookInfo {
    private List<String> urls;
    private String bookNameXPath;
    private String chapterAnchorXPath;
    private String contentXPath;

    public List<String> getUrls() {
        return urls;
    }

    public BookInfo setUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }

    public String getBookNameXPath() {
        return bookNameXPath;
    }

    public BookInfo setBookNameXPath(String bookNameXPath) {
        this.bookNameXPath = bookNameXPath;
        return this;
    }

    public String getChapterAnchorXPath() {
        return chapterAnchorXPath;
    }

    public BookInfo setChapterAnchorXPath(String chapterAnchorXPath) {
        this.chapterAnchorXPath = chapterAnchorXPath;
        return this;
    }

    public String getContentXPath() {
        return contentXPath;
    }

    public BookInfo setContentXPath(String contentXPath) {
        this.contentXPath = contentXPath;
        return this;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "urls=" + urls +
                ", bookNameXPath='" + bookNameXPath + '\'' +
                ", chapterAnchorXPath='" + chapterAnchorXPath + '\'' +
                ", contentXPath='" + contentXPath + '\'' +
                '}';
    }
}
