package com.example.projectserviceaprbatch.inheritanceDemo.mappedsuperclass.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name="mps_mentor")
public class Mentor extends User{

    private String compname;
    private double avgrating;

}
