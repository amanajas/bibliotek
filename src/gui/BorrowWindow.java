package gui;

import java.util.Date;
import java.util.List;

import controllers.BookController;
import controllers.BorrowControlller;
import controllers.ReaderController;
import entities.Book;
import entities.Borrowing;
import entities.IEntity;
import entities.Reader;
import utils.NumberUtils;

public class BorrowWindow extends Window {
	
	private BorrowControlller borrowController;
	private BookController bookController;
	private ReaderController readerController;

	public BorrowWindow() {
		super("BorrowWindow");
		this.borrowController = new BorrowControlller();
		this.bookController = new BookController();
		this.readerController = new ReaderController();
		borrowController.load();
		bookController.load();
		readerController.load();
	}

	@Override
	public void show() {
		String response = "";
		List<IEntity> list;
		do {
			response = "";
			System.out.println("-- Borrow list --");
			System.out.println("1) List all readers and borrows");
			System.out.println("2) Search borrow by reader's ID");
			System.out.println("3) Search borrow by book's ID");
			System.out.println("4) Register");
			System.out.println("8) Return book");
			System.out.println("");
			System.out.println("0) Back");
			System.out.println("");
			System.out.print("-> ");
			response = read();
			switch(response.toUpperCase()) {
			case "1":
				System.out.println("-------------------");
				list = borrowController.list();
				for (IEntity ent : list) {
					Borrowing borrow = (Borrowing) ent;
					Book book = bookController.getBook(borrow.getBook());
					Reader reader = readerController.searchById(borrow.getReader());
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
					list = borrowController.searchBorrowedBookReaderByID(Integer.valueOf(response));
					for (IEntity ent : list) {
						Borrowing borrow = (Borrowing) ent;
						Book book = bookController.getBook(borrow.getBook());
						Reader reader = readerController.searchById(borrow.getReader());
						System.out.println("Date: " + NumberUtils.getDate(borrow.getDate()).toString());
						System.out.println("Reader: " + "(" + reader.getId() + ")" + reader.getName());
						System.out.println("Book: (" + borrow.getBook() + ") " + book.getName());
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
				if (NumberUtils.isNumeric(response)) {
					list = borrowController.searchBorrowedBookByID(Integer.valueOf(response));
					for (IEntity ent : list) {
						Borrowing borrow = (Borrowing) ent;
						Book book = bookController.getBook(borrow.getBook());
						System.out.println("Date: " + NumberUtils.getDate(borrow.getDate()).toString());
						System.out.println("Book: (" + borrow.getBook() + ") " + book.getName());
						System.out.println();
					}
					System.out.println("-------------------");
				} else {
					System.out.println("Error: Please enter a correct ID.");
				}
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
						if (NumberUtils.isNumeric(words[0]) && NumberUtils.isNumeric(words[1])) {
							Integer bookId = Integer.valueOf(words[0]);
							Integer readerId = Integer.valueOf(words[1]);
							if (bookController.exists(bookId) && readerController.exists(readerId)) {
								borrowController.add(
									new Borrowing(
										borrowController.getLastId(),
										bookId,
										readerId,
										new Date().getTime(),
										true
									)
								);
								System.out.println("Borrow added for reader: " + words[0]);
							} else {
								System.out.println("Error: Reader ID or Book ID is not valid.");
							}
						} else {
							System.out.println("Error: Please enter numbers for the IDs.");
						}
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
