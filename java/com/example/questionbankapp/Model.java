package com.example.questionbankapp;

public class Model {
    private String id,title,body;

    public Model(String id,String title,String body){
        this.id=id;
        this.title=title;
        this.body=body;

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
