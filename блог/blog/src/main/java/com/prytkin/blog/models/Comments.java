package com.prytkin.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, text;
    private Long parentId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setParentId(Long parentId){
        this.parentId = parentId;
    }

    public Long getParentId(){
        return parentId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public Comments(){
    }

    public Comments(String name, String text, Long parentId) {
        this.name = name;
        this.text = text;
        this.parentId = parentId;
    }
}
