package controllers;

import java.util.List;
import java.util.stream.Collectors;

import entities.Borrowing;
import entities.IEntity;

public class BorrowControlller extends Controller {

	public BorrowControlller() {
		super("borrows.csv");
	}

	public BorrowControlller(String filePath) {
		super(filePath);
	}
	
	public List<IEntity> searchBorrowedBookReaderByID(Integer id) {
		List<IEntity> libook = this.list();
		return libook.stream()
			     .filter(item -> ((Borrowing)item).getReader().equals(id))
			     .collect(Collectors.toList());
	}
	
	public List<IEntity> searchBorrowedBookByID(Integer id) {
		List<IEntity> libook = this.list();
		return libook.stream()
			     .filter(item -> ((Borrowing)item).getBook().equals(id))
			     .collect(Collectors.toList());
	}

}
