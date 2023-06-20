import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("The Great Gatsby");
        Book book2 = new Book("To Kill a Mockingbird");
        Book book3 = new Book("Pride and Prejudice");
        Reader reader1 = new Reader("John");
        Reader reader2 = new Reader("Jane");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addReader(reader1);
        library.addReader(reader2);

        library.borrowBook(book1, reader1);
        library.borrowBook(book2, reader2);

        System.out.println("Before:");
        for (Book book : library.getBooks()) {
            System.out.println(book.getTitle());
        }

        library.removeBook(book3);

        System.out.println("\nAfter:");
        for (Book book : library.getBooks()) {
            System.out.println(book.getTitle());
        }

        System.out.println();
        library.printBorrowedBooks();
    }
}
