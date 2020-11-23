package gui;

import java.util.List;

import controllers.BookController;
import entities.Book;
import entities.IEntity;

public class BookWindow extends Window {

	private BookController controller;
	
	public BookWindow() {
		super("BookWindow");
		controller = new BookController();
		controller.load();
	}

	@Override
	public void show() {
		String response = "";
		List<IEntity> list;
		do {
			response = "";
			System.out.println("-- Books --");
			System.out.println("1) List all books alphabetically by title");
			System.out.println("2) List all books alphabetically by author");
			System.out.println("3) Search for a specific book by title / author");
			System.out.println("4) Register");
			System.out.println("");
			System.out.println("0) Back");
			System.out.println("");
			System.out.print("-> ");
			response = read();
			switch(response.toUpperCase()) {
			case "1":
				System.out.println("-------------------");
				list = controller.listAlphabetically();
				for (IEntity ent : list) {
					Book book = (Book) ent;
					System.out.println("ID: " + book.getId() + ", Title: " + book.getName());
					System.out.println("Author: " + book.getAuthor());
					System.out.println();
				}
				System.out.println("-------------------");
				waitForKey();
				break;
			case "2":
				System.out.println("-------------------");
				list = controller.listAlphabetically();
				for (IEntity ent : list) {
					Book book = (Book) ent;
					System.out.println("ID: " + book.getId() + ", Title: " + book.getName());
					System.out.println("Author: " + book.getAuthor());
					System.out.println();
				}
				System.out.println("-------------------");
				waitForKey();
				break;
			case "3":
				String searchQuery = this.search();
				list = controller.searchByTitle(searchQuery);
				list.addAll(controller.searchByAuthor(searchQuery));
				System.out.println("-------------------");
				for (IEntity ent : list) {
					Book book = (Book) ent;
					System.out.println("ID: " + book.getId() + ", Title: " + book.getName());
					System.out.println("Author: " + book.getAuthor());
					System.out.println();
				}
				System.out.println("-------------------");
				waitForKey();
				break;
			case "4":
				System.out.println("-------------------");
				String reg = this.register();
				if (reg.length() > 0 && reg.contains(";")) {
					String[] words = reg.split(";");
					if (words.length < 2) {
						System.out.println("Error: It seems that the information given is imcomplete.");
						break;
					} else {
						controller.add(new Book(controller.getLastId(), words[0], words[1]));
						System.out.println("Book added: " + words[0]);
					}
				} else {
					System.out.println("Error: It was not possible to register the book.");
				}
				System.out.println("-------------------");
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
		System.out.print("Type the title and the author separated by semicolon(;): ");
		return read();
	}
}