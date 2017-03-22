package com.example.model;

/**
 * Created by NeverForgive on 2017-03-22.
 */
public class Library {

    public enum Genre{
        Fantasy, Drama, Romance, Horror, Comedy
    }

    private long id;
    private String bookName;
    private Genre genre;

    public Library() {
    }


    public Library(long id, String bookName, Genre genre) {
        this.id = id;
        this.bookName = bookName;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", genre=" + genre +
                '}';
    }
}
