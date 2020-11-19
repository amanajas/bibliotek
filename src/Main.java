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
		System.out.println("::: Binary Calculator :::");
		System.out.println("");
		System.out.println("A) Binary to decimal");
		System.out.println("B) Decimal to binary");
		System.out.println("C) Addition");
		System.out.println("D) Subtraction");
		System.out.println("E) Multiplication");
		System.out.println("F) Division");
		System.out.println("G) Quit");
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
		        case "A":
		        	break;
		        case "B":
		        	break;
		        case "C":
		        	break;
		        case "D":
		        	break;
		        case "E":
		        	break;
		        case "F":
		        	break;
		        }
			} while (response != null && !response.equalsIgnoreCase("G"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
