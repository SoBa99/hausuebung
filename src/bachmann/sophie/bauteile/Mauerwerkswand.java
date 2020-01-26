package bachmann.sophie.bauteile;


import java.util.ArrayList;

import bachmann.sophie.raeumlicheObjekte.Building;
import bachmann.sophie.raeumlicheObjekte.Geschoss;

public class Mauerwerkswand implements Wandflaeche{

	// private variables
	private double dicke;
	private double laenge;
	private Geschoss geschoss;
	private ArrayList<Opening> openings = new ArrayList<Opening>();

	// constructor
	public Mauerwerkswand (double dicke, double laenge, Geschoss geschoss, double hoehe) {
		this.setDicke(dicke);
		this.setLaenge(laenge);

	}
	// assoziation
	public ArrayList<Opening> getOpenings() {
		return openings;
	}
	public void addOpening(Opening opening) {
		openings.add(opening);
	}
	public Double getDicke() {
		return dicke;
	}
	public void setDicke(double dicke) {
		this.dicke = dicke;
	}
	public double getLaenge() {
		return laenge;
	}
	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}
	public Geschoss getGeschoss() {
		return geschoss;
	}
	public void setGeschoss(Geschoss geschoss) {
		this.geschoss = geschoss;
	}
	
	@Override
	public double getFlaeche() {
		double b = this.laenge * this.geschoss.getHoehe();
		return b;
	}

	//Mauerwerkswanddicken
	public static ArrayList<Double> getAlleMauerwerkswanddicken(Building Gebaeude) {
		ArrayList<Geschoss> geschosse = new ArrayList<Geschoss>();
		ArrayList<Double> dicken = new ArrayList<Double>();
		geschosse = Gebaeude.getGeschosse();
		for (int i = 0; i < geschosse.size(); i++) {
			if(dicken.isEmpty()) {
				dicken.add(geschosse.get(i).getMauerwerkswaende().get(i).getDicke());
			}
			for (int k = 0; k < geschosse.get(i).getMauerwerkswaende().size(); k++) {
				for(double d: dicken) {
					if(!dicken.contains(geschosse.get(i).getMauerwerkswaende().get(k).getDicke())) {
						dicken.add(geschosse.get(i).getMauerwerkswaende().get(k).getDicke());
						break;
					}
				}
			}
		}
		return dicken; }


	//Mauerwerkswandflächen
	public static double mauerwerkswandFlächen(Building Gebaeude, Double dicke) {
		ArrayList<Geschoss> geschosse = new ArrayList<Geschoss>();
		geschosse = Gebaeude.getGeschosse();
		double flaeche = 0;

		for (int i = 0; i < geschosse.size(); i++) {
			for (int k = 0; k <geschosse.get(i).getMauerwerkswaende().size(); k++) {
				if(geschosse.get(i).getMauerwerkswaende().get(k).getDicke().equals(dicke)) {
					flaeche+= (geschosse.get(i).getMauerwerkswaende().get(k).getFlaeche()); 
				}
			}
		}
		return flaeche;
		}
	}

