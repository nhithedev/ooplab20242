package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructors
    public Disc() {
        super();
    }

    public Disc(int id, String title, String category, float cost, 
               int length, String director) {
        super(id, title, category, cost);  // Matches Media's 4-arg constructor
        this.length = length;
        this.director = director;
    }

    public Disc(String title, String category, float cost, 
               int length, String director) {
        super(title, category, cost);  // Matches Media's 3-arg constructor
        this.length = length;
        this.director = director;
    }

    public Disc(String title) {
        super(title);  // Matches Media's 1-arg constructor
    }

    // Getters
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}