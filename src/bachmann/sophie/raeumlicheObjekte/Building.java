package bachmann.sophie.raeumlicheObjekte;

import java.util.ArrayList;
import bachmann.sophie.bauteile.Fundament;

public class Building {

	// private variables
	private String bezeichnung;
	private String bauherr_Vorname;
	private String bauherr_Nachname;
	private String strasse;
	private int hausnummer;
	private String plz;
	private String ort;
	private ArrayList<Geschoss> geschosse = new ArrayList<Geschoss>();
	private ArrayList<Fundament> fundamente = new ArrayList<Fundament>();
	
	// constructor
	public Building(String bezeichnung, String bauherr_Vorname, String bauherr_Nachname, 
			String strasse, int hausnummer, String plz, String ort) {
		this.bezeichnung = bezeichnung;
		this.bauherr_Vorname = bauherr_Vorname;
		this.bauherr_Nachname = bauherr_Nachname;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}

	// assoziation
	public ArrayList<Geschoss> getGeschosse() {
		return geschosse;
	}
	public void addGeschoss(Geschoss geschoss) {
		geschosse.add(geschoss);
	}

	public ArrayList<Fundament> getFundamente() {
		return fundamente;
	}
	public void addFundament(Fundament fundament) {
		fundamente.add(fundament);
	}

}

