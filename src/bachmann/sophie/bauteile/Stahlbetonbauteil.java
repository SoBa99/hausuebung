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

	public static ArrayList<String> getAlleFestigkeitsklassen(Building Gebaeude) {
		// Erstellt eine Arraylist mit allen im Gebäude verwendeten Festigkeitsklassen
		ArrayList<String> festigkeitsklassen = new ArrayList<String>();
		ArrayList<Fundament> Fundi = new ArrayList<Fundament>();
		ArrayList<Geschoss> Geschossi = new ArrayList<Geschoss>();
		Fundi = Gebaeude.getFundamente();
		Geschossi = Gebaeude.getGeschosse();
		// Zunächst über alle Fundamente iterieren und schauen, was dort für Betonfestigkeitsklassen verwendet wurden
		for (int i = 0; i < Fundi.size(); i++) {
			// Sind schon Festigkeitsklassenbeschreibungen in der Liste, wenn nein, dann einfach hinzufügen
			if (festigkeitsklassen.isEmpty()) {
				festigkeitsklassen.add(Fundi.get(i).getFestigkeitsklasse());
			}
			// wenn ja, dann schauen ob die aktuelle schon enthalten ist, wenn nicht, dann hinzufügen
			else {
				for (String string : festigkeitsklassen) {
					if (!festigkeitsklassen.contains(Fundi.get(i).getFestigkeitsklasse())) {
						festigkeitsklassen.add(Fundi.get(i).getFestigkeitsklasse());
						break;  // need to break because arraylist changed in size
					}
				}
			}
		}
		// Dann über alle Geschosse iterieren und schauen, was dort für Betonfestigkeitsklassen verwendet wurden (Slab und Rundstützen)
		for (int i = 0; i < Geschossi.size(); i++) {
			// Sind schon Festigkelitsklassenbeschreibungen in der Liste, wenn nein, dann einfach hinzufügen
			if (festigkeitsklassen.isEmpty()) {
				// Hier nehme ich an, dass jedes Geschoss einen SLAB hat, bei Rundstützen kann das m.m.n nicht immer der Fall sein
				festigkeitsklassen.add(Geschossi.get(i).getSlab().getFestigkeitsklasse());
			}
			else {
				// Bei allen Rundstützen nachschauen
				for (int k = 0; k < Geschossi.get(i).getRundstuetzen().size(); k++) {
					for (String string : festigkeitsklassen) {
						if (!festigkeitsklassen.contains(Geschossi.get(i).getRundstuetzen().get(k).getFestigkeitsklasse())) {
							festigkeitsklassen.add(Geschossi.get(i).getRundstuetzen().get(k).getFestigkeitsklasse());
							break;
						}
					}
				}
				// und dann bei der Slab, falls noch nicht geschehen
				for (String string : festigkeitsklassen) {
					if (!festigkeitsklassen.contains(Geschossi.get(i).getSlab().getFestigkeitsklasse())) {
						festigkeitsklassen.add(Geschossi.get(i).getSlab().getFestigkeitsklasse());
						break;
					}
				}
			}
		}
		return festigkeitsklassen;
	}

	public static double computeVolume(Building meinGebaeude, String Betonfestigkeitsklasse) {
		// Berechne die Volumina der entsprechenden verwendeten Festigkeitsklassen
		ArrayList<Fundament> Fundi = new ArrayList<Fundament>();
		ArrayList<Geschoss> Geschossi = new ArrayList<Geschoss>();
		Fundi = meinGebaeude.getFundamente();
		Geschossi = meinGebaeude.getGeschosse();
		double Volumen = 0;

		// In allen Fundamenten nachschauen, wie viel Volumen an dem bestimmten Beton verwendet wurde
		for (int i = 0; i < Fundi.size(); i++) {
			if (Fundi.get(i).getFestigkeitsklasse().equals(Betonfestigkeitsklasse)) {
				Volumen += Fundi.get(i).getVolumen();
			}
		}

		// In allen Geschossen nachschauen, wie viel Volumen an dem bestimmten Beton verwendet wurde
		for (int i = 0; i < Geschossi.size(); i++) {
			if (Geschossi.get(i).getSlab().getFestigkeitsklasse().equals(Betonfestigkeitsklasse)) {
				Volumen += Geschossi.get(i).getSlab().getVolumen();
			}
			for (int k = 0; k < Geschossi.get(i).getRundstuetzen().size(); k++) {
				if (Geschossi.get(i).getRundstuetzen().get(k).getFestigkeitsklasse().equals(Betonfestigkeitsklasse)) {
					Volumen += Geschossi.get(i).getRundstuetzen().get(k).getVolumen();
				}
			}
		}

		return Volumen;
	}

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
