package myminiproject;
import java.util.Scanner;
public class LibraryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        Library library = new Library();
	        boolean exitRequested = false;
	        System.out.println("****************");
	        System.out.println("*        Welcome to the Library System     *");
	        System.out.println("****************");

	        while (!exitRequested) {
	            PrintService.printMainMenu();
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    library.addBook();
	                    break;
	                case 2:
	                    library.removeBook();
	                    break;
	                case 3:
	                    library.issueLibraryCard();
	                    break;
	                case 4:
	                    library.borrowBook();
	                    break;
	                case 5:
	                    library.returnBook();
	                    break;
	                case 6:
	                    library.searchBook();
	                    break;
	                case 7:
	                	library.borrowedBooks();
	                	break;
	                case 8:
	                	library.displayStudentsWithBorrowedBooks();
	                	break;
	                case 9:
	                	library.displayAvailableBooks();
	                	break;
	                case 10:
	                    exitRequested = true;
	                    break;
	                
	                default:
	                    System.out.println("Your input was not recognized. Please try again.");
	                    break;
	            }
	        }
	}

}
