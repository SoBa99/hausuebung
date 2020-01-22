package bachmann.sophie.bauteile;


import java.util.ArrayList;

import bachmann.sophie.raeumlicheObjekte.Geschoss;

public class Mauerwerkswand {

	// private variables
	private double dicke;
	private double laenge;
	private Geschoss geschoss;
	private ArrayList<Opening> openings = new ArrayList<Opening>();

	// constructor
	public Mauerwerkswand (double dicke, double laenge) {
		this.setDicke(dicke);
		this.setLaenge(laenge);
	}
	// assoziation
	public ArrayList<Opening> getOpenings() {
		return openings;
	}
	public void addOpening(Opening opening) {
		openings.add(opening);
	}
	public double getDicke() {
		return dicke;
	}
	public void setDicke(double dicke) {
		this.dicke = dicke;
	}
	public double getLaenge() {
		return laenge;
	}
	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}
	public Geschoss getGeschoss() {
		return geschoss;
	}
	public void setGeschoss(Geschoss geschoss) {
		this.geschoss = geschoss;
	}
}
