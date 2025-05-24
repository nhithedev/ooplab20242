package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;

    // Corrected constructor - using super() to call parent constructor
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);  // Initialize parent class fields
        this.authors = new ArrayList<>();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost); // Call the parent class constructor
        this.authors = new ArrayList<>(); // Initialize the authors list
    }

	// Author management methods
    public void addAuthor(String authorName) {
        if (authorName != null && !authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authorName != null && authors.contains(authorName)) {
            authors.remove(authorName);
        }
    }
    @Override
    public String toString() {
        return String.format("Book - %s - %s: $%.2f",
                getTitle(), getCategory(), getCost());
    }
    // Optional getter for authors
    public ArrayList<String> getAuthors() {
        return new ArrayList<>(authors); // Return a copy for encapsulation
    }
}