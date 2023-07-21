package sk.filiptvrdon.firstspringwebapp.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class TodoItem {
    private long id;
    private String username;
    
    @Size(min=3,message="Enter at least 3 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public TodoItem(long id, String username, String description, LocalDate targetDate, boolean done) {
	super();
	this.id = id;
	this.username = username;
	this.description = description;
	this.targetDate = targetDate;
	this.done = done;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public LocalDate getTargetDate() {
	return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
	this.targetDate = targetDate;
    }

    public boolean isDone() {
	return done;
    }

    public void setDone(boolean done) {
	this.done = done;
    }

}
