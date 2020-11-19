package entities;

public class Book extends LibraryObject {
	
	private String title;
	private String author;
	
	public Book(int id, String title, String author) {
		super(id);
		this.setTitle(title);
		this.setAuthor(author);
	}
	
	@Override
	public String getName() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}