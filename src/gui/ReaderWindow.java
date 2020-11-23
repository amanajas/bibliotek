package gui;

import java.util.List;

import controllers.ReaderController;
import entities.IEntity;
import entities.Reader;

public class ReaderWindow extends Window {
	
	private ReaderController controller;

	public ReaderWindow() {
		super("ReaderWindow");
		this.controller = new ReaderController();
		controller.load();
	}

	@Override
	public void show() {
		String response = "";
		List<IEntity> list;
		do {
			response = "";
			System.out.println("-- Readers --");
			System.out.println("1) List all readers alphabetically by name");
			System.out.println("2) List all readers by ID order");
			System.out.println("3) Search for a specific reader by name");
			System.out.println("4) Register");
			System.out.println("");
			System.out.println("0) Back");
			System.out.println("");
			System.out.print("-> ");
			response = read();
			switch(response.toUpperCase()) {
			case "1":
				System.out.println("-------------------");
				list = controller.listAlphabetically();
				for (IEntity ent : list) {
					Reader reader = (Reader) ent;
					System.out.println("ID: " + reader.getId() + ", Name: " + reader.getName());
					System.out.println("Address: " + reader.getAddress());
					System.out.println();
				}
				System.out.println("-------------------");
				waitForKey();
				break;
			case "2":
				System.out.println("-------------------");
				list = controller.listByIdAsc();
				for (IEntity ent : list) {
					Reader reader = (Reader) ent;
					System.out.println("ID: " + reader.getId() + ", Name: " + reader.getName());
					System.out.println("Address: " + reader.getAddress());
					System.out.println();
				}
				System.out.println("-------------------");
				waitForKey();
				break;
			case "3":
				String searchQuery = this.search();
				list = controller.searchByName(searchQuery);
				System.out.println("-------------------");
				for (IEntity ent : list) {
					Reader reader = (Reader) ent;
					System.out.println("ID: " + reader.getId() + ", Name: " + reader.getName());
					System.out.println("Address: " + reader.getAddress());
					System.out.println();
				}
				System.out.println("-------------------");
				waitForKey();
				break;
			case "4":
				System.out.println("-------------------");
				String reg = this.register();
				if (reg.length() > 0 && reg.contains(";")) {
					String[] words = reg.split(";");
					if (words.length < 2) {
						System.out.println("Error: It seems that the information given is imcomplete.");
						break;
					} else {
						controller.add(new Reader(controller.getLastId(), words[0], words[1]));
						System.out.println("Reader added: " + words[0]);
					}
				} else {
					System.out.println("Error: It was not possible to register the reader.");
				}
				System.out.println("-------------------");
				waitForKey();
				break;
			
			}
		} while (!response.equalsIgnoreCase("0"));
	}

	@Override
	public String search() {
		System.out.print("Type the name of the reader to search: ");
		return read();
	}

	@Override
	public String register() {
		System.out.print("Type the name and the address separated by semicolon(;): ");
		return read();
	}

}
