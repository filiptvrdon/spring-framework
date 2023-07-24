package sk.filiptvrdon.restfulwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
    private long id;
    
    @Size(min=2, message = "Name must have at least 2 characters")
    @JsonProperty("user_name")
    private String name;
    
    @Past(message="Date of birth must be in the past")
    private LocalDate birthDate;

    public User(long id, String name, LocalDate birthDate) {
	super();
	this.id = id;
	this.name = name;
	this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
	return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }
    
    
    
    
}
