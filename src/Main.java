import java.io.IOException;

import gui.BookWindow;
import gui.BorrowWindow;
import gui.ReaderWindow;
import gui.WaitingWindow;
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
		System.out.println("");
		System.out.println("Q) Quit");
		System.out.println("");
		System.out.print("-> ");
		return Window.read();
	}

	/**
	 * Main method used to start the application
	 * @param args
	 */
	public static void main(String[] args) {
		
		BookWindow bookWindow = new BookWindow();
		BorrowWindow borrowWindow = new BorrowWindow();
		WaitingWindow waitWindow = new WaitingWindow();
		ReaderWindow readerWindow = new ReaderWindow();
		
		try {
			String mainResponse = null;
			do {
		        mainResponse = printMainScreen();
		        switch(mainResponse.toUpperCase()) {
		        case "1":
		        	bookWindow.show();
		        	break;
		        case "3":
		        	readerWindow.show();
		        	break;
		        case "5":
		        	borrowWindow.show();
		        	break;
		        case "7":
		        	waitWindow.show();
		        	break;
		        }
			} while (mainResponse != null && !mainResponse.equalsIgnoreCase("Q"));
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
