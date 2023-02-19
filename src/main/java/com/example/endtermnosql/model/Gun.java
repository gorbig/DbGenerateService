package com.example.endtermnosql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("gun")
@Data
public class Gun {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Field(name="title")
    private String title;
    @Field(name="articul")
    private String articul;
    @Field(name="produce")
    private String produce;
    @Field(name="cost")
    private int cost;
    @Field(name="oldcost")
    private int oldcost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOldcost() {
        return oldcost;
    }

    public void setOldcost(int oldcost) {
        this.oldcost = oldcost;
    }
}
