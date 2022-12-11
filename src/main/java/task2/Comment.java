package task2;

import java.util.Objects;

public class Comment {
    private int postId, id;
    private String name, email, body;

    public Comment(int postId, String name, String email, String body) {
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return postId == comment.postId && id == comment.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, id);
    }

    @Override
    public String toString() {
        return "Comment-" + getId() + " to post-" + getPostId() + " from '" + getEmail() + "' {" + getName() + "': '" + getBody() + "'}";
    }
}
