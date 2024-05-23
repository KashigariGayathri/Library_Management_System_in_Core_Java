package myminiproject;

public class Book {

	 private static int uid = 0;
	 
	    private final int id;
	    private final String title;
	    private final String author;

	    public Book(String title, String author) {
	        this.title = title;
	        this.author = author;
	        this.id = ++uid;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    @Override
	    public String toString() {
	        return "Book ID: " + id + ", Title: " + title + ", Author: " + author;
	    }
	}
