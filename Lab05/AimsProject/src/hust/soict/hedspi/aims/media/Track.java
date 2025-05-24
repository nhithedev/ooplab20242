package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;
    
    // Constructor remains the same
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    // Getters remain the same
    public String getTitle() {
        return title;
    }
    
    public int getLength() {
        return length;
    }
    
    // play() method remains the same
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
    
    // Updated equals() method to compare by title and length
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Track)) return false;
        
        Track other = (Track) obj;
        return this.title.equalsIgnoreCase(other.title) && this.length == other.length;
    }
}