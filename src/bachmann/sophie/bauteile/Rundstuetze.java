package bachmann.sophie.bauteile;

import bachmann.sophie.raeumlicheObjekte.Geschoss;

public class Rundstuetze extends Stahlbetonbauteil {
	// private variables
	private double durchmesser;
	private Geschoss geschoss;
	
	// constructor
	public Rundstuetze(double durchmesser) {
		this.durchmesser = durchmesser;
	}
	
	// jede stütze nur ein geschoss, deswegen keine arraylist notwendig
	public Geschoss getGeschoss() {
		return geschoss;
	}
	public void setGeschoss(Geschoss geschoss) {
		this.geschoss = geschoss;
	}
}
