package entities;

public class Borrowing implements IEntity {
	
	private int id;
	private Reader reader;
	private Book book;
	private long timestamp;
	private boolean active;
	
	public Borrowing(int id, Reader reader, Book book, long timestamp, boolean active) {
		this.id = id;
		this.reader = reader;
		this.book = book;
		this.timestamp = timestamp;
		this.setActive(active);
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
