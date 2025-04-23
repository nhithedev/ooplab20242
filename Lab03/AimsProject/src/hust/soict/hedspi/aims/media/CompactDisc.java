package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    
    // Constructors
    public CompactDisc() {
        super();
    }
    
    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost, 0, null); // Initially set length to 0
        this.artist = artist;
    }
    
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost, 0, null); // Initially set length to 0
        this.artist = artist;
    }
    
    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }
    
    public CompactDisc(String title, String category, String artist2, float cost) {
		// TODO Auto-generated constructor stub
	}

	// Getter for artist
    public String getArtist() {
        return artist;
    }
    
    // Method to add a track
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists in the CD!");
        } else {
            tracks.add(track);
            System.out.println("Track added successfully!");
        }
    }
    
    // Method to remove a track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed successfully!");
        } else {
            System.out.println("Track not found in the CD!");
        }
    }
    
    // Method to get total length of CD (sum of all tracks)
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public String toString() {
        return String.format("CD - %s - %s - %s: $%.2f",
                getTitle(), getCategory(), getArtist(), getCost());
    }
    // Implementing the play() method from Playable interface
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD artist: " + this.getArtist());
        System.out.println("CD length: " + this.getLength());
        
        // Loop through each track and call its play() method
        for (Track track : tracks) {
            track.play();
        }
    }
}