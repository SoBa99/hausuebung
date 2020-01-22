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

	// Volumenberechnung Anfang
//	public double berechneStahlbetonVolumen(Building Gebaeude) {
//		double F1 = 0;
//		double F2 = 0;
//		ArrayList<Fundament> Fundi = new ArrayList<Fundament>();
//		ArrayList<Geschoss> Geschossi = new ArrayList<Geschoss>();
//
//		Fundi = Gebaeude.getFundamente();
//		Geschossi = Gebaeude.getGeschosse();
//		for (int i = 0; i < Fundi.size(); i++) {
//			if (Fundi.get(i).getFestigkeitsklasse().equals("C20/25")) {
//				Bodenplatte B = (Bodenplatte)(Fundi.get(i));
//				F1 += B.bodenplatteVolumen(B.getTiefe(), B.getBreite(), B.getLaenge());
//			} else if (Fundi.get(i).getFestigkeitsklasse().equals("C25/30")) {
//			}
//		}
//		for (int k = 0; k < Geschossi.size(); k++) {
//			if (Geschossi.get(k).getSlab().getFestigkeitsklasse().equals("C25/30")) {
//				F2 += Geschossi.get(k).zylinderVolumen(Geschossi.get(k).getMathPI, radius);
//			}
//		}
//		return 0;
//	}
}