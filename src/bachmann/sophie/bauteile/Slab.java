package bachmann.sophie.bauteile;

import java.util.ArrayList;

public class Slab extends Stahlbetonbauteil {

	// private variables
	private double width;
	private double length;
	private double height;
	private ArrayList<Opening> openings = new ArrayList<>();

	// constructor
	public Slab (double width, double length, double height, double stahldichte, String festigkeitsklasse, double bewehrungsgrad) {
		super(stahldichte, festigkeitsklasse, bewehrungsgrad);
		this.setWidth(width);
		this.setLength(length);
		this.setHeight(height);
	}

	// assoziation
	public ArrayList<Opening> getOpenings() {
		return openings;
	}
	public void addOpening(Opening opening) {
		openings.add(opening);
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	// Festigkeitsklasse
	@Override
	public double getVolumen() {
		return this.width*this.length*this.height;
	}

	@Override
	public String getFestigkeitsklasse() {
		return this.festigkeitsklasse;
	}
	// Bewehrungsgrad
	@Override
	public double getBewehrungsgrad() {
		return this.bewehrungsgrad;
	}
	@Override
	public double getBewehrungsmenge_in_t() {
		return getVolumen() * bewehrungsgrad;
	}
}
