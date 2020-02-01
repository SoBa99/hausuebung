package bachmann.sophie.bauteile;

public class Door extends Opening {

	// private variables
	private String description;

	// constructor
	public Door(double width, double height, String description) {
		super(width, height);
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getFlaeche() {
		return this.width * this.height;
	}
}
