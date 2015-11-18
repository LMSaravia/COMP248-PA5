import java.util.Scanner;

/*******************************************************************
Assignment #5
Part 3:

ModifyBooks.java By: Luis Saravia Patron ID # 6800505

For this part, you are required to write a class called ModifyBooks, which is going to utilize the
Book class that you have created in part 1. In that part, you required to write a public class, the
ModifyBooks class. In the main() method of this class the following must be done:
- Create an array of 10 books; all books in the arrays must be initialized with proper values; that
is title, price & ISBN. At least 4 of these books should be created using the copy constructor.
- Change the price of all the objects. You can simply use a for loop and set the prices using any 
formula (for instance, the prices can be set to i*5 + 100), where i is the loop controller variable. 
You can use the Random class if you wish.
- Ask the user to enter a title, and ISBN of a book.
- Read the title and the ISBN, then go through the entire array looking for books with this title 
and the same ISBN, and keep track of all of their locations.
- Now you need to adjust the prices of the books. All books that were found with the same title and
the same ISBN must be adjusted to have the smallest price that any of them has. An indication must be
displayed for every object that is modified.
Here is an example to illustrate the requirements. Assume Arr is the name of the array, and that:
Arr[2] has a book with the following information: “Java 3, ISBN 900700, 112$”, Arr[5] has a book with
the following information: “Java 3, ISBN 230680, 56$”, Arr[7] has a book with the following 
information: “Java 3, ISBN 900700, 83$” , and Arr[9] has a book with the following information: 
“Java 3, ISBN 900700, 92$”.
If the user enters “Java 3” for the title and 900700 for ISBN, then the program must first keep track
of the locations of all books with these information; in this example indices 2, 7 & 9. The program 
must then modify the prices of these objects to the smallest that any of them has; in this case 83$.
Consequently the program will modify Arr[2] & Arr[9]. An indication must be displayed to indicate 
these modifications, similar to the following: Price of book at index 2 has been modified from 112$
to 82$.
As a general rule, displaying of any prices must be formatted using printf.
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

public class ModifyBooks {

	public static void main(String[] args) {
		//Create array of books
		Book[] library = new Book [10];
		//Create an array that will keep the search results
		int[] searchReference = new int [library.length];
		
		//Create 10 books 
		library[0] = new Book("The Bear and the Dragon",123456789, 33.50);
		library[1] = new Book("Executive Orders",234567890, 40);
		library[2] = new Book("Patriot Games",345678901, 15);
		library[3] = new Book("The Sum of All Fears",456789012, 27.70);
		library[4] = new Book("Clear and Present Danger",567890123, 33);
		library[5] = new Book("The Hunt for Red October",678901234, 22.10);
		//******** Use a copy constructor for the rest of the books*********
		library[6] = new Book(library[0]);
		library[7] = new Book(library[1]);
		library[8] = new Book(library[2]);
		library[9] = new Book(library[3]);
		
		//Change the price of all objects
		for (int i = 0; i < library.length; i++){
			library[i].setPrice(library[i].getPrice() * 1.21);
		}
		
		//Create a Scanner object
		Scanner kb = new Scanner(System.in);
		
		//Name variables to keep user entered search values
		String titleToSearch;
		long isbnToSearch;
		
		
		//Initialize variable that will change if a value is found
		boolean found = false;
				
		//Prompt for book values to search for
		System.out.println("Please enter the book title you want to search for and " +
				"press Enter");
		titleToSearch = kb.nextLine();
		
		System.out.println("Please enter the isbn of the book and press Enter");
		isbnToSearch = kb.nextLong();

		
		// Search the entire array and keep track of the locations
		for (int i = 0; i < library.length; i++){
			if (library[i].getIsbn() == isbnToSearch && library[i].getTitle().equalsIgnoreCase(titleToSearch)){
				searchReference[i] = i;
				found = true;
			}
			else
				searchReference[i] = -1;
		}
		
		
		//If no matches were found, the program indicates that to the user.
		if (found == false){
			System.out.println("Sorry, no matches were found.");		
			System.out.println("End of program. Good bye!");
			System.exit(0);
		}

		// Compare prices of each item found and change all 
		for (int i = 0; i < library.length; i++)
			if (searchReference[i] != -1);
				
				
				
		
		
		
		
	}// End of main method

}// End of Modify Books class
