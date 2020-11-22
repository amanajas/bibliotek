package gui;

public class BorrowWindow extends Window {

	public BorrowWindow() {
		super("BorrowWindow");
	}

	@Override
	public void show() {
		String response = "";
		do {
			response = "";
			System.out.println("-- Borrow list --");
			System.out.println("1) List all readers and borrows alphabetically");
			System.out.println("2) Search for a reader by ID");
			System.out.println("3) Search for a book by ID");
			System.out.println("4) Register");
			System.out.println("8) Return book");
			System.out.println("");
			System.out.println("0) Back");
			System.out.println("");
			System.out.print("-> ");
			response = read();
			switch(response.toUpperCase()) {
			case "1":
				waitForKey();
				break;
			case "2":
				waitForKey();
				break;
			case "3":
				waitForKey();
				break;
			case "4":
				waitForKey();
				break;
			
			}
		} while (!response.equalsIgnoreCase("0"));
	}

	@Override
	public String search() {
		System.out.print("Type the ID to search: ");
		return read();
	}

	@Override
	public String register() {
		System.out.print("Type the reader's ID and book's ID separated by semicolon(;): ");
		return read();
	}
	
	public String returnBook() {
		System.out.print("Type the book's ID: ");
		return read();
	} 

}
