package com.example.resourcepatternbasicsjava.data;

import java.util.Objects;

public class CommentResponseItem {
    private String body;
    private String email;
    private int id;
    private String name;
    private int postId;

    public CommentResponseItem(String body, String email, int id, String name, int postId) {
        this.body = body;
        this.email = email;
        this.id = id;
        this.name = name;
        this.postId = postId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "CommentResponseItem{" +
                "body='" + body + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", postId=" + postId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentResponseItem that = (CommentResponseItem) o;
        return id == that.id &&
                postId == that.postId &&
                Objects.equals(body, that.body) &&
                Objects.equals(email, that.email) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, email, id, name, postId);
    }
}
