package controllers;

import java.util.List;

import entities.LibraryObject;

public interface IController {
	
	void load();
	void add(LibraryObject entity);
	void remove(int id);
	List<LibraryObject> list();
}
