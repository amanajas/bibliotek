package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.IEntity;
import entities.LibraryObject;
import factories.LibraryFactory;
import utils.FileUtils;

public class Controller implements IController {
	
	private List<IEntity> objects;
	private String path;
	private Integer lastId;
	
	public Controller(String path) {
		this.objects = new ArrayList<>();
		this.path = path;
		this.lastId = 1;
	}
	

	@Override
	public void add(IEntity entity) {
		this.objects.add(entity);
		this.lastId = entity.getId();
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
				if (libo.getId() > lastId) {
					lastId = libo.getId();
				}
				this.objects.add(libo);
			}
		}
	}

	@Override
	public Integer getLastId() {
		return this.lastId + 1;
	}


	@Override
	public boolean exists(Integer id) {
		List<IEntity> libook = this.list();
		return libook.stream()
			     .filter(item -> item.getId().equals(id))
			     .collect(Collectors.toList()).size() > 0;
	}


}
