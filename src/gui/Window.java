package gui;

import java.io.IOException;
import java.util.Scanner;

public abstract class Window {
	private final String name;
    public Window(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
        
    public abstract void show();
    public abstract String search();
    public abstract String register();

    
    /**
	 * Read the user input as string
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String read() {
		String word = null;
		try {
			word = new Scanner(System.in).nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        return word;
	}
	
	// Wait for input
	public void waitForKey() {
		System.out.println("");
		System.out.println("Press any key to continue");
		System.out.println("");
		try {
			System.in.read();
		} catch (IOException e) {
			// No warning
		}
	}
}
