package com.example.retrofitbasicsjava.data;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Post {
    private final int userId;
    private final int id;
    private final String title;

    @SerializedName("body")
    private final String content;

    public Post(int userId, int id, String title, String content) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return userId == post.userId &&
                id == post.id &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, title, content);
    }
}
