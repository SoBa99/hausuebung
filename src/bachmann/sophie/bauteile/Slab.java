package bachmann.sophie.bauteile;

import java.util.ArrayList;

public class Slab extends Stahlbetonbauteil {
	
	// private variables
	private double width;
	private double length;
	private double height;
	private ArrayList<Opening> openings = new ArrayList<Opening>();
	
	// constructor
	public Slab (String festigkeitsklasse, double bewehrungsgrad, double width, double lenght, double height) {
		this.festigkeitsklasse = festigkeitsklasse;
		this.bewehrungsgrad = bewehrungsgrad;
		this.width = width;
		this.length = lenght;
		this.height = height;
	}
	//test
	public double getwidth(){
		return width;
	}
	public double getlenght(){
		return lenght;
	}
	public double getheight(){
		return height;
	}
	//test
	// assoziation
	public ArrayList<Opening> getOpenings() {
		return openings;
	}
	public void addOpening(Opening opening) {
		openings.add(opening);
	}
}
