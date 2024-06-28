package com.example.projectserviceaprbatch.inheritanceDemo.mappedsuperclass.joinedtable;



import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_TA")
public class TA extends User {

    private int numberofsession;
    private double avgrating;
}
