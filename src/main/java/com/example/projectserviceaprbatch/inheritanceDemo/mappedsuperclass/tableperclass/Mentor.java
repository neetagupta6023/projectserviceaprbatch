package com.example.projectserviceaprbatch.inheritanceDemo.mappedsuperclass.tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class Mentor extends User {

    private String compname;
    private double avgrating;

}
