package cn.pallasli.pmqchat.bean;

import java.util.Date;

public class ChatMessage {
    private String id;
    private String fromUserName;
    private String fromUserIcon;//图标
    private String fromUserCaption;//备注
    private String toUserName;
    private String toUserIcon;//图标
    private String toUserCaption;//备注
    private String message;
    private Date fromTime;
    private int messageType;//1:普通文本，2:富文本，3:文件，4:远程，5:视频，6:电话

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromUserCaption() {
        return fromUserCaption;
    }

    public void setFromUserCaption(String fromUserCaption) {
        this.fromUserCaption = fromUserCaption;
    }

    public String getFromUserIcon() {
        return fromUserIcon;
    }

    public void setFromUserIcon(String fromUserIcon) {
        this.fromUserIcon = fromUserIcon;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserCaption() {
        return toUserCaption;
    }

    public void setToUserCaption(String toUserCaption) {
        this.toUserCaption = toUserCaption;
    }

    public String getToUserIcon() {
        return toUserIcon;
    }

    public void setToUserIcon(String toUserIcon) {
        this.toUserIcon = toUserIcon;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}
