package com.example.todolistview;

public class Todo {


    private String Tittle;
    private String description;
    private int image;

    public Todo(String tittle, String description, int image) {
        this.image = image;
        Tittle = tittle;
        this.description = description;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
