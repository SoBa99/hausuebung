package bachmann.sophie.bauteile;

public class Bodenplatte extends Fundament {
	
	// private variables
	private double breite;
	private double laenge; 
	
	// constructor
	public Bodenplatte(double breite, double laenge, double tiefe, double stahldichte, String festigkeitsklasse, double bewehrungsgrad) {
		super(tiefe, stahldichte, festigkeitsklasse, bewehrungsgrad);
		this.setBreite(breite);
		this.setLaenge(laenge);
	}

	public double getBreite() {
		return breite;
	}

	public void setBreite(double breite) {
		this.breite = breite;
	}

	public double getLaenge() {
		return laenge;
	}

	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}

	@Override
	public double getVolumen() {
		return this.tiefe * this.breite * this.laenge;
	}
	@Override
	public String getFestigkeitsklasse() {
		return this.festigkeitsklasse;
	}
}
