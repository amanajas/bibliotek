package entities;

public abstract class LibraryObject implements IEntity {
	
	private int id;
	
	public LibraryObject(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	public abstract String getName();

}
