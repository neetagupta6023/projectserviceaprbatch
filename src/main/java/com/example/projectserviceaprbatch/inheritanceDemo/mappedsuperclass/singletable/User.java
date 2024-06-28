package com.example.projectserviceaprbatch.inheritanceDemo.mappedsuperclass.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "st_user")
@DiscriminatorColumn(name = "user_type",discriminatorType = DiscriminatorType.INTEGER)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
