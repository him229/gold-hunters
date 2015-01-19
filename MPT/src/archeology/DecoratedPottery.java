package archeology;

/**
 * This class adds a Decorated Pottery
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class DecoratedPottery extends PotteryNode {
	private String describe;

	public DecoratedPottery(int date2, String describe2) {
		super(date2);
		describe = describe2;
		// TODO Auto-generated constructor stub
	}
	/**
	 * returns describe
	 */
	public String getDescribe() {
		return describe;
	}
	public String getType() {
		return "DecoratedPottery";
	}

}
