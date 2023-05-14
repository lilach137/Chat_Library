package com.example.chat_library;

public class Message {
    private String dateTime;
    private String content;
    private String sender;
    //private int order;

    public Message(String dateTime, String content, String sender) {
        this.dateTime = dateTime;
        this.content = content;
        this.sender = sender;
        //this.order = order;
    }

    public Message() {
    }

    public String getDateTime() {
        return dateTime;
    }

    public Message setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public Message setSender(String sender) {
        this.sender = sender;
        return this;
    }

//    public int getOrder() {
//        return order;
//    }
//
//    public Message setOrder(int order) {
//        this.order = order;
//        return this;
//    }
}
