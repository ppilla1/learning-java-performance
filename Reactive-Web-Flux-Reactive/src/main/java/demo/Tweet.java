package demo;

import java.io.Serializable;


public class Tweet implements Serializable {
    private String text;
    private String username;

    public Tweet() {

    }

    public Tweet(String text, String username) {
        super();
        this.text = text;
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
