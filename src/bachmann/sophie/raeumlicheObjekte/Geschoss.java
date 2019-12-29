package bachmann.sophie.raeumlicheObjekte;

import java.util.ArrayList;
import bachmann.sophie.bauteile.Rundstuetze;
import bachmann.sophie.bauteile.Mauerwerkswand;
import bachmann.sophie.bauteile.Slab;

public class Geschoss {

	// private variables
	private String bezeichnung;
	private double hoehe;
	private boolean dachgeschoss;
	private ArrayList<Rundstuetze> rundstuetzen = new ArrayList<Rundstuetze>();
	private ArrayList<Mauerwerkswand> mauerwerkswaende = new ArrayList<Mauerwerkswand>();
	private Slab slab;
	
	// constructor
	public Geschoss(String bezeichnung, double hoehe, boolean dachgeschoss) {
		this.bezeichnung = bezeichnung;
		this.hoehe = hoehe;
		this.dachgeschoss = dachgeschoss;
	}

	//assoziation
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
	