package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Store no longer needs a maximum size parameter in constructor
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        
        // Add DVDs using the new addMedia() method
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // Print store contents
        System.out.println("\nStore contents after adding DVDs:");
        store.print();

        // Remove DVD using the new removeMedia() method
        store.removeMedia(dvd2);

        // Print store contents after removal
        System.out.println("\nStore contents after removing DVD:");
        store.print();

        // Test adding multiple media at once
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 20.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 15.99f);
        store.addMedia(dvd4, dvd5);

        // Print final store contents
        System.out.println("\nFinal store contents:");
        store.print();

        // Test search functionality
        System.out.println("\nSearching for 'Animation':");
        store.search("Animation");

        System.out.println("\nSearching for ID 1:");
        store.search("1");
    }
}