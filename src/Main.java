import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	
	/**
	 * Read the user input as string
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String read() throws IOException {
		String word = null;
		try {
			word = new Scanner(System.in).nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return word;
	}
	
	/**
	 * Prints the main menu
	 * @return the user response based on the options
	 * @throws IOException
	 */
	public static String printMainScreen() throws IOException {
		System.out.println("::: Library :::");
		System.out.println("");
		System.out.println("1) Search for a specific book by title and/or author name");
		System.out.println("2) List all books by title");
		System.out.println("3) Search for a specific reader by name and/or ID");
		System.out.println("4) List all readers by ID order");
		System.out.println("5) Register that a reader has borrowed a book");
		System.out.println("6) Add to waiting list");
		System.out.println("7) Return book");
		System.out.println("8) Books that were borrowed by user");
		System.out.println("");
		System.out.println("Q) Quit");
		System.out.println("");
        System.out.print("Enter an option: ");
        return read();
	}

	/**
	 * Main method used to start the application
	 * @param args
	 */
	public static void main(String[] args) {
		
		String response = null;
		try {
			do {
		        response = printMainScreen();
		        
		        switch(response.toUpperCase()) {
		        case "1":
		        	break;
		        case "2":
		        	break;
		        case "3":
		        	break;
		        case "4":
		        	break;
		        case "5":
		        	break;
		        case "6":
		        	break;
		        case "7":
		        	break;
		        case "8":
		        	break;
		        }
			} while (response != null && !response.equalsIgnoreCase("Q"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
