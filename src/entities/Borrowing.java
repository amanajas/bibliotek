package entities;

import java.util.ArrayList;
import java.util.List;

import factories.LibraryFactory;

public class Borrowing extends LibraryObject {
	
	private Integer reader;
	private Integer book;
	private long timestamp;
	private boolean active;
	
	public Borrowing(Integer id, Integer reader, Integer book, long timestamp, boolean active) {
		super(id);
		this.reader = reader;
		this.book = book;
		this.timestamp = timestamp;
		this.setActive(active);
	}

	public Integer getReader() {
		return reader;
	}

	public Integer getBook() {
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

	@Override
	public int compareTo(IEntity o) {
		return this.getId().compareTo(o.getId());
	}
	
}
