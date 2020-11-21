package controllers;

import java.util.List;

import entities.IEntity;

public interface IController {
	
	void load();
	void add(IEntity entity);
	void remove(Integer id);
	List<IEntity> list();
}
