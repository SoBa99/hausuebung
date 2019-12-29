package bachmann.sophie.bauteile;

public class Window extends Opening {

	//private variables
	private double bruestungshoehe;
	
	//constructor
	public Window(double width, double height, double bruestungshoehe) {
		super(width, height);
		this.bruestungshoehe = bruestungshoehe;
	}
}
