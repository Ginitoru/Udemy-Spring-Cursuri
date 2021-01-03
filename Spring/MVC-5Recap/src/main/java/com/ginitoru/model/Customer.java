package com.ginitoru.model;

import com.ginitoru.validation.Course;

import javax.validation.constraints.NotNull;

public class Customer {

    @NotNull(message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    private String lastName;

    @Course
    private String course;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
