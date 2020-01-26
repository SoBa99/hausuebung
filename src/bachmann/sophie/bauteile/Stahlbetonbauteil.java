package bachmann.sophie.bauteile;

import java.util.ArrayList;

import bachmann.sophie.gUI.GebaeudeplanerGUI;
import bachmann.sophie.raeumlicheObjekte.Building;
import bachmann.sophie.raeumlicheObjekte.Geschoss;

public abstract class Stahlbetonbauteil implements Volumen {

	public static double stahldichte;
	protected String festigkeitsklasse;
	protected double bewehrungsgrad;


	public Stahlbetonbauteil(double stahldichte, String festigkeitsklasse, double bewehrungsgrad) {
		this.bewehrungsgrad=bewehrungsgrad;
		this.festigkeitsklasse=festigkeitsklasse;
		setStahldichte(stahldichte);
	}
	// override überschreibt die im interface angelegten funktionen und macht diese speziell
	@Override
	public abstract double getVolumen();

	public static void setStahldichte(double dichte) {
		stahldichte = dichte;
	}

	public abstract String getFestigkeitsklasse();
	
	public abstract double getBewehrungsgrad();
	public abstract double getBewehrungsmenge_in_t();
	
	//Bewehrungsmenge
	public static double Bewehrungsmenge(Building gebaeude) {
		ArrayList<Fundament> fundamente = new ArrayList<Fundament>();
		ArrayList<Geschoss> geschosse = new ArrayList<Geschoss>();
		fundamente = gebaeude.getFundamente();
		geschosse = gebaeude.getGeschosse();
		double bewehrung = 0;
	for (int i = 0; i < fundamente.size(); i++) {
		bewehrung+= (fundamente.get(i).getVolumen()) * 0.01 * stahldichte;
		}
	for (int j = 0; j < geschosse.size(); j++) { 
		{
		bewehrung+= (geschosse.get(j).getSlab().getVolumen()) * 0.03 * stahldichte;
		}
	for (int k = 0; k < geschosse.size(); k++) {
		bewehrung+= (geschosse.get(k).getRundstuetzen().get(k).getVolumen()) * 0.05 * stahldichte;
		}
	}
	return bewehrung;	
	}
}
