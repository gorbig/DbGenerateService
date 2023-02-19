package com.example.endtermnosql.model;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("news")
@Data
public class News {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Field(name="name")
    private String name;
    @Field(name="time")
    private String time;
    @Field(name="numberOfComment")
    private int coments;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getComents() {
        return coments;
    }

    public void setComents(int coments) {
        this.coments = coments;
    }
}
