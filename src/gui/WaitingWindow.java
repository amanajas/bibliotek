package gui;

public class WaitingWindow extends Window {

	public WaitingWindow() {
		super("WaitWindow");
	}

	@Override
	public void show() {
		String response = "";
		do {
			response = "";
			System.out.println("-- Waiting list --");
			System.out.println("1) List all readers and books alphabetically");
			System.out.println("2) Search for a reader by ID");
			System.out.println("3) Register");
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
		System.out.print("Type the ID of the reader to search: ");
		return read();
	}

	@Override
	public String register() {
		System.out.print("Type the reader's ID and book's ID separated by semicolon(;): ");
		return read();
	}

}
