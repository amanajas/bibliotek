package entities;

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
	
}
