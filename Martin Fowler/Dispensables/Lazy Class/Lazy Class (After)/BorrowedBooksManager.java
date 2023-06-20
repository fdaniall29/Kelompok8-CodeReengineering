import java.util.List;
import java.util.ArrayList;

public class BorrowedBooksManager {
    private Library library;
    private List<Book> books;
    private List<Reader> readers;

    public BorrowedBooksManager(Library library) {
        this.library = library;
        this.books = library.getBooks();
        this.readers = library.getReaders();
    }

    public void borrowBook(Book book, Reader reader) {
        if (books.contains(book) && readers.contains(reader)) {
            book.setBorrower(reader);
            book.setBorrowed(true);
        }
    }
    
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
            System.out.println("- " + book.getTitle() + " (borrowed by " + book.getBorrower().getName() + ")");
        }
    }
}