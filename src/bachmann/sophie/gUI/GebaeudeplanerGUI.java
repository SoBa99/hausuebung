package bachmann.sophie.gUI;

import javax.swing.JFrame;

import bachmann.sophie.bauteile.*;
import bachmann.sophie.raeumlicheObjekte.Building;
import bachmann.sophie.raeumlicheObjekte.Geschoss;

import java.util.ArrayList;

import javax.swing.JCheckBox;

public class GebaeudeplanerGUI {

	// private variables
	private JFrame frmGebaeudeplaner;
	private JCheckBox chckbxFensterUndTuermenge;
	private JCheckBox chckbxBetonUndBewehrungsmenge;
	private JCheckBox chckbxSeitlicheWandflaeche;

	// constructor
	public GebaeudeplanerGUI(JFrame frmGebaeudeplaner,
	JCheckBox chckbxFensterUndTuermenge,
	JCheckBox chckbxBetonUndBewehrungsmenge,
	JCheckBox chckbxSeitlicheWandflaeche) {
		this.frmGebaeudeplaner = frmGebaeudeplaner;
		this.chckbxFensterUndTuermenge = chckbxFensterUndTuermenge;
		this.chckbxBetonUndBewehrungsmenge = chckbxBetonUndBewehrungsmenge;
		this.chckbxSeitlicheWandflaeche = chckbxSeitlicheWandflaeche;
	}
	public static void main(String[] args) {
		/*-------Instanziierung-------*/
		Stahlbetonbauteil.setStahldichte(7.85);

		// Gebäude
		Building Gebaeude = new Building("Haus", "Sophie", "Bachmann",
				"Unistraße", 353 , "66915", "Kassel");
		Geschoss EG = new Geschoss("EG", 2.72, false);

		// Fundamente
		Bodenplatte Bp = new Bodenplatte(8.09, 9.52, 0.16, 7.85, "C20/25", 0.01);
		Einzelfundament E1 = new Einzelfundament(0.44, 0.6, 7.85, "C20/25", 0.01);
		Einzelfundament E2 = new Einzelfundament(0.44, 0.6, 7.85, "C20/25", 0.01);
		Einzelfundament E3 = new Einzelfundament(0.44, 0.6, 7.85, "C20/25", 0.01);
		//Stützen
		Rundstuetze R1 = new Rundstuetze(0.25, EG, 7.85, "C25/30", 0.05);
		Rundstuetze R2 = new Rundstuetze(0.25, EG, 7.85, "C25/30", 0.05);
		Rundstuetze R3 = new Rundstuetze(0.25, EG, 7.85, "C25/30", 0.05);
		// Das wird benötigt, damit die Rundstützen bei der Volumenberechnung wissen, wie hoch sie sind (glkeiche Höhe wie Geschoss)
		R1.setGeschoss(EG);
		R2.setGeschoss(EG);
		R3.setGeschoss(EG);

		// Wände
		Mauerwerkswand AWnord = new Mauerwerkswand(0.4, 8.09, EG, 2.72);
		Mauerwerkswand AWost = new Mauerwerkswand(0.4, 8.72, EG, 2.72);
		Mauerwerkswand AWsued = new Mauerwerkswand(0.4, 8.09, EG, 2.72);
		Mauerwerkswand AWwest = new Mauerwerkswand(0.4, 8.72, EG, 2.72);
		Mauerwerkswand IW34 = new Mauerwerkswand(0.24, 4.36, EG, 2.72);  // Wand zwischen Schlafen und Wohnen
		Mauerwerkswand IW45 = new Mauerwerkswand(0.24, 2.56, EG, 2.72);  // Wand zwischen Schlafen und Bad
		Mauerwerkswand IW234 = new Mauerwerkswand(0.24, 2.78, EG, 2.72);  // Wand zwischen Schlafen, Küche und Wohnen
		Mauerwerkswand IW25 = new Mauerwerkswand(0.24, 2.93, EG, 2.72);  // Wand zwischen Bad und Küche
		Mauerwerkswand IW12 = new Mauerwerkswand(0.24, 2.93, EG, 2.72);  // Wand zwischen Küche und Flur
		Mauerwerkswand IW13 = new Mauerwerkswand(0.24, 2.9, EG, 2.72);  // Wand zwischen Wohnen und Flur

		// Decke
		Slab Decke = new Slab(12.49, 9.52, 0.18, 7.85, "C20/25", 0.03);

		// Öffnungen
		Window Fenster3sued = new Window(1.2, 1.26, 1.0);  // Fenster Wohnen
		Window Fenster3west = new Window(2.01, 1.26, 1.0);  // Fenster Wohnen
		Window Fenster4west = new Window(2.01, 1.26, 1.0);  // Fenster Schlafen
		Window Fenster5nord = new Window(0.9, 1.26, 1.0);  // Fenster Bad
		Window Fenster5ost = new Window(1.32, 1.26, 1.0);  // Fenster Bad
		Window Fenster2ost = new Window(1.32, 1.26, 1.0);  // Fenster Küche
		Window Fenster1ost = new Window(1.32, 1.26, 1.0);  // Fenster Flur
		Door Tuer4nord = new Door(2.42, 2.26, "Doppeltür Terrasse"); // Tür Schlafen
		Door Tuer1sued = new Door(1.76, 2.26, "Doppeltür Eingang"); // Eingangstür
		Door Tuer13 = new Door(1.13, 2.26, "Zimmertür von 1 zu 3"); // Tür von Flur nach Wohnen
		Door Tuer21 = new Door(1.03, 2.26, "Zimmertür von 2 zu 1"); // Tür von Küche nach Flur
		Door Tuer43 = new Door(1.03, 2.26, "Zimmertür von 4 zu 3"); // Tür von Schlafen nach Wohnen
		Door Tuer54 = new Door(0.88, 2.26, "Zimmertür von 5 zu 4"); // Tür von Bad nach Schlafen

		/*-------Assoziationen-------*/
		Gebaeude.addGeschoss(EG);
		Gebaeude.addFundament(Bp);
		Gebaeude.addFundament(E1);
		Gebaeude.addFundament(E2);
		Gebaeude.addFundament(E3);
		EG.addRundstuetze(R1);
		EG.addRundstuetze(R2);
		EG.addRundstuetze(R3);
		AWnord.addOpening(Tuer4nord);
		AWnord.addOpening(Fenster5nord);
		AWost.addOpening(Fenster1ost);
		AWost.addOpening(Fenster2ost);
		AWost.addOpening(Fenster5ost);
		AWsued.addOpening(Tuer1sued);
		AWsued.addOpening(Fenster3sued);
		AWwest.addOpening(Fenster3west);
		AWwest.addOpening(Fenster4west);
		IW34.addOpening(Tuer43);
		IW45.addOpening(Tuer54);
		IW12.addOpening(Tuer21);
		IW13.addOpening(Tuer13);
		EG.addMauerwerkswand(AWnord);
		EG.addMauerwerkswand(AWost);
		EG.addMauerwerkswand(AWsued);
		EG.addMauerwerkswand(AWwest);
		EG.addMauerwerkswand(IW34);
		EG.addMauerwerkswand(IW45);
		EG.addMauerwerkswand(IW234);
		EG.addMauerwerkswand(IW25);
		EG.addMauerwerkswand(IW12);
		EG.addMauerwerkswand(IW13);
		EG.setSlab(Decke);

		// Test nachher wieder rauslösschen
		System.out.println("Anzahl Öffnungen: " + getAllOpenings(Gebaeude).size());
		System.out.println("Anzahl Türen: " + getAllDoors(getAllOpenings(Gebaeude)));
		System.out.println("Anzahl Fenster: " + getAllWindows(getAllOpenings(Gebaeude)));
		ArrayList<String> festi;
		festi =  getAlleFestigkeitsklassen(Gebaeude);
		System.out.println("Verwendete Festigkeitsklassen: ");
		for (int i = 0; i <  festi.size(); i++) {
			System.out.println(festi.get(i) + " ");
		}
		System.out.println("Verwendetes Betonvolumen pro Festigkeitsklasse: ");
		for (int i = 0; i <  festi.size(); i++) {
			System.out.println(festi.get(i) + ": " + computeVolume(Gebaeude, festi.get(i)));
		}
		System.out.println("Bewehrungsmenge in Tonnen: " + Stahlbetonbauteil.Bewehrungsmenge(Gebaeude));
		ArrayList<Double> dicki;
		dicki = Mauerwerkswand.getAlleMauerwerkswanddicken(Gebaeude);
		System.out.println("Mauerwerkswandddicken im Gebäude: ");
		for (int i = 0; i < dicki.size(); i++) {
			System.out.println(dicki.get(i));
		}	
		System.out.println("Mauerwerkswandfläche pro Mauerwerkswanddicke: ");
		for (int i = 0; i < dicki.size(); i++) {
			System.out.println(dicki.get(i) + ": " + Mauerwerkswand.mauerwerkswandFlächen(Gebaeude, dicki.get(i)));
		}
	}
		// Test ende */
	
