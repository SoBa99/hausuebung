package bachmann.sophie.bauteile;

public class Window extends Opening {

	//private variables
	private double bruestungsbreite;
	
	//constructor
	public Window(double width, double height, double bruestungsbreite) {
		super(width, height);
		this.bruestungsbreite = bruestungsbreite;
	}
}
