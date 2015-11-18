
/*******************************************************************
Assignment #5

BookSearch.java By: Luis Saravia Patron ID # 6800505

Part 1: Please find it below Part2
Part 2:
In this part, you are required to write a public class called BookSearch, which will utilize the
Book class created in part 0. In the main method of this class the following must be done:
- Create an array of 10 books. All these books must be initialized with proper values; that is: 
title, price & ISBN. You must use the copy constructor to create some of these objects.
- Ask the user to enter three pieces of information: a book title, a book price, and either Yes or
No for a search combination (see details below).
- Read the entered information.
- Depending on whether the user has entered Yes or No for matching combinations, your program will
search the array for matching books based on the following rules:
+ If the user enters Yes (case insensitive) for matching combinations, then your program will search
 the array and displays all books that have both the title and the price entered by the user.
+ If the user enters No (or anything different than Yes) for matching combinations, then your 
program will search the array and display all books that have either the title entered by the user 
or the price entered by the user.
If no matches were found, the program must indicate that to the user.
As a general rule, displaying of any prices must be formatted using printf.

Guideline: For part 1 and 2, you will need to create one .java file, called BookSearch.java, which 
includes the Book class as well as the BookSearch class (this is the public class), which will have 
the main() function.
********************************************************************/

import java.util.Scanner;

public class BookSearch {

	public static void main(String[] args) {

		//Create array of books
		Book[] library = new Book [10];
		
		//Create 10 books 
		library[0] = new Book("The Bear and the Dragon",123456789, 33.50);
		library[1] = new Book("Executive Orders",234567890, 40);
		library[2] = new Book("Patriot Games",345678901, 15);
		library[3] = new Book("The Sum of All Fears",456789012, 27.70);
		library[4] = new Book("Clear and Present Danger",567890123, 33);
		library[5] = new Book("The Hunt for Red October",678901234, 22.10);
		library[6] = new Book("Red Rabbit",789012345, 34);
		//******** Use a copy constructor for the rest of the books*********
		library[7] = new Book(library[4]);
		library[8] = new Book(library[5]);
		library[9] = new Book(library[6]);
		
		//Create a Scanner object
		Scanner kb = new Scanner(System.in);
		
		//Name variables to keep user entered search values
		String titleToSearch, matchingCombinationSearch;
		double priceToSearch;
		
		//Initialize variable that will change if a value was found
		boolean found = false;
				
		//Prompt for book values to search for
		System.out.println("Please enter the book title you want to search for and " +
				"press Enter");
		titleToSearch = kb.nextLine();
		
		System.out.println("Please enter the price of the book and press Enter");
		priceToSearch = kb.nextDouble();
		
		System.out.println("Please enter Yes to search for matching combinations or No\n" +
				"to search either the title or the price:");
		matchingCombinationSearch = kb.next();
		
		//Display entered values
		System.out.println("You have entered the following values:");
		System.out.println(titleToSearch);
		System.out.println(matchingCombinationSearch);
		System.out.println(priceToSearch);
		
		// Search in the array
		
		//If the user enters Yes (case insensitive) for matching combinations, display all 
		//books that have both the title and the price
		if ("yes".equalsIgnoreCase(matchingCombinationSearch)){
			
			for (int i = 0; i < library.length; i++){
			
				if (library[i].getPrice() == priceToSearch && library[i].getTitle().equalsIgnoreCase(titleToSearch)){
				
					library[i].showInfo();
					found = true;
				}// end of if statement
				
			}//end of for statement
			
		}// end of if statement
		
		
		//If the user enters No (or anything different than Yes) for matching combinations display
		//all books that have either the title or the price.
		else{
			for (int i = 0; i < library.length; i++){
				
				if (library[i].getPrice() == priceToSearch || library[i].getTitle().equalsIgnoreCase(titleToSearch)){
					
					library[i].showInfo();
					found = true;
				}// end of if statement
				
			}//end of for statement
			
		}// end of else statement
			
		//If no matches were found, the program must indicate that to the user.
		if (found == false)
			System.out.println("Sorry, no matches were found.");		
		
		System.out.println("End of program. Good bye!");
		System.exit(0);
		
	}// End of main method

}// End of BookSearch class


/*******************************************************************
Part 1:
A Book class is created according to the following specifications:
- Upon the creation of a book object, the object is immediately initialized with valid values;
  that is title, ISBN and price. (assuming that ISBN numbers do NOT start with 0 (that is they can
  start only with digits from 1 to 9).
- Class has a copy constructor, so new book objects can be created as exact copies of existing ones
- The design allows enough flexibility so that the value of any of these attributes can be
  modified later on. 
- The design allows the user of the class to obtain the value of any of the attributes individually.
  It also allows the user to view all book information at once by passing book objects to 
  the print/println() methods;
- The design allows for one book to be compared to another book for equality. Two book objects are
  considered equal if they have the same ISBN # and the same price.
********************************************************************/
class Book {
	
	
	//Attributes
	private String title;
	private long isbn;
	private double price;
	
	
	//Constructor with given values 
	public Book(String title, long isbn, double price){
		System.out.println("Creating a book with given values ......\n"); 
		this.title = title;
		this.isbn = isbn; 
		this.price = price;	 
	}
	
	
	//Constructor with default values 
	public Book(){
		System.out.println("Creating a book with default values ......\n"); 
		title = "New book";
		isbn = 100000000; 
		price = 0; 
	}
	

	//Copy constructor
	public Book(Book bookToCopy){
		System.out.println("Creating a copy of a book ......\n");
		title = bookToCopy.title;
		isbn = bookToCopy.isbn;
		price = bookToCopy.price;
	}

	
	//Accessors will allow the user of the class to obtain the value of any of the attributes individually.
	public String getTitle(){
		return title;
	}
	
	public long getIsbn(){
		return isbn;
	}
	
	public double getPrice(){
		return price;
	}

	
	//Mutators
	public void setTitle(String title){
		if (title.length()>=1 && title.length()<=100) //Object will control the allowed values
			this.title = title;
		else
			System.out.println("Invalid entry. Title length has to be from 1 to 100. No change will be made.");
	}
	
	public void setIsbn(long isbn){
		if (isbn >= 100000000 && isbn < 1000000000) //Object will control the allowed values
			this.isbn = isbn;
		else
			System.out.println("Invalid entry. ISBN # go from 100000000 to 999999999. No change will be made.");
	}
	
	public void setPrice(double price){
		if (price >= 0 && price < 100000) //Object will control the allowed values
			this.price = price;
		else 
			System.out.println("Invalid entry. Price has to be between 0 and less than 100000. No change " +
					"will be made.");
	}
	
	
	//Other methods
	
	//Compare books (Considered equal if they have the same ISBN # and the same price.)
	public boolean equals(Book BookToCompare){
	return (isbn == BookToCompare.isbn && price == BookToCompare.price);
	}
		
	//Show book information 
	public void showInfo(){
		System.out.printf("The book title is: \"" + title + "\", the ISBN # is " + isbn
				+ " and the price is $%.2f%n", price);
	}
	
	//toString 
	public String toString(){
		return ("\"" + title + "\" #" + isbn + " $" + price);
	}
	
	
}// End of Book class
