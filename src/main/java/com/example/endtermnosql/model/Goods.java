package com.example.endtermnosql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("salon")
@Data
public class Goods {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Field(name="name")
    private String name;
    @Field(name="type")
    private String type;
    @Field(name="cost")
    private int cost;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
