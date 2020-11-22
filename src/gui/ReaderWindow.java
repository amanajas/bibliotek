package gui;

public class ReaderWindow extends Window {

	public ReaderWindow() {
		super("ReaderWindow");
	}

	@Override
	public void show() {
		String response = "";
		do {
			response = "";
			System.out.println("-- Readers --");
			System.out.println("1) List all readers alphabetically by name");
			System.out.println("2) List all readers by ID order");
			System.out.println("3) Search for a specific book by title / author");
			System.out.println("4) Register");
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
		System.out.print("Type the title / author of the book to search: ");
		return read();
	}

	@Override
	public String register() {
		System.out.print("Type the name and the address separated by semicolon(;): ");
		return read();
	}

}
