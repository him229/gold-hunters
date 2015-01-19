package archeology;
/**
 * This class creates a Node which stores the date for a find
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public abstract class MetalNode {
	private int date;
	/**
	 * This method adds charcoal nodes 
	 * @param int date2 - the date to be added
	 * @return void
	*/ 
	public MetalNode(int date2)
	{
		date=date2;
	}
	public abstract int respondToMetalDetector();
	/**
	 * This method returns date
	 * 
	 * @return date
	*/ 
	public int getDate() {
		return date;
		// TODO Auto-generated constructor stub
	}

}
