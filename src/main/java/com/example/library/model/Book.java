package com.example.library.model;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private int copiesAvailable;

    public Book(String isbn, String title, String author, int copiesAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getCopiesAvailable() { return copiesAvailable; }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }
}
