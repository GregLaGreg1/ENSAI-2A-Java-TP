public class Loan {
    private Item item;
    private Student borrower;
    private Date startDate;
    private Date returnDate;

    public Loan(Item item, Student borrower, Date startDate, Date returndate){
        this.item = item;
        this.borrower = borrower;
        this.startDate = startDate;
        this.returnDate = returndate;
    }
}