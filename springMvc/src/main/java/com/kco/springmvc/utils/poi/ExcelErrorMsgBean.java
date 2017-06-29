package com.kco.springmvc.utils.poi;

/**
 * Excel解析数据信息
 * Created by Administrator on 2017/5/24.
 */
public class ExcelErrorMsgBean{
    private int row;
    private int line;
    private String message;

    public ExcelErrorMsgBean(int row, int line, String message) {
        this.row = row;
        this.line = line;
        this.message = message;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
