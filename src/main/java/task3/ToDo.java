package task3;

import java.util.Objects;

public class ToDo {
    private int userId, id;
    private String title;
    private Boolean completed;

    public ToDo(int userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo)) return false;
        ToDo toDo = (ToDo) o;
        return userId == toDo.userId && id == toDo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id);
    }

    @Override
    public String toString() {
        return "User-" + getUserId() + ", task-" + getId() + " {'" + getTitle() + "', completed: " + getCompleted() + "}";
    }
}
