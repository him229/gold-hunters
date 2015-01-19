package archeology;
/**
 * This class adds a Non Ferrous Metal
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class NonFerrousMetal extends MetalNode {

	private String type;
	public NonFerrousMetal(int date2, String type3) {
		super(date2);
		type = type3;
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	@Override
	public int respondToMetalDetector() {
		// TODO Auto-generated method stub
		return 4;
	}
}