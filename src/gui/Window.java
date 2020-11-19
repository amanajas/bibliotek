package gui;

public abstract class Window {
	private final String name;
    public Window(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
        
    public abstract void show();
    
    public abstract Window copy();

}
