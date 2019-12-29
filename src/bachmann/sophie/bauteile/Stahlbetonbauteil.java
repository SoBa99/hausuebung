package bachmann.sophie.bauteile;

public abstract class Stahlbetonbauteil implements Volumen {

	// private variables
	public static double stahldichte;
	private String festigkeitsklasse;
	protected double bewehrungsgrad;
	
	// override überschreibt die im interface angelegten funktionen und macht diese speziell
	@Override
	public double getVolumen() {
		// TODO Auto-generated method stub
		return 0;
	}
}
