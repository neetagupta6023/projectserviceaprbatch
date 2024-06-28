package com.example.projectserviceaprbatch.inheritanceDemo.mappedsuperclass.tableperclass;



import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_TA")
public class TA extends User {

    private int numberofsession;
    private double avgrating;
}
