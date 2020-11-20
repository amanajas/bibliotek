package entities;

import java.util.List;

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
	
	public abstract List<String> asList();

}
