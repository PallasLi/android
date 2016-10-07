package com.pallasli.bpmoa.model;

/**
 * Created by lyt1987 on 16/10/5.
 */
public class LeaveType {
    private int code;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String toString(){
        return value;
    }
}
