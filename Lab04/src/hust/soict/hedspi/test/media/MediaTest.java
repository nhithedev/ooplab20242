package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;

public class MediaTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<>();
        
        // Create sample media
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski", 136, 19.99f);
        CompactDisc cd = new CompactDisc("Thriller", "Pop", 24.99f, "Michael Jackson");
        Book book = new Book("Dune", "Sci-Fi", 15.99f);
        
        // Add to list
        mediaList.add(dvd);
        mediaList.add(cd);
        mediaList.add(book);
        
        // Display all media
        System.out.println("MEDIA IN LIST:");
        for (Media m : mediaList) {
            System.out.println(m); // implicitly calls toString()
        }
    }
}