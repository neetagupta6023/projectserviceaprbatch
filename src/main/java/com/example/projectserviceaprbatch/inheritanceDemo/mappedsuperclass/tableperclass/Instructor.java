package com.example.projectserviceaprbatch.inheritanceDemo.mappedsuperclass.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_it")
public class Instructor extends User {
    private String specialsession;
}
