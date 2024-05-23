package myminiproject;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private static int uid = 0;
    private final int id;
    private final String name;
    private final List<Book> borrowedBooks;

    public Student(String name) {
        this.name = name;
        this.id = ++uid;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) throws BookNotAvailableException, BorrowLimitExceededException {
        if (borrowedBooks.size() >= 4) {
            throw new BorrowLimitExceededException("Out of limit, you have already borrowed 4 books.");
        }
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}

