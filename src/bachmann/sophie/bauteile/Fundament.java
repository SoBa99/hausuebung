package bachmann.sophie.bauteile;

public abstract class Fundament extends Stahlbetonbauteil {

	// private variables
	protected double tiefe;

	public void setTiefe(double tiefe) {
		this.tiefe = tiefe;
	}
	public double getTiefe() {
		return tiefe; 
	}

	// kein constructor nötig weil abstrakt
	public Fundament(double tiefe, double stahldichte, String festigkeitsklasse, double bewehrungsgrad) {
		super(stahldichte, festigkeitsklasse, bewehrungsgrad);
		this.tiefe = tiefe;

	}
}
