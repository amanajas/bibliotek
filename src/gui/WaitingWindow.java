package gui;

import java.util.Date;
import java.util.List;

import controllers.BookController;
import controllers.ReaderController;
import controllers.WaitController;
import entities.Book;
import entities.Borrowing;
import entities.IEntity;
import entities.Reader;
import entities.Waiting;
import utils.NumberUtils;

public class WaitingWindow extends Window {
	
	private WaitController waitController;
	private BookController bookController;
	private ReaderController readerController;

	public WaitingWindow() {
		super("WaitWindow");
		this.waitController = new WaitController();
		this.bookController = new BookController();
		this.readerController = new ReaderController();
		waitController.load();
		bookController.load();
		readerController.load();
	}

	@Override
	public void show() {
		String response = "";
		List<IEntity> list;
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
				System.out.println("-------------------");
				list = waitController.list();
				for (IEntity ent : list) {
					Waiting waiting = (Waiting) ent;
					Book book = bookController.getBook(waiting.getBook());
					Reader reader = readerController.searchById(waiting.getReader());
					System.out.println("Book: " + book.getId() + ", Title: " + book.getName());
					System.out.println("Reader: " + "(" + reader.getId() + ")" + reader.getName());
					System.out.println();
				}
				System.out.println("-------------------");
				waitForKey();
				break;
			case "2":
				System.out.println("-------------------");
				if (NumberUtils.isNumeric(response)) {
					list = waitController.searchNextReaderByBookID(Integer.valueOf(response));
					for (IEntity ent : list) {
						Waiting waiting = (Waiting) ent;
						Book book = bookController.getBook(waiting.getBook());
						Reader reader = readerController.searchById(waiting.getReader());
						System.out.println("Date: " + waiting.getDate());
						System.out.println("Reader: " + "(" + reader.getId() + ")" + reader.getName());
						System.out.println("Book: (" + waiting.getBook() + ") " + book.getName());
						System.out.println();
					}
					System.out.println("-------------------");
				} else {
					System.out.println("Error: Please enter a correct ID.");
				}
				waitForKey();
				break;
			case "3":
				System.out.println("-------------------");
				String reg = this.register();
				if (reg.length() > 0 && reg.contains(";")) {
					String[] words = reg.split(";");
					if (words.length < 2) {
						System.out.println("Error: It seems that the information given is imcomplete.");
						break;
					} else {
						if (NumberUtils.isNumeric(words[0]) && NumberUtils.isNumeric(words[1])) {
							Integer bookId = Integer.valueOf(words[0]);
							Integer readerId = Integer.valueOf(words[1]);
							if (bookController.exists(bookId) && readerController.exists(readerId)) {
								waitController.add(
									new Borrowing(
											waitController.getLastId(),
										bookId,
										readerId,
										new Date().getTime(),
										true
									)
								);
								System.out.println("Waiting for reader: " + words[0]);
							} else {
								System.out.println("Error: Reader ID or Book ID is not valid.");
							}
						} else {
							System.out.println("Error: Please enter numbers for the IDs.");
						}
					}
				} else {
					System.out.println("Error: It was not possible to register the waiting.");
				}
				System.out.println("-------------------");
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
