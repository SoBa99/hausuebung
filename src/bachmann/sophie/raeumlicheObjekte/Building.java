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
		this.setBezeichnung(bezeichnung);
		this.setBauherr_Vorname(bauherr_Vorname);
		this.setBauherr_Nachname(bauherr_Nachname);
		this.setStrasse(strasse);
		this.setHausnummer(hausnummer);
		this.setPlz(plz);
		this.setOrt(ort);
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

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBauherr_Vorname() {
		return bauherr_Vorname;
	}

	public void setBauherr_Vorname(String bauherr_Vorname) {
		this.bauherr_Vorname = bauherr_Vorname;
	}

	public String getBauherr_Nachname() {
		return bauherr_Nachname;
	}

	public void setBauherr_Nachname(String bauherr_Nachname) {
		this.bauherr_Nachname = bauherr_Nachname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

}

