package com.ax.demo.nio;

import java.nio.IntBuffer;

public class BasicBuffer {

    /// buffer的使用 buffer缓冲区,内存块
    public static void main(String[] args) {
        //创建5个int的 buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //向buff中存放数据
        intBuffer.put(2);
        intBuffer.put(3);
        // 读写切换
        intBuffer.flip();
        // 取数据 intBuffer.get() 默认取第一个,get一次,位置移动一位,所以这里 被改变一次
//        System.out.println("intBuffer = " + intBuffer.get());
//        System.out.println("intBuffer = " + intBuffer.get());

        while (intBuffer.hasRemaining()) {
            System.out.println("intBuffer.get() = " + intBuffer.get());
        }


    }
}
