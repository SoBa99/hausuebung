package bachmann.sophie.raeumlicheObjekte;

import java.util.ArrayList;
import bachmann.sophie.bauteile.Rundstuetze;
import bachmann.sophie.bauteile.Mauerwerkswand;
import bachmann.sophie.bauteile.Slab;

// TODO implement classes from above
public class Geschoss {

	// private variables
	private String bezeichnung;
	private double hoehe;
	private boolean dachgeschoss;
	private ArrayList<Rundstuetze> rundstuetzen = new ArrayList<Rundstuetze>();
	private ArrayList<Mauerwerkswand> mauerwerkswaende = new ArrayList<Mauerwerkswand>();
	private Slab slab;
	
	
	// public variables
	
	// constructor

	
	// TODO: constructor schreiben
	
	
	public ArrayList<Rundstuetze> getRundstuetzen() {
		return rundstuetzen;
	}
	public void addRundstuetze(Rundstuetze rundstuetze) {
		rundstuetzen.add(rundstuetze);
	}
	
	public ArrayList<Mauerwerkswand> getMauerwerkswaende() {
		return mauerwerkswaende;
	}
	public void addMauerwerkswand(Mauerwerkswand mauerwerkswand) {
		mauerwerkswaende.add(mauerwerkswand);
	}
	
	public Slab getSlab() {
		return slab;
	}
	public void setSlab(Slab slab) {
		this.slab = slab;
	}
}
	