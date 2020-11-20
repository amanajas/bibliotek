package controllers;

import java.util.ArrayList;
import java.util.List;

import entities.LibraryObject;
import factories.LibraryFactory;
import utils.FileUtils;

public class Controller implements IController {
	
	private List<LibraryObject> objects;
	private String path;
	
	public Controller(String path) {
		this.objects = new ArrayList<>();
		this.path = path;
	}
	

	@Override
	public void add(LibraryObject entity) {
		this.objects.add(entity);
		this.saveList();
	}

	@Override
	public void remove(int id) {
		this.objects.removeIf(t -> t.getId() == id);
		this.saveList();
	}

	@Override
	public List<LibraryObject> list() {
		return this.objects;
	}
	
	private void saveList() {
		List<List<String>> content = new ArrayList<>();
		for (LibraryObject libo : objects) {
			content.add(libo.asList());
		}
		FileUtils.saveCSV(path, content);
	}

	@Override
	public void load() {
		List<List<String>> loaded = FileUtils.loadCSV(path);
		for (List<String> libostr : loaded) {
			LibraryObject libo = LibraryFactory.create(libostr);
			if (libo != null) {
				this.objects.add(libo);
			}
		}
	}


}
