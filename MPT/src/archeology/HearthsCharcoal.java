package archeology;
/**
 * This class 
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class HearthsCharcoal extends CharcoalNode {

	private double length;
	private double width;
	public HearthsCharcoal(int date2, double length2, double width2) {
		super(date2);
		length = length2;
		width=width2;
		// TODO Auto-generated constructor stub
	}
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}	
	{
	super.setType("HearthsCharcoal");}

}
