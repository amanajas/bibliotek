package gui;

public class BorrowWindow extends Window {

	public BorrowWindow(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String show() {
		System.out.println("-- Borrow list --");
		System.out.println("1) List all readers and borrows alphabetically");
		System.out.println("2) Search for a reader by ID");
		System.out.println("3) Search for a book by ID");
		System.out.println("4) Register");
		System.out.println("");
		System.out.println("0) Back");
		return read();
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

}
