package entities;

public class Reader implements IEntity {

	private int id;
	private String name;
	private String address;
	
	public Reader(int id, String name, String address) {
		this.id = id;
		this.setName(name);
		this.setAddress(address);
	}

	@Override
	public int getId() {
		return id;
	}

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
