package id.java.doggycat.model.response;

import java.util.HashMap;
import java.util.List;

public class ResponseData<T> {

    private boolean status;
    private List<String> messages;
    private HashMap<String, Object> payload;

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public List<String> getMessages() {
        return messages;
    }
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
    public HashMap<String, Object> getPayload() {
        return payload;
    }
    public void setPayload(HashMap<String, Object> payload) {
        this.payload = payload;
    }

    
    
}
