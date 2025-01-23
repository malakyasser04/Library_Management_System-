package com.company;
import java.io.Serializable;

public class books implements Serializable {

    private int id;
    private String title;
    private String authorName;
    private String genre;
    private int availabilityStatus;
    private Queue1 requestsQ;

    public books(int id, String title, String authorName, String genre, int availabilityStatus) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
        this.requestsQ = new Queue1();
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(int availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public Queue1 getRequestsQ() {
        return requestsQ;
    }

    @Override
    public String toString() {
        return "books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", genre='" + genre + '\'' +
                ", availabilityStatus=" + availabilityStatus +
                ", requestsQ=" + requestsQ +
                '}';
    }
}