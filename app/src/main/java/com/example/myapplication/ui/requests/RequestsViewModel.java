package com.example.myapplication.ui.requests;

public class RequestsViewModel {
    String category,content,subject,visibility;

    public RequestsViewModel(){}

    public RequestsViewModel(String category, String content, String subject, String visibility) {
        this.category = category;
        this.content = content;
        this.subject = subject;
        this.visibility = visibility;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
