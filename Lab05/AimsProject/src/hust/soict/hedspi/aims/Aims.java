package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    public static void main(String[] args) {

        Store store = new Store();
        Cart cart = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);
        
        DigitalVideoDisc brokenDvd = new DigitalVideoDisc("Broken", "Horror", "No One", 0, 9.99f); // length = 0

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(brokenDvd);

        // 
        DigitalVideoDisc[] dvds = {dvd1, dvd2, dvd3, brokenDvd};
        for (DigitalVideoDisc dvd : dvds) {
            try {
                dvd.play();
            } catch (PlayerException e) {
                System.err.println("Caught a PlayerException while playing: " + dvd.getTitle());
                System.err.println("getMessage(): " + e.getMessage());
                System.err.println("toString(): " + e.toString());
                e.printStackTrace();
                
            }
        }
        
   
        new StoreManagerScreen(store, cart);
    }
}
