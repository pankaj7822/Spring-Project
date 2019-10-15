package com.example.demo.models;

public class Class{
    private long id;
    private String level;
    private long no_of_students;
    private long School_id;

    public Class(long id, String level, long no_of_students, long school_id) {
        this.id = id;
        this.level = level;
        this.no_of_students = no_of_students;
        School_id = school_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public long getNo_of_students() {
        return no_of_students;
    }

    public void setNo_of_students(long no_of_students) {
        this.no_of_students = no_of_students;
    }

    public long getSchool_id() {
        return School_id;
    }

    public void setSchool_id(long school_id) {
        School_id = school_id;
    }
}