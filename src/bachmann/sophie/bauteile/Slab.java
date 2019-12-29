package bachmann.sophie.bauteile;

import java.util.ArrayList;

public class Slab extends Stahlbetonbauteil {
	
	// private variables
	private double width;
	private double length;
	private double height;
	private ArrayList<Opening> openings = new ArrayList<Opening>();
	
	// constructor
	public Slab (double width, double lenght, double height) {
		this.width = width;
		this.length = lenght;
		this.height = height;
	}
	
	// assoziation
	public ArrayList<Opening> getOpenings() {
		return openings;
	}
	public void addOpening(Opening opening) {
		openings.add(opening);
	}
}