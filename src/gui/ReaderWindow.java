package gui;

public class ReaderWindow extends Window {

	public ReaderWindow(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String show() {
		System.out.println("-- Readers --");
		System.out.println("1) List all readers alphabetically by name");
		System.out.println("2) List all readers by ID order");
		System.out.println("3) Search for a specific book by title / author");
		System.out.println("4) Register");
		System.out.println("");
		System.out.println("0) Back");
		return read();
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
