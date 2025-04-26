package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();
        
        // Create new media objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        cart.addMedia(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        cart.addMedia(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);
        
        // Add some books
        Book book1 = new Book(4, "The Hobbit", "Fantasy", 15.50f);
        book1.addAuthor("J.R.R. Tolkien");
        cart.addMedia(book1);
        
        // Add some compact discs
        CompactDisc cd1 = new CompactDisc(5, "Greatest Hits", "Rock", 12.99f, "Queen");
        Track track1 = new Track("Bohemian Rhapsody", 355);
        Track track2 = new Track("Another One Bites the Dust", 214);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cart.addMedia(cd1);
        
        // Test the print method
        cart.print();
        
        // Test the search methods
        System.out.println("\nTesting search methods:");
        
        // Search by ID
        System.out.println("\nSearch by ID:");
        cart.searchCart(1);
        cart.searchCart(10);
        
        // Search by Title
        System.out.println("\nSearch by Title:");
        cart.searchCart("Star Wars");
        cart.searchCart("One Piece");
        
        // Test removing media
        System.out.println("\nRemoving media:");
        cart.removeMedia(dvd2);
        cart.print();
        
        // Test add multiple media at once
        System.out.println("\nAdding multiple media at once:");
        Book book2 = new Book(6, "The Lord of the Rings", "Fantasy", 29.99f);
        Book book3 = new Book(7, "The Silmarillion", "Fantasy", 24.99f);
        cart.addMedia(book2);
        cart.addMedia(book3);
        cart.print();
        
        // Play a DVD
        System.out.println("\nPlaying DVD:");
        dvd1.play();
        
        // Play a CD
        System.out.println("\nPlaying CD:");
        cd1.play();
    }
}