	private static ArrayList<Opening> getAllOpenings(Building Gebaeude) {
		ArrayList<Geschoss> Etagen = new ArrayList<Geschoss>();
		ArrayList<Mauerwerkswand> Waende = new ArrayList<Mauerwerkswand>();
		ArrayList<Opening> EtagenOeffnungen = new ArrayList<Opening>();  // Öffnungen je nach Etage
		ArrayList<Opening> GebaeudeOeffnungen = new ArrayList<Opening>(); // ArrayList aller Öffnungen des gesamten Gebäudes
		int anzahlEtagen;
		int anzahlWaende;
		Etagen = Gebaeude.getGeschosse();
		anzahlEtagen = Etagen.size();
		for (int i = 0; i < anzahlEtagen; i++) {
			Waende = Etagen.get(i).getMauerwerkswaende();
			anzahlWaende = Waende.size();
			for (int k = 0; k < anzahlWaende; k++) {
				EtagenOeffnungen.addAll(Waende.get(k).getOpenings());
			}
			GebaeudeOeffnungen.addAll(EtagenOeffnungen);
			EtagenOeffnungen.clear();
		}
		return GebaeudeOeffnungen;
	}
	private static int getAllDoors(ArrayList<Opening> alleOeffnungen) {
		int anzahlTueren = 0;
		for (int i = 0; i < alleOeffnungen.size(); i++) {
			Opening O =	alleOeffnungen.get(i);
			if (O instanceof Door) {
				anzahlTueren++;
			}
		}
		return anzahlTueren;
	}
	private static int getAllWindows(ArrayList<Opening> alleOeffnungen) {
		int anzahlFenster = 0;
		for (int i = 0; i < alleOeffnungen.size(); i++) {
			Opening O =	alleOeffnungen.get(i);
			if (O instanceof Window) {
				anzahlFenster++;
			}
		}
		return anzahlFenster;
	}

