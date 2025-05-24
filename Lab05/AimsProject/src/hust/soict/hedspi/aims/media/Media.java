package hust.soict.hedspi.aims.media;
import java.util.Comparator;


public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    
    // Constructors remain the same
    public Media() {
        // Default constructor
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters and Setters remain the same
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    // Search methods remain the same
    public boolean isMatch(int id) {
        return this.id == id;
    }
    
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;

        // Null check for title
        if (this.title == null || other.title == null) return false;
        return this.title.equalsIgnoreCase(other.title) && this.cost == other.cost;
    }

    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Cannot compare to null Media");
        if (this.title == null && other.title == null) return 0;
        if (this.title == null) return -1;
        if (other.title == null) return 1;

        int titleCmp = this.title.compareToIgnoreCase(other.title);
        if (titleCmp != 0) {
            return titleCmp;
        }
        return Float.compare(this.cost, other.cost);
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    @Override
    public String toString() {
        return "ID: " + id + " - " + title + " - " + category + ": " + cost + "$";
    }
}