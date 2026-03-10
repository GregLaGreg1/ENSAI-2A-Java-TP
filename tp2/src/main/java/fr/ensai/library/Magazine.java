public class Magazine extends Item {
    private String issn;
    private String issueNumber;

    // Constructor
    public Magazine(String title, int year, int pageCount, String issn, String issueNumber) {
        super(title, year, pageCount);
        this.issn = issn;
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return String.format("Magazine %s written by %s", this.title, this.author);
    }

}