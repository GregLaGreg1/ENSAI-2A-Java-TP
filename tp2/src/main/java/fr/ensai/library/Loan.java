package fr.ensai.library;

import java.util.Date;

public class Loan {
    private Item item;
    private Student borrower;
    private Date startDate;
    private Date returnDate;

    public Loan(Item item, Student borrower, Date startDate, Date returndate) {
        this.item = item;
        this.borrower = borrower;
        this.startDate = startDate;
        this.returnDate = returndate;
    }

    public void setReturnDate(Date returndate) {
        this.returnDate = returndate;
    }

    public String getItemName(){
        return this.item.getTitle();
    }

    @Override
    public String toString() {
        return String.format("Item %s borrowed by %s", this.item.getTitle(), this.borrower.getName());
    }
}