	private static ArrayList<String> getAlleFestigkeitsklassen(Building Gebaeude) {
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

	private static double computeVolume(Building meinGebaeude, String Betonfestigkeitsklasse) {
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
	}
	


//alles nachher in gebäudeplaner gui speichern!! bauteile und räumliche objekte importieren in gui
//if anweisung wenn die checkbox aktivert ist, dann soll das ausgeführt werden
//nicht drei festigkeitsklassen für drei rundstützen sondern nur für eine
// Arraylist mit alleen festigkeitsklassen für rundstützen, dekcen fundamente, aber nicht festigkeitsklasse 5 mal
//einspeichern sondern gucken ob festigkeitsklasse schon beeinhaltet ist in arraylist, anosnsten nicht
//hinzufügen wenn sie schon drin ist
//für wände arraylist mit mauerwerksdicken im gesamten gebäude, mauerwerksdicke in arraylist enhalten?
//klasse fläche erstellen wo wandfläche ermittelt wird
// dicke abfragen von mauerwerkswand , länge mauerwerkswand und höhe des geschosses gesmates volumen berechnen, openings abziehen
//openings haben auch breite und höhe und erhalten so gesamte wandfläche
// selected checkbox?
//Filewirter festlegen wie gespecihert und wo
//Bufferdwriter = allgemeines (name, anschrift geschosse) if checkbox is selected mit for schleife durchzählen






