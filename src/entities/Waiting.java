package entities;

import java.util.ArrayList;
import java.util.List;

import factories.LibraryFactory;

public class Waiting extends LibraryObject {
	
	private Integer reader;
	private Integer book;
	private long timestamp;
	
	public Waiting(Integer id, Integer reader, Integer book, long timestamp) {
		super(id);
		this.reader = reader;
		this.book = book;
		this.timestamp = timestamp;
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

	@Override
	public int compareTo(IEntity o) {
		return this.getId().compareTo(o.getId());
	}

}
