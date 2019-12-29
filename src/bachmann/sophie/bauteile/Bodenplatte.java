package bachmann.sophie.bauteile;

public class Bodenplatte extends Fundament {
	
	// private variables
	private double breite;
	private double laenge; 
	
	// constructor
	public Bodenplatte(double tiefe, double bewehrungsgrad, String festigkeitsklasse, double breite, double laenge) {
		this.tiefe = tiefe;
		this.bewehrungsgrad = bewehrungsgrad;
		this.festigkeitsklasse = festigkeitsklasse;
		this.breite = breite;
		this.laenge = laenge;
	}
}
