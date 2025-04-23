package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added to cart: " + media.getTitle());
        } else {
            System.out.println("Cart is full. Cannot add more items.");
        }
    }
    
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed from cart: " + media.getTitle());
        } else {
            System.out.println("Item not found in cart.");
        }
    }
    
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    
    public void print() {
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items:");
        
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        
        System.out.println("Total cost: $" + totalCost());
        System.out.println("*************************************************");
    }
    
    public Media search(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
    public void searchCart(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }
    
    public void searchCart(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found: " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title containing: " + title);
        }
    }
    
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    public int getNumberOfDVDs() {
        int count = 0;
        for (Media media : itemsOrdered) {
            if (media instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }
}