package bachmann.sophie.bauteile;

import java.util.ArrayList;

import bachmann.sophie.gUI.GebaeudeplanerGUI;
import bachmann.sophie.raeumlicheObjekte.Geschoss;

public abstract class Stahlbetonbauteil implements Volumen {

	public static double stahldichte;
	protected String festigkeitsklasse;
	protected double bewehrungsgrad;

	
	public Stahlbetonbauteil(double stahldichte, String festigkeitsklasse, double bewehrungsgrad) {
		
	}
	// override überschreibt die im interface angelegten funktionen und macht diese speziell
	@Override
	public double getVolumen() {

		return 0;
	}
	public static void setStahldichte(double dichte) {
		stahldichte = dichte;
	}
	public String getFestigkeitsklasse() {
		return festigkeitsklasse;
	}

	public double rundstuetzeVolumen(double hoehe, double durchmesser) {
		double zVolumen = 0;
		zVolumen = Math.PI * hoehe * Math.pow(durchmesser/2, 2);
		return zVolumen;
	}
	public double bodenplatteVolumen(double hoehe, double breite, double laenge) {
		double kVolumen = 0;
		kVolumen = hoehe * breite * laenge;
		return kVolumen;
	}
	public double einzelfundamenteVolumen(double breite, double laenge) {
		double kVolumen = 0;
		kVolumen = 2 * breite * laenge;
		return kVolumen;
// Volumenberechnung Anfang
	double F1 = 0;
	double F2 =0;
	ArrayList<Fundament> Fundi = new ArrayList<Fundament>();
	ArrayList<Geschoss> Geschossi = new ArrayList<Geschoss>(); {
	Fundi = GebaeudeplanerGUI.getFundamente();
	Geschossi = GebaeudeplanerGUI.getGeschosse();
	for (int i = 0; i < Fundi.size(); i++) {
		if (Fundi.get(i).getFestigkeitsklasse().equals("C20/25")) {
			F1 += Fundi.get(i).bodenplatteVolumen((Fundi.get(i)).getHoehe(), Fundi.get(i).getTiefe(), Fundi.get(i).getLaenge());
		} else if (Fundi.get(i).getFestigkeitsklasse().equals("C25/30")) {

		}
	for (int k = 0; k < Geschossi.size(); k++) {
		if (Geschossi.get(k).getFestigkeitsklasse().equals("C25/30")) {
			F2 += Geschossi.get(k).zylinderVolumen(Geschossi.get(k).getMathPI, radius);
		}}}}}
	

