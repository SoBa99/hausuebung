package bachmann.sophie.bauteile;

public class Einzelfundament extends Fundament {
	
	// private variables
	private double breite;
	
	// constructor
	public Einzelfundament(double tiefe, double bewehrungsgrad, String festigkeitsklasse, double breite) {
		this.tiefe = tiefe;
		this.bewehrungsgrad = bewehrungsgrad;
		this.festigkeitsklasse = festigkeitsklasse;
		this.breite = breite;
	}
}
