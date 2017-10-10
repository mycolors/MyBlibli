package com.fengniao.myblibli.bean;

//用于保存日夜状态的枚举类
public enum DayNight{

    DAY("DAY", 0),
    NIGHT("NIGHT", 1);

    private DayNight(String name, int code) {
        this.name = name;
        this.code = code;
    }

    private String name;
    private int code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
