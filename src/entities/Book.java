package entities;

public class Book implements IEntity {
	
	private int id;
	private String title;
	private String author;
	
	public Book(int id, String title, String author) {
		this.id = id;
		this.setTitle(title);
		this.setAuthor(author);
	}

	@Override
	public int getId() {
		return id;
	}

	public String getTitle() {
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