package gui;

public abstract class Window {
	private final String name;
    public Window(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract void clear();
    
    public abstract Window copy();

}
