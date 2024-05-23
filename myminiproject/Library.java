package myminiproject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Library {
	private final List<Book> books;
    private final List<Student> students;
    private final Scanner sc;

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void addBook() {
        System.out.println("Enter book title:");
        String title = sc.next();
        System.out.println("Enter book author:");
        String author = sc.next();
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    public void removeBook() {
        System.out.println("Enter book ID to remove:");
        int bookID = sc.nextInt();
        books.removeIf(book -> book.getId() == bookID);
        System.out.println("Book removed successfully!");
    }

    public void issueLibraryCard() {
        System.out.println("Enter student's name:");
        String name = sc.next();
        Student student = new Student(name);
        students.add(student);
        System.out.println("Library card issued successfully! Your card ID is: " + student.getId());
    }

    public void borrowBook() {
        System.out.println("Enter your library card ID:");
        int studentID = sc.nextInt();
        Student student = getStudentById(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter book ID to borrow:");
        int bookID = sc.nextInt();
        Book book = getBookById(bookID);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        try {
            student.borrowBook(book);
            books.remove(book);
            System.out.println("Book borrowed successfully!");
        } catch (BookNotAvailableException | BorrowLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook() {
        System.out.println("Enter your library card ID:");
        int studentID = sc.nextInt();
        Student student = getStudentById(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter book ID to return:");
        int bookID = sc.nextInt();
        Book book = null;
        for (Book borrowedBook : student.getBorrowedBooks()) {
            if (borrowedBook.getId() == bookID) {
                book = borrowedBook;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found in student's borrowed books.");
            return;
        }

        student.returnBook(book);
        books.add(book);
        System.out.println("Book returned successfully!");
    }

    /*public void searchBook() {
        System.out.println("Enter book title to search:");
        String title = sc.next();
        books.stream()
            .filter(book -> book.getTitle().equalsIgnoreCase(title))
            .forEach(book -> System.out.println(book.toString()));
    }

    private Book getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    private Student getStudentById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }*/
    public void searchBook() {
        System.out.println("Enter book title to search:");
        sc.nextLine();  // Consume newline left-over from previous input
        String title = sc.nextLine();  // Capture the full line of input
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book.toString());
            }
        }
    }
    private Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    private Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public void borrowedBooks() {
        System.out.println("Enter student ID to list borrowed books:");
        int studentID = sc.nextInt();
        Student student = getStudentById(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        List<Book> borrowedBooks = student.getBorrowedBooks();
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed by this student.");
        } else {
            System.out.println("Borrowed books:");
            for (Book book : borrowedBooks) {
                System.out.println(book.toString());
            }
        }
    }
        public void displayStudentsWithBorrowedBooks() {
            System.out.println("Students who have borrowed books:");
            boolean found = false;
            for (Student student : students) {
                List<Book> borrowedBooks = student.getBorrowedBooks();
                if (!borrowedBooks.isEmpty()) {
                    System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName());
                    for (Book book : borrowedBooks) {
                        System.out.println("\tBorrowed Book: " + book.toString());
                    }
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No students have borrowed books.");
            }
    }
        public void displayAvailableBooks() {
            System.out.println("Available books in the library:");
            if (books.isEmpty()) {
                System.out.println("No books are currently available.");
            } else {
                for (Book book : books) {
                    System.out.println(book.toString());
                }
            }
        }
}

	
