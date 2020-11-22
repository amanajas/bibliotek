package gui;

public class BookWindow extends Window {

	public BookWindow(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String show() {
		System.out.println("-- Books --");
		System.out.println("1) List all books alphabetically by title");
		System.out.println("2) List all books alphabetically by author");
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
		System.out.print("Type the title and the author separated by semicolon(;): ");
		return read();
	}
}
