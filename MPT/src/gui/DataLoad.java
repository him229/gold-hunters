package gui;
/**
 * This class is the data storage place for LoadDialogue
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class DataLoad 
{
	private String filename;

	
	public DataLoad()
	{
		setFilename(new String(""));
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}

}