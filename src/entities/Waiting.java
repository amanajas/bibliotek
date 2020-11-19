package entities;

public class Waiting implements IEntity {
	
	private int id;
	private Reader reader;
	private Book book;
	private long timestamp;
	
	public Waiting(int id, Reader reader, Book book, long timestamp) {
		this.id = id;
		this.reader = reader;
		this.book = book;
		this.timestamp = timestamp;
	}

	@Override
	public int getId() {
		return id;
	}

	public Reader getReader() {
		return reader;
	}

	public Book getBook() {
		return book;
	}

	public long getDate() {
		return timestamp;
	}

}
