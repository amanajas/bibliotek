package entities;

import java.util.List;

public abstract class LibraryObject implements IEntity {
	
	private Integer id;
	
	public LibraryObject(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	public abstract String getName();
	
	public abstract List<String> asList();

}
