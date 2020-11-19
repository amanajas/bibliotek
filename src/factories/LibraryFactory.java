package factories;

import entities.Book;
import entities.Borrowing;
import entities.LibraryObject;
import entities.Reader;
import entities.Waiting;

public class LibraryFactory {
	
	enum Type {
		BOOK,
		BORROWING,
		READER,
		WAITING
	}

	public LibraryObject create(Type type, String[] content) {
		
		try {
			switch(type.name()) {
			case "BOOK":
				return new Book(
						Integer.valueOf(content[0]),
						content[1],
						content[2]
					);
			case "BORROWING":
				return new Borrowing(
						Integer.valueOf(content[0]),
						Integer.valueOf(content[1]),
						Integer.valueOf(content[2]),
						Long.valueOf(content[3]),
						Boolean.valueOf(content[4])
					);
			case "READER":
				return new Reader(
						Integer.valueOf(content[0]),
						content[1],
						content[2]
					);
			case "WAITING":
				return new Waiting(
						Integer.valueOf(content[0]),
						Integer.valueOf(content[1]),
						Integer.valueOf(content[2]),
						Long.valueOf(content[3])
					);
			}
		} catch (Exception e) {
			System.out.println("Exception on library object creation: " + e.getMessage());
		}
		return null;
	}
	
}
