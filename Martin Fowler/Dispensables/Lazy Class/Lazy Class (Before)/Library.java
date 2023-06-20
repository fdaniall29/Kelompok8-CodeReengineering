import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<Book>();
    private List<Reader> readers = new ArrayList<Reader>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void removeReader(Reader reader) {
        readers.remove(reader);
    }

    public void borrowBook(Book book, Reader reader) {
        if (books.contains(book) && readers.contains(reader)) {
            book.setBorrower(reader);
            book.setBorrowed(true);
        }
    }

    public void returnBook(Book book) {
        book.setBorrower(null);
    }

    //smell code
    public List<Book> getBorrowedBooks() {
        List<Book> borrowedBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.isBorrowed()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

    public void printBorrowedBooks() {
        System.out.println("Borrowed books:");
        List<Book> borrowedBooks = getBorrowedBooks();
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle() + " (borrowed by " +         book.getBorrower().getName() + ")");
        }
    }

}

