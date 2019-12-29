package bachmann.sophie.bauteile;

public class Door extends Opening {

	// private variables
	private String description;
	
	// constructor
	public Door(double width, double height, String description) {
		super(width, height);
		this.description = description;
	}

}
