package controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import entities.IEntity;
import entities.Reader;

public class ReaderController extends Controller {

	public ReaderController() {
		super("readers.csv");
	}
	
	public ReaderController(String filePath) {
		super(filePath);
	}
	
	public Reader searchById(Integer id) {
		List<IEntity> lireader = this.list();
		return (Reader) lireader.stream()
			     .filter(item -> ((Reader)item).getId().equals(id));
	}
	
	public List<IEntity> searchByName(String name) {
		List<IEntity> lireader = this.list();
		return lireader.stream()
			     .filter(item -> ((Reader)item).getName().contains(name))
			     .collect(Collectors.toList());
	}
	
	public List<IEntity> listAlphabetically() {
		List<IEntity> lireader = this.list();
		lireader.sort(new Comparator<IEntity>(){
		    public int compare(IEntity s1, IEntity s2) {
		        return ((Reader)s1).getName().compareToIgnoreCase(((Reader)s2).getName());
		    }
		});
		return lireader;
	}
	
	public List<IEntity> listByIdAsc() {
		List<IEntity> lireader = this.list();
		Collections.sort(lireader);
		return lireader;
	}

}
