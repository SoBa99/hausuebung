package bachmann.sophie.bauteile;

import bachmann.sophie.raeumlicheObjekte.Geschoss;

public class Rundstuetze extends Stahlbetonbauteil {
	// private variables
	private double durchmesser;
	private Geschoss geschoss;

	// constructor
	public Rundstuetze(double durchmesser, Geschoss geschoss, double stahldichte, String festigkeitsklasse, double bewehrungsgrad) {
		super(stahldichte, festigkeitsklasse, bewehrungsgrad);
		this.setDurchmesser(durchmesser);
	}

	// jede stütze nur ein geschoss, deswegen keine arraylist notwendig
	public Geschoss getGeschoss() {
		return geschoss;
	}
	public void setGeschoss(Geschoss geschoss) {
		this.geschoss = geschoss;
	}

	public double getDurchmesser() {
		return durchmesser;
	}

	public void setDurchmesser(double durchmesser) {
		this.durchmesser = durchmesser;
	}
	// Festigkeitsklasse
	@Override
	public double getVolumen() {
		return Math.PI*Math.pow(this.durchmesser/2,2)*this.geschoss.getHoehe();
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
