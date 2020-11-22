package gui;

public class WaitingWindow extends Window {

	public WaitingWindow(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String show() {
		System.out.println("-- Waiting list --");
		System.out.println("1) List all readers and books alphabetically");
		System.out.println("2) Search for a reader by ID");
		System.out.println("3) Register");
		System.out.println("");
		System.out.println("0) Back");
		return read();
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
