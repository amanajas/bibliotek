package entities;

public class Borrowing extends LibraryObject {
	
	private int reader;
	private int book;
	private long timestamp;
	private boolean active;
	
	public Borrowing(int id, int reader, int book, long timestamp, boolean active) {
		super(id);
		this.reader = reader;
		this.book = book;
		this.timestamp = timestamp;
		this.setActive(active);
	}

	public int getReader() {
		return reader;
	}

	public int getBook() {
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

	@Override
	public String getName() {
		return null;
	}
	
}
