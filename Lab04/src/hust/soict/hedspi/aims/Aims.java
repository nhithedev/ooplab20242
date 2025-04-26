package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    public static void main(String[] args) {
        // Tạo store và cart
        Store store = new Store();
        Cart cart = new Cart();
        
        // Thêm một số mẫu các media vào store để test
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);
        
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        // Khởi chạy StoreManagerScreen
        new StoreManagerScreen(store, cart);
    }
}



/* public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize some sample media
        initializeStore();
        
        // Show main menu
        showMenu();
    }

    private static void initializeStore() {
        // Add some sample media to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 15.99f);
        CompactDisc cd2 = new CompactDisc("The Dark Side of the Moon", "Rock", "Pink Floyd", 19.99f);
        
        Book book1 = new Book("Dune", "Science Fiction", 12.99f);
        Book book2 = new Book("The Pragmatic Programmer", "Programming", 29.99f);
        
        store.addMedia(dvd1, dvd2, dvd3, cd1, cd2, book1, book2);
    }

    public static void showMenu() {
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewStore() {
        store.print();
        storeMenu();
    }

    public static void storeMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = store.search(title);
        if (media == null) {
            System.out.println("No media found with that title.");
            return;
        }
        
        System.out.println(media);
        
        if (media instanceof Playable) {
            mediaDetailsMenu(media);
        } else {
            System.out.println("This media cannot be played.");
            System.out.print("Add to cart? (1. Yes / 0. Back): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                cart.addMedia(media);
                System.out.println("Added to cart: " + media.getTitle());
            }
        }
    }

    public static void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Added to cart: " + media.getTitle());
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addMediaToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        
        Media media = store.search(title);
        if (media == null) {
            System.out.println("No media found with that title.");
            return;
        }
        
        cart.addMedia(media);
        System.out.println("Added to cart: " + media.getTitle());
        System.out.println("Total DVDs in cart: " + cart.getNumberOfDVDs());
    }

    private static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        
        Media media = store.search(title);
        if (media == null) {
            System.out.println("No media found with that title.");
            return;
        }
        
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void updateStore() {
        while (true) {
            System.out.println("Update Store:");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove a media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addMediaToStore() {
        System.out.println("Enter media type (1. DVD / 2. CD / 3. Book): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        
        System.out.print("Enter cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        
        Media media = null;
        
        switch (type) {
            case 1: // DVD
                System.out.print("Enter director: ");
                String director = scanner.nextLine();
                System.out.print("Enter length: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                media = new DigitalVideoDisc(title, category, director, length, cost);
                break;
            case 2: // CD
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                media = new CompactDisc(title, category, artist, cost);
                break;
            case 3: // Book
                media = new Book(title, category, cost);
                break;
            default:
                System.out.println("Invalid media type.");
                return;
        }
        
        store.addMedia(media);
        System.out.println("Media added to store: " + media.getTitle());
    }

    private static void removeMediaFromStore() {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        
        Media media = store.search(title);
        if (media == null) {
            System.out.println("No media found with that title.");
            return;
        }
        
        store.removeMedia(media);
        System.out.println("Removed from store: " + media.getTitle());
    }

    private static void seeCurrentCart() {
        cart.print();
        cartMenu();
    }

    public static void cartMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    filterMediaInCart();
                    break;
                case 2:
                    sortMediaInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void filterMediaInCart() {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.print("Choose: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                cart.searchCart(id);
                break;
            case 2:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                cart.searchCart(title);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void sortMediaInCart() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.print("Choose: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                cart.sortByTitle();
                System.out.println("Cart sorted by title.");
                cart.print();
                break;
            case 2:
                cart.sortByCost();
                System.out.println("Cart sorted by cost.");
                cart.print();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        
        Media media = cart.search(title);
        if (media == null) {
            System.out.println("No media found with that title in your cart.");
            return;
        }
        
        cart.removeMedia(media);
        System.out.println("Removed from cart: " + media.getTitle());
    }

    private static void playMediaInCart() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        
        Media media = cart.search(title);
        if (media == null) {
            System.out.println("No media found with that title in your cart.");
            return;
        }
        
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void placeOrder() {
        System.out.println("Order created. Your cart will be emptied.");
        cart = new Cart(); // Reset cart
    }
}
*/