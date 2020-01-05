package bachmann.sophie.bauteile;

public abstract class Stahlbetonbauteil implements Volumen {

	public double volumen;
	public static double stahldichte;
	protected String festigkeitsklasse;
	protected double bewehrungsgrad;

	// override überschreibt die im interface angelegten funktionen und macht diese speziell
	@Override
	public double getVolumen() {

		return 0;
	}
	public static void setStahldichte(double dichte) {
		stahldichte = dichte;
	}
	public String getFestigkeitsklasse() {
		return festigkeitsklasse;
	}

	public double zylinderVolumen(double hight, double radius) {
		double zVolumen = 0;
		zVolumen = Math.PI * hight * Math.pow(radius, 2);
		return zVolumen;
	}
	public double kubusVolumen(double height, double width, double length) {
		double kVolumen = 0;
		kVolumen = height * width * length;
		return kVolumen;
	}


}
