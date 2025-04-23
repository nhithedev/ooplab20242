package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    private static int nbDigitalVideoDiscs = 0;

    // Constructor chaining
    public DigitalVideoDisc(String title) {
        this(title, "Unknown", null, 0, 0.0f);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, null, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, director, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(nbDigitalVideoDiscs + 1, title, category, cost, length, director);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(int i, String string, String string2, float f, int j, String string3) {
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(int i, String string, String string2, float f) {
		// TODO Auto-generated constructor stub
	}

	// Play method
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        return String.format("DVD - ID: %d | Title: %s | Category: %s | Director: %s | Length: %d | Cost: $%.2f",
                getId(), getTitle(), getCategory(), getDirector(), getLength(), getCost());
    }

    // Search methods
    public boolean isMatch(int id) {
        return getId() == id;
    }

    public boolean isMatch(String title) {
        if (title == null || getTitle() == null) return false;
        String[] keywords = title.toLowerCase().split(" ");
        String dvdTitle = getTitle().toLowerCase();
        
        for (String keyword : keywords) {
            if (!dvdTitle.contains(keyword)) {
                return false;
            }
        }
        return true;
    }

    // Static method to get count
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    
    
}