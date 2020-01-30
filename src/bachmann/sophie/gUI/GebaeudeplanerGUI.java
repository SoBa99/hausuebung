package bachmann.sophie.gUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import bachmann.sophie.bauteile.*;
import bachmann.sophie.raeumlicheObjekte.Building;
import bachmann.sophie.raeumlicheObjekte.Geschoss;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GebaeudeplanerGUI {

	private JFrame frmGebäudeplaner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GebaeudeplanerGUI window = new GebaeudeplanerGUI();
					window.frmGebäudeplaner.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GebaeudeplanerGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmGebäudeplaner = new JFrame();
		frmGebäudeplaner.setTitle("Gebäudeplaner");
		frmGebäudeplaner.setBounds(100, 100, 327, 266);
		frmGebäudeplaner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGebäudeplaner.getContentPane().setLayout(null);

		JLabel lblGebudeplaner = new JLabel("Gebäudeplaner");
		lblGebudeplaner.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGebudeplaner.setBounds(97, 20, 152, 16);
		frmGebäudeplaner.getContentPane().add(lblGebudeplaner);

		JLabel lblNewLabel = new JLabel("Ausgabeumfang");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(16, 59, 108, 16);
		frmGebäudeplaner.getContentPane().add(lblNewLabel);

		JCheckBox chckbxSeitlicheWandflche = new JCheckBox("Seitliche Wandfläche");
		chckbxSeitlicheWandflche.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxSeitlicheWandflche.setBounds(6, 87, 170, 23);
		frmGebäudeplaner.getContentPane().add(chckbxSeitlicheWandflche);

		JCheckBox chckbxBetonUndBewehrungsmenge_1 = new JCheckBox("Beton- und Bewehrungsmenge");
		chckbxBetonUndBewehrungsmenge_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxBetonUndBewehrungsmenge_1.setBounds(6, 122, 224, 23);
		frmGebäudeplaner.getContentPane().add(chckbxBetonUndBewehrungsmenge_1);

		JCheckBox chckbxFensterUndTranzahl = new JCheckBox("Fenster- und Türanzahl");
		chckbxFensterUndTranzahl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxFensterUndTranzahl.setBounds(6, 157, 189, 23);
		frmGebäudeplaner.getContentPane().add(chckbxFensterUndTranzahl);

		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnBeenden.setBounds(204, 209, 117, 29);
		frmGebäudeplaner.getContentPane().add(btnBeenden);

		JButton btnBerichtErstellen = new JButton("Bericht erstellen");
		btnBerichtErstellen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBerichtErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btnBerichtErstellen.setBounds(61, 209, 153, 29);
		frmGebäudeplaner.getContentPane().add(btnBerichtErstellen);
		
		Writer fileWriter = new FileWriter("data\\file.writer.txt");
		BufferedWriter buffer = new BufferedWriter(fileWriter);


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

		/*-------Instanziierung-------*/
		Stahlbetonbauteil.setStahldichte(7.85);
		  {
		
		}
	    //Mauerwerkswanddicken und -flächen
		if(chckbxSeitlicheWandflche.isSelected()) {
			fileWriter.write("vorhandene Mauerwerkswanddicken: " );
			ArrayList<Double> dicki;
			dicki = Mauerwerkswand.getAlleMauerwerkswanddicken(Gebaeude);
			for (int i = 0; i < dicki.size(); i++) { fileWriter.write(String.valueOf(dicki.get(i)));
			fileWriter.write("Wandfläche " + String.valueOf(dicki.get(i)) + "er Mauerwerk: ");
			for (int k = 0; k < dicki.size(); k++) {
				fileWriter.write((dicki.get(k) + ": " + Mauerwerkswand.mauerwerkswandFlächen(Gebaeude, dicki.get(k))));
			}}
			}
		//Text Festigkeitsklassen und Bewehrungsmenge
		if(chckbxBetonUndBewehrungsmenge_1.isSelected()) {
			fileWriter.write("vorhandene Betonfestigkeitsklassen: " );
			ArrayList<String> festi;
			festi = Stahlbetonbauteil.getAlleFestigkeitsklassen(Gebaeude);
			for ( int i = 0; i < festi.size(); i++) { fileWriter.write(String.valueOf(festi.get(i)));
			fileWriter.write("Betonmenge: " + String.valueOf(festi.get(i)) + " ");
			for ( int k = 0; k < festi.size(); k++) {
				fileWriter.write((festi.get(k) + ": " + Stahlbetonbauteil.computeVolume(Gebaeude, festi.get(i))));
			}
			}
		}
		//Text Türen und Fenster
		if(chckbxFensterUndTranzahl.isSelected()) {
			fileWriter.write("Türen: " + getAllDoors(getAllOpenings(Gebaeude)));
			fileWriter.write("Fenster: " + getAllWindows(getAllOpenings(Gebaeude)));
		}

		// Test nachher wieder rauslösschen
		System.out.println("Anzahl Öffnungen: " + getAllOpenings(Gebaeude).size());
		System.out.println("Anzahl Türen: " + getAllDoors(getAllOpenings(Gebaeude)));
		System.out.println("Anzahl Fenster: " + getAllWindows(getAllOpenings(Gebaeude)));
		ArrayList<String> festi;
		festi = Stahlbetonbauteil.getAlleFestigkeitsklassen(Gebaeude);
		System.out.println("Verwendete Festigkeitsklassen: ");
		for (int i = 0; i <  festi.size(); i++) {
			System.out.println(festi.get(i) + " ");
		}
		System.out.println("Verwendetes Betonvolumen pro Festigkeitsklasse: ");
		for (int i = 0; i <  festi.size(); i++) {
			System.out.println(festi.get(i) + ": " + Stahlbetonbauteil.computeVolume(Gebaeude, festi.get(i)));
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
		}}


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
	}}



//alles nachher in gebäudeplaner gui speichern!! bauteile und räumliche objekte importieren in gui
//if anweisung wenn die checkbox aktivert ist, dann soll das ausgeführt werden
//selected checkbox?
//Filewirter festlegen wie gespecihert und wo
//Bufferdwriter = allgemeines (name, anschrift geschosse) if checkbox is selected mit for schleife durchzählen

