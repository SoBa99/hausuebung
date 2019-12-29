package bachmann.sophie.hausuebung;

import bachmann.sophie.raeumlicheObjekte.*;
import bachmann.sophie.bauteile.*;
import bachmann.sophie.gUI.*;

public class Bauprojekt {

	public static void main(String[] args) {
		/*-------Instanziierung-------*/ 
		Stahlbetonbauteil.setStahldichte(7.85);
		
		// Gebäude
		Building Gebaeude = new Building("", "Sophie", "Bachmann", 
				"Unistraße", 353 , "66915", "Kassel");
		Geschoss EG = new Geschoss("EG", 2.72, false);
		
		// Fundamente
		Bodenplatte Bp = new Bodenplatte(0.16, 0.01, "C20/25", 8.09, 9.52);
		Einzelfundament E1 = new Einzelfundament(0.44, 0.01, "C20/25", 0.6);
		Einzelfundament E2 = new Einzelfundament(0.44, 0.01, "C20/25", 0.6);
		Einzelfundament E3 = new Einzelfundament(0.44, 0.01, "C20/25", 0.6);
		
		//Stützen
		Rundstuetze R1 = new Rundstuetze("C25/30", 0.05, 0.25);
		Rundstuetze R2 = new Rundstuetze("C25/30", 0.05, 0.25);
		Rundstuetze R3 = new Rundstuetze("C25/30", 0.05, 0.25);
		
		// Wände
		Mauerwerkswand AWnord = new Mauerwerkswand(0.4, 8.09);
		Mauerwerkswand AWost = new Mauerwerkswand(0.4, 8.72);
		Mauerwerkswand AWsued = new Mauerwerkswand(0.4, 8.09);
		Mauerwerkswand AWwest = new Mauerwerkswand(0.4, 8.72);
		Mauerwerkswand IW34 = new Mauerwerkswand(0.24, 4.36);  // Wand zwischen Schlafen und Wohnen
		Mauerwerkswand IW45 = new Mauerwerkswand(0.24, 2.56);  // Wand zwischen Schlafen und Bad
		Mauerwerkswand IW234 = new Mauerwerkswand(0.24, 2.78 );  // Wand zwischen Schlafen, Küche und Wohnen
		Mauerwerkswand IW25 = new Mauerwerkswand(0.24, 2.93);  // Wand zwischen Bad und Küche
		Mauerwerkswand IW12 = new Mauerwerkswand(0.24, 2.93);  // Wand zwischen Küche und Flur
		Mauerwerkswand IW13 = new Mauerwerkswand(0.24, 2.9);  // Wand zwischen Wohnen und Flur
		
		// Decke
		Slab Decke = new Slab("C20/25", 0.03, 12.49, 9.52, 0.18);
		
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
		
		
	}
}
