package com.demo.demoShop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemDTO {
    private int id;
    private String name;
    private String description;
    private int price;

}
