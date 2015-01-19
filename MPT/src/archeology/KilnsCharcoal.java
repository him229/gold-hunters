package archeology;
/**
 * This class adds a Kiln Charcoal
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class KilnsCharcoal extends CharcoalNode {
	
	private double radius;

	public KilnsCharcoal(int date2, double radius2) {
		super(date2);
		radius = radius2;
		// TODO Auto-generated constructor stub
	}

	public double getRadius() {
		return radius;
	}
	public String getType() {
		return "KilnsCharcoal";
	}

}
