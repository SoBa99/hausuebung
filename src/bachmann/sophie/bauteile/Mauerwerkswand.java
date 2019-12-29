package bachmann.sophie.bauteile;


import java.util.ArrayList;

import bachmann.sophie.raeumlicheObjekte.Geschoss;

public class Mauerwerkswand {

	// private variables
	private double dicke;
	private double laenge;
	private ArrayList<Opening> openings = new ArrayList<Opening>();

	// constructor
	public Mauerwerkswand (double dicke, double laenge) {
		this.dicke = dicke;
		this.laenge = laenge;
	}
	// assoziation
	public ArrayList<Opening> getOpenings() {
		return openings;
	}
	public void addOpening(Opening opening) {
		openings.add(opening);
	}
}
