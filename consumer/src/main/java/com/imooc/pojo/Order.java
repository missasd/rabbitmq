package com.imooc.pojo;

import java.io.Serializable;

public class Order implements Serializable {
    /**
     * 通过网络进行传输所以需要版本号
     */
    private static final long serialVersionUID = -1165342379376771510L;
    private Integer id;
    private String name;
    private String messageId; // 存储消息发送的唯一Id

    public Order() {
    }

    public Order(Integer id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
