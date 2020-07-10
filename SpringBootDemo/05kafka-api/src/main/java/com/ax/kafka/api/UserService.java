package com.ax.kafka.api;

public interface UserService {

    /**
     * 获取队列消息
     * @return
     */
    String getMsg();

    /**
     * 获取消息使用的此方法，getMsg反应慢
     * @return
     */
    String getMsg2();

    /**
     * 修改消息一读壮体啊
     * @param fuBh
     */
    void resolve(Long fuBh);
}
