package archeology;
/**
 * This class adds a ferrous metal
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class FerrousMetal extends MetalNode {
	private int strength;

	public FerrousMetal(int date2, int strength2) {
		super(date2);
		strength = strength2;
		// TODO Auto-generated constructor stub
	}

	public int getStrength() {
		return strength;
	}

	@Override
	public int respondToMetalDetector() {
		// TODO Auto-generated method stub
		return 2;
	}
	public String getType() {
		return "FerrousMetal";
	}

}
