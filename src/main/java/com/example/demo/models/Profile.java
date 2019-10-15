package com.example.demo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
    public Long points;
    public String name;
    public Long User_id;

    public Profile(){

    }

    public Profile(Long id, Long points, String name, Long user_id) {
        this.id = id;
        this.points = points;
        this.name = name;
        this.User_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser_id() {
        return User_id;
    }

    public void setUser_id(Long user_id) {
        this.User_id = user_id;
    }

    @Override
    public String toString() {
        return "Profile [name=" + name + ", points=" + points + "]";
    }
    


}