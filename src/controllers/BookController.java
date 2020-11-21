package controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import entities.Book;
import entities.IEntity;

public class BookController extends Controller {

	public BookController() {
		super("books.csv");
	}
	
	public List<IEntity> searchByTitle(String title) {
		List<IEntity> libook = this.list();
		return libook.stream()
			     .filter(item -> ((Book)item).getName().contains(title))
			     .collect(Collectors.toList());
	}
	
	public List<IEntity> searchByAuthor(String author) {
		List<IEntity> libook = this.list();
		return libook.stream()
			     .filter(item -> ((Book)item).getAuthor().contains(author))
			     .collect(Collectors.toList());
	}
	
	public List<IEntity> listAlphabetically() {
		List<IEntity> libook = this.list();
		libook.sort(new Comparator<IEntity>(){
		    public int compare(IEntity s1, IEntity s2) {
		        return ((Book)s1).getName().compareToIgnoreCase(((Book)s2).getName());
		    }
		});
		return libook;
	}
	
	public List<IEntity> listByAuthorAlphabetically() {
		List<IEntity> libook = this.list();
		libook.sort(new Comparator<IEntity>(){
		    public int compare(IEntity s1, IEntity s2) {
		        return ((Book)s1).getAuthor().compareToIgnoreCase(((Book)s2).getAuthor());
		    }
		});
		return libook;
	}
	
	public List<IEntity> getListOfBooks(List<Integer> list) {
		List<IEntity> libook = this.list();
		return libook.stream()
			     .filter(item -> list.contains(item.getId()))
			     .collect(Collectors.toList());
	}

}
