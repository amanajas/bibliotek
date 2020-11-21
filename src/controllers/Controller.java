package controllers;

import java.util.ArrayList;
import java.util.List;

import entities.IEntity;
import entities.LibraryObject;
import factories.LibraryFactory;
import utils.FileUtils;

public class Controller implements IController {
	
	private List<IEntity> objects;
	private String path;
	
	public Controller(String path) {
		this.objects = new ArrayList<>();
		this.path = path;
	}
	

	@Override
	public void add(IEntity entity) {
		this.objects.add(entity);
		this.saveList();
	}

	@Override
	public void remove(Integer id) {
		this.objects.removeIf(t -> t.getId().equals(id));
		this.saveList();
	}

	@Override
	public List<IEntity> list() {
		return this.objects;
	}
	
	/**
	 * Save list in a file
	 */
	private void saveList() {
		List<List<String>> content = new ArrayList<>();
		for (IEntity libo : objects) {
			content.add(((LibraryObject)libo).asList());
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
