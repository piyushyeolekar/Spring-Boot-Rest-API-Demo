package com.api.book.bootrestbook.entities;

public class book {
    private int id;
    private String title;
    private String author;
    
    public book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "book [author=" + author + ", id=" + id + ", title=" + title + "]";
    }
}