package com.example.projectserviceaprbatch.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
   }
