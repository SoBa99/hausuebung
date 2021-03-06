package bachmann.sophie.bauteile;

public class Einzelfundament extends Fundament {

	// private variables
	private double breite;

	// constructor
	public Einzelfundament(double breite, double tiefe, double stahldichte, String festigkeitsklasse, double bewehrungsgrad) {
		super(tiefe, stahldichte, festigkeitsklasse, bewehrungsgrad);
		this.breite = breite;
		this.setBreite(breite);
	}

	public double getBreite() {
		return breite;
	}

	public void setBreite(double breite) {
		this.breite = breite;
	}
	// Festigkeitsklasse
	@Override
	public double getVolumen() {
		return Math.pow(this.tiefe,2)*this.breite;
	}

	@Override
	public String getFestigkeitsklasse() {
		return this.festigkeitsklasse;
	}
	// Bewehrungsgrad
	@Override
	public double getBewehrungsgrad() {
		return this.bewehrungsgrad;
	}
	@Override
	public double getBewehrungsmenge_in_t() {
		return getVolumen() * bewehrungsgrad;
	}
}
