package archeology;
/**
 * This class creates a Submerged Pottery
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class SubmergedPottery extends PotteryNode {
	private int depth;

	public SubmergedPottery(int date2, int depth2) {
		super(date2);
		depth = depth2;
		// TODO Auto-generated constructor stub
	}

	public double getDepth() {
		return depth;
	}
	public String getType() {
		return "SubmergedPottery";
	}

}
