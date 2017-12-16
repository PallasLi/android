package cn.pallasli.pmqchat.bean;

public class Friend {
    private String id;
    private String owner;
    private String ownerGroupId;
    private String friendName;
    private String friendCaption;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerGroupId() {
        return ownerGroupId;
    }

    public void setOwnerGroupId(String ownerGroupId) {
        this.ownerGroupId = ownerGroupId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendCaption() {
        return friendCaption;
    }

    public void setFriendCaption(String friendCaption) {
        this.friendCaption = friendCaption;
    }
}
