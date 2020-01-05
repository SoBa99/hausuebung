package bachmann.sophie.bauteile;

public abstract class Stahlbetonbauteil implements Volumen {

	// private variables
	public static double stahldichte;
	protected String festigkeitsklasse;
	protected double bewehrungsgrad;

	// override überschreibt die im interface angelegten funktionen und macht diese speziell
	@Override
	public double getVolumen() {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void setStahldichte(double dichte) {
		stahldichte = dichte;
	}
	// Volumenberechnung
	/*public static void main(String[] args) {
		double breite;
		double tiefe;
		double laenge;
		double hoehe;
		double durchmesser;
		System.out.println("Volumen Bodenplatte: " + (tiefe * breite * laenge));
		System.out.println("Volumen Einzelfundament: " + (tiefe * breite * breite)); // weil quadratisch
		System.out.println("Volumen Rundstuetze: " + (Math.PI * durchmesser * hoehe));
	}*/
	
	
	
}
