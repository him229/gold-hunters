package archeology;
/**
 * This class creates a Node which stores the date for a find
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class PotteryNode {
	private int date;
/**
 * This method adds Pottery nodes 
 * @param int date2 - the date to be added
 * @return void
*/ 
	public PotteryNode(int date2) {
		date = date2;
	}
	/**
	 * This method returns the date
	 * 
	 * @return date
	*/ 
	public int getDate() {
		return date;
	}
}
