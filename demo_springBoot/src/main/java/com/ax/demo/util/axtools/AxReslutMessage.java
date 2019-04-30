package com.ax.demo.util.axtools;

public enum AxReslutMessage {

    OVERDUE(0,"过期"),
    INVALID(1,"参数无效");

    private final int value;
    private final String msg;

    private AxReslutMessage(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.msg;
    }
}


