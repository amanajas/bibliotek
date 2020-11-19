package entities;

public class Waiting extends LibraryObject {
	
	private int reader;
	private int book;
	private long timestamp;
	
	public Waiting(int id, int reader, int book, long timestamp) {
		super(id);
		this.reader = reader;
		this.book = book;
		this.timestamp = timestamp;
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

	@Override
	public String getName() {
		return null;
	}

}
