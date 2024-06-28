package com.example.projectserviceaprbatch.inheritanceDemo.mappedsuperclass.joinedtable;

import jakarta.persistence.Entity;

@Entity(name="jt_mentor")
public class Mentor extends User {

    private String compname;
    private double avgrating;

}
