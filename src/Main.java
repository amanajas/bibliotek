import java.io.IOException;

import gui.Window;

public class Main {
	
	/**
	 * Prints the main menu
	 * @return the user response based on the options
	 * @throws IOException
	 */
	public static String printMainScreen() throws IOException {
		System.out.println("::: Library :::");
		System.out.println("");
		System.out.println("1) Books");
		System.out.println("3) Readers");
		System.out.println("5) Borrows list");
		System.out.println("7) Waiting list");
		System.out.println("9) Return book");
		System.out.println("");
		System.out.println("Q) Quit");
		System.out.println("");
        System.out.print("Enter an option: ");
        return Window.read();
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
		        case "3":
		        	break;
		        case "5":
		        	break;
		        case "7":
		        	break;
		        case "9":
		        	break;
		        }
			} while (response != null && !response.equalsIgnoreCase("Q"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
