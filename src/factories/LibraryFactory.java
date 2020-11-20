package factories;

import java.util.List;

import entities.Book;
import entities.Borrowing;
import entities.LibraryObject;
import entities.Reader;
import entities.Waiting;

public class LibraryFactory {
	
	/**
	 * 
	 * Type of entities
	 *
	 */
	public static enum Type {
		BOOK,
		BORROWING,
		READER,
		WAITING
	}

	/**
	 * Getting text lines to entities
	 * @param type
	 * @param content
	 * @return
	 */
	public static LibraryObject create(List<String> content) {
		
		try {
			Type type = LibraryFactory.Type.valueOf(content.get(0));
			switch(type.name()) {
			case "BOOK":
				return new Book(
						Integer.valueOf(content.get(1)),
						String.valueOf(content.get(2)),
						String.valueOf(content.get(3))
					);
			case "BORROWING":
				return new Borrowing(
						Integer.valueOf(content.get(1)),
						Integer.valueOf(content.get(2)),
						Integer.valueOf(content.get(3)),
						Long.valueOf(content.get(4)),
						Boolean.valueOf(content.get(5))
					);
			case "READER":
				return new Reader(
						Integer.valueOf(content.get(1)),
						String.valueOf(content.get(2)),
						String.valueOf(content.get(3))
					);
			case "WAITING":
				return new Waiting(
						Integer.valueOf(content.get(1)),
						Integer.valueOf(content.get(2)),
						Integer.valueOf(content.get(3)),
						Long.valueOf(content.get(4))
					);
			}
		} catch (Exception e) {
			System.out.println("Exception on library object creation: " + e.getMessage());
		}
		return null;
	}
	
}
