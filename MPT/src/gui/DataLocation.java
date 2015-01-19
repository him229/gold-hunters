package gui;
/**
 * This class is the data storage place for LocationDialogue
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class DataLocation 
{
	private String row;
	private String col;
	
	public DataLocation()
	{
		setRow(new String(""));
		setCol(new String(""));
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

}