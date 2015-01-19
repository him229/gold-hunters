package archeology;
/**
 * This class adds a storage pottery
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class StoragePottery extends PotteryNode {
	private double volume;

	public StoragePottery(int date2, double volume2) {
		super(date2);
		volume = volume2;
		// TODO Auto-generated constructor stub
	}

	public double getVolume() {
		return volume;
	}
	public String getType() {
		return "StoragePottery";
	}

}
