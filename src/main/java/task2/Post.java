package task2;

import java.util.Objects;

public class Post {
    private int userId, id;
    private String title, body;

    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return userId == post.userId && id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id);
    }

    @Override
    public String toString() {
        return "User-" + getUserId() + ", post-" + getId() + " {'" + getTitle() + "': '" + getBody() + "'}";
    }
}
