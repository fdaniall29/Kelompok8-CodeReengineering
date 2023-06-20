public class Book {
    private String title;
    private boolean borrowed;
    private Reader borrowedBy;

    public Book(String title) {
        this.title = title;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Reader getBorrower() {
        return borrowedBy;
    }

    public void setBorrower(Reader reader) {
        this.borrowedBy = reader;
    }
}