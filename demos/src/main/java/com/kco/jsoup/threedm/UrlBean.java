package com.kco.jsoup.threedm;

/**
 * Created by lvsw on 2017/11/9.
 */
public class UrlBean {
    private String url;
    private String name;

    public UrlBean(String name, String url) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
