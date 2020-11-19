package controllers;

import java.util.ArrayList;
import java.util.List;

import entities.LibraryObject;

public class Controller implements IController {
	
	private List<LibraryObject> objects;
	
	public Controller() {
		this.objects = new ArrayList<>();
	}

	@Override
	public void load() {
		
	}

	@Override
	public void add(LibraryObject entity) {
		this.objects.add(entity);
	}

	@Override
	public void remove(int id) {
		this.objects.removeIf(t -> t.getId() == id);
	}

	@Override
	public List<LibraryObject> list() {
		return this.objects;
	}


}
