package cn.wfc.security.bean;

import java.util.List;

public class LayuiTableResult<T> {
    private int code;
    private String msg;
    private int count;
    private List<T> data;

    public LayuiTableResult() {
    }

    public LayuiTableResult(List<T> data) {
        this.code=0;
        this.count = data.size();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
