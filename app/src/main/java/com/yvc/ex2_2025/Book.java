// File Name: Book.java
// Students Name: Omer Gamliel | ID: 209052786
// Students Name: Batel Gofleyzer | ID: 211869409
// Course Name: 62187 Application Development for Smart Devices

package com.yvc.ex2_2025;
import java.time.LocalDate;

// Book Class
public class Book {
    private String name; // Book name
    private String author; // Book author
    private int coverID; // Book cover image ID
    private String url; // Book url
    private LocalDate returnDate; // Book return date

    // Constructor to initialize the book details
    public Book(String name, String author, int coverID,String url) {
        setName(name);
        setAuthor(author);
        setCoverId(coverID);
        setUrl(url);
    }

  // Getters & Setters for book class attributes
    // Method to get the name of the book
    public String getName() {
        return name;
    }

    // Method to get the author of the book
    public String getAuthor() {
        return author;
    }

    // Method to get the cover ID of the book
    public int getCoverID() {
        return coverID;
    }

    // Method to set the name of the book
    public void setName(String name) {
        this.name = name;
    }

    // Method to set the cover ID of the book
    public void setCoverId(int coverID) {
        this.coverID = coverID;
    }

    // Method to set the author of the book
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to set the URL of the book
    public void setUrl(String url) {
        this.url = url;
    }

    // Method to get the URL of the book
    public String getUrl() {
        return url;
    }

    // Method to set the return date
    public void setReturndate(LocalDate returndate) {
        this.returnDate = returndate;
    }

    // Method to get the return date
    public LocalDate getReturndate() {
        return returnDate;
    }

    // Equals method to compare two Book objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Check if the object is null or not of the same clas

        Book other = (Book) obj; // Cast the object to Book
        return this.name.equals(other.name) && this.author.equals(other.author); // Compare name and author
    }
}