package entities;

import java.util.ArrayList;
import java.util.List;

import factories.LibraryFactory;

public class Reader extends LibraryObject {

	private String name;
	private String address;
	
	public Reader(int id, String name, String address) {
		super(id);
		this.setName(name);
		this.setAddress(address);
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public List<String> asList() {
		List<String> content = new ArrayList<>();
		content.add(LibraryFactory.Type.READER.toString());
		content.add(String.valueOf(getId()));
		content.add(getName());
		content.add(getAddress());
		return content;
	}
	
}
