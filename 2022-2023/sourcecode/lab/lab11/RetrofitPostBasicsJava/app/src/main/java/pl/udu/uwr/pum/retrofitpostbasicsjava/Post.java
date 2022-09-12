package pl.udu.uwr.pum.retrofitpostbasicsjava;

import com.google.gson.annotations.SerializedName;

public class Post {
    private final Integer userId;
    private Integer id;
    private final String title;

    @SerializedName("body")
    String content;

    public Post(Integer userId, String title, String content) {
        this.userId = userId;
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
}
