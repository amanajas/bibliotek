package entities;

import java.util.ArrayList;
import java.util.List;

import factories.LibraryFactory;

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

	@Override
	public List<String> asList() {
		List<String> content = new ArrayList<>();
		content.add(LibraryFactory.Type.WAITING.toString());
		content.add(String.valueOf(getId()));
		content.add(String.valueOf(getReader()));
		content.add(String.valueOf(getBook()));
		content.add(String.valueOf(getDate()));
		return content;
	}

}
