// com/chat/ChatWithMe/model/ChatMessage.java
package com.chat.ChatWithMe.model;

public class ChatMessage {
    private String sender;
    private String content;

    public ChatMessage() {}                   // required
    public ChatMessage(String sender, String content) {
        this.sender = sender; this.content = content;
    }
    public String getSender()  { return sender;  }
    public void setSender(String s) { this.sender = s; }
    public String getContent() { return content; }
    public void setContent(String c) { this.content = c; }
}
