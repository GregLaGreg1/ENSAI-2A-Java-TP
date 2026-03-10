import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a ...
 */
public class Library {
    // -------------------------------------------------------
    // Attributes
    // -------------------------------------------------------
    private List<Item> items;
    private List<Loan> activeLoans;
    private List<Loan> completedLoans;
    private String name;

    /**
     * Constructs a new ...
     * 
     * @param parameter1 parameter1_description
     * @param parameter2 parameter2_description
     */
    public Library(List<Item> items, List<Loan> activeLoans, List<Loan> completedLoans, String name) {
        this.items = items;
        this.activeLoans = activeLoans;
        this.completedLoans = completedLoans;
        this.name = name;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void displayItems() {
        if (this.items.isEmpty()) {
            System.out.println("Librairie vide");
            return;
        }
        for (int i = 0; i < this.items.size(); i++) {
            Item item = this.items.get(i);
            if (item instanceof Book) {
                System.out.println(item.toString());
            } else if (item instanceof Magazine) {
                System.out.println(item.toString());
            }
        }
    }

    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName, 0, "pas renseigné");
                        authors.put(authorName, author);
                        // System.out.println(String.format("Create %s", author));
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addItem(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}