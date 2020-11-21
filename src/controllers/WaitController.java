package controllers;

import java.util.List;
import java.util.stream.Collectors;

import entities.IEntity;
import entities.Waiting;

public class WaitController extends Controller {

	public WaitController() {
		super("wait.csv");
	}
	
	public List<IEntity> searchNextReaderByBookID(Integer id) {
		List<IEntity> lireader = this.list();
		return lireader.stream()
			     .filter(item -> ((Waiting)item).getId().equals(id))
			     .collect(Collectors.toList());
	}

}
