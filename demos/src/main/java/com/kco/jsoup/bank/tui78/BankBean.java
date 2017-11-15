package com.kco.jsoup.bank.tui78;

/**
 * Created by lvsw on 2017/11/15.
 */
public class BankBean {
    public String title;
    public String cityName;
    public String bankName;
    public String bankNo;
    public String address;

    @Override
    public String toString() {
        return title + "|" + cityName + "|" + bankName + "|" + bankNo + "|" + address + "\n";
    }
}
