package entities;

import java.util.ArrayList;
import java.util.List;

import factories.LibraryFactory;

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

	@Override
	public List<String> asList() {
		List<String> content = new ArrayList<>();
		content.add(LibraryFactory.Type.BORROWING.toString());
		content.add(String.valueOf(getId()));
		content.add(String.valueOf(getReader()));
		content.add(String.valueOf(getBook()));
		content.add(String.valueOf(getDate()));
		content.add(String.valueOf(isActive()));
		return content;
	}
	
}
