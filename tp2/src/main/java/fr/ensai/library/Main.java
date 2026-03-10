package fr.ensai.library;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        Magazine mag1 = new Magazine(("godo"), 2010, 100, "dnjeande", "dnejnaé");
        Magazine mag2 = new Magazine(("theate"), 2015, 50, "ddadeaande", "ddjabndjnaé");

        Library lb = new Library(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "lib_test");

        lb.loadBooksFromCSV("books.csv");
        lb.addItem(mag2);
        lb.addItem(mag1);
        lb.displayItems();
    }
}