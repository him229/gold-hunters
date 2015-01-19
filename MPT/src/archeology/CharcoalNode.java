package archeology;
/**
 * This class creates a Node which stores the date for a find
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class CharcoalNode {
 private int date;
 String type;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
/**
 * @param int date2 - the date to be added
 * @return void
*/ 
	public CharcoalNode(int date2)
	{
		date=date2;
	}
	/**
	 * 
	 * @return date
	*/ 
	public int getDate() {
		return date;
		// TODO Auto-generated constructor stub
	}

}
