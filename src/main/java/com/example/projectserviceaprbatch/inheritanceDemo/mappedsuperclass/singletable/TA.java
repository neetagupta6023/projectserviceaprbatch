package com.example.projectserviceaprbatch.inheritanceDemo.mappedsuperclass.singletable;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_TA")
@DiscriminatorValue(value = "1")
public class TA extends User {

    private int numberofsession;
    private double avgrating;
}
