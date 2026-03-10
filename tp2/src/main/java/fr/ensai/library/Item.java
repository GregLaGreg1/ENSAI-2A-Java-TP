/**
 * Represents a ...
 */
public class Item {
    // -------------------------------------------------------
    // Attributes
    // -------------------------------------------------------
    private String title;
    private int year;
    private int pageCount;

    /**
     * Constructs a new ...
     * 
     * @param parameter1 parameter1_description
     * @pathis.year = year;
        this.pageCount = pageCount;ram parameter2 parameter2_description
     */
    public Item(String title, int year, int pageCount) {
        this.title = title;
        this.year = year;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return this.title;
    }
    
}