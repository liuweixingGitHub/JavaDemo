package com.ax.demo.util.axtools;

public enum AxReslutStatus {

    SUCCESS(true,"成功"),
    FAILURE(false,"失败");

    private final boolean value;
    private final String reasonPhrase;

    private AxReslutStatus(boolean value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public boolean getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.reasonPhrase;
    }
}


