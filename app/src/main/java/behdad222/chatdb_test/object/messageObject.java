package behdad222.chatdb_test.object;

import io.realm.RealmObject;

/**
 * Created by behdad on 3/31/15.
 */

public class messageObject extends RealmObject {

    private double id;
    private String conversationId;
    private String senderId;
    private String body;
    private int type;
    private int status;
    private String date;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
