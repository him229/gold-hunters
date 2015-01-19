package archeology;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class creates a Map and assigns symbols to each unit on the Map. It also displays the map.
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*
*/ 
public class MapMaker { // print other symbols
	private char charMap[][];
	private char parched;
	private char wet;
	private char natural;
	private char stone;
	private char post;
	private char dirt;
	private boolean dug;
	private int totalRows; 
	private int totalCols;
	String text;
	
	private MapData mapData; 
	
	/**
	 * Constructor 
	 * 
	 */
	public MapMaker()
	{
		parched=' ';
		wet=' ';
		natural=' ';
		stone = ' ';
		post=' ';
		dirt=' ';
		mapData=null;
	}
	/**
	 * @param parched2, wet2, natural2, stone2, post2, dirt2
	 * 
	 */
	public void setMapSymbols(char parched2, char wet2, char natural2, char stone2, char post2, char dirt2)
	{
		parched=parched2;
		wet=wet2;
		natural=natural2;
		stone = stone2;
		post=post2;
		dirt=dirt2;
	}
	
	/**
	 * 
	 * @param newMapData
	 */
	public void setMapData(MapData newMapData) 
	{
		mapData=newMapData;
	}
	
	/**
	 * This method assigns symbols to a square of the map
	 */
	public void makeMap()
	{
		ArrayList<MapNode> mapNodes=mapData.getMapNodes();
		totalRows= mapData.getUserRow(); // difference between set and get and this
		totalCols=mapData.getUserCol();
		charMap = new char[totalCols][totalRows];
		int maxLoop=0;
		maxLoop=mapNodes.size();
		int mapLoop=0;
		int row;
		int col;
		char feature;
		boolean dug;
		char symbol=' ';
		MapNode temp=null;
		for (mapLoop=0;mapLoop<maxLoop;mapLoop++)
		{
			temp=mapNodes.get(mapLoop);
			row=temp.getRow();
			col=temp.getCol();
			feature=temp.getFeature();
			//access finds
			dug=temp.dug;

			switch(feature)
			{
			case 'N':
				if (dug ==false)
					symbol= natural;
				else
					symbol= dirt;
				break;
			case 'P':
				if (dug ==false)
					symbol= wet;
				else
					symbol= post;
				break;
			case 'S':
				if (dug ==false)
					symbol= parched;
				else
					symbol= stone;
				break;
				
			default:
				symbol='?';
				break;
			}
			
			charMap[col][row]=symbol;
			
			}
			
		}

	/**
	 * calls other function
	 * 
	 */
	
	public void process() { 
		makeMap();		
	}
	/**
	 * Assigning default map symbols
	 * 
	 */
	public void setDefaultDisplay()
	{
		setMapSymbols('Y', 'G', 'g', 'R', 'H', 'D');
		process();
		display();
	}
	/**
	 * Assigning user map symbols
	 * 
	 */
	public void setUserDisplay(char ueNatural, char uePit,  char ueStone, char eNatural, char ePit, char eStone)
	{
		
		setMapSymbols(ueStone, uePit, ueNatural, eStone, ePit, eNatural);
		process();
		display();	
		
	}
	/**
	 * 
	 * @param col
	 * @return
	 */
	public String toBase26(int col)
	{
		
		String result=null;
		ArrayList <Integer> tempArray = new ArrayList<Integer>();
		int value=col;
		int modulus=0;
		int iTemp1=0;
		int iTemp2=0;
		char temp=' ';	
		
		
		
		result=new String();
		boolean flag=true;
		

		//Convert from Base 10 to Base 26
		while (flag)
		{
			modulus=value%26;
			value=value/26;
			tempArray.add(modulus);
			if (value<1)
				flag=false;
		}

		//Convert Base 26 to Character SEt 
		int loop=0;
		for (loop=0;loop<tempArray.size();loop++)
		{
			int iTemp3=tempArray.get(loop);

			//If the current character is higher than the first significant column.
			if (loop>0)
			{	temp=(char)('A'+iTemp3-1);

			}
			//Else, we want there to be a blank, not an '@'
			else
			{
				temp=(char)('A'+iTemp3);
			}
			result=temp+result;
			
		}
		
		
		return result;
		
	}
	public String getText(){
		return text;
	}
/**
 *  displaying the map
 */
	public void display() { // get comments on parameters
		// TODO Auto-generated method stub
		//charMap = new char[totalCols][totalRows];
		int row;
		int col;
		int i =0;
		int p=1;
		text = "";
		//System.out.printf("%3s","   ");
		text=text+String.format("%3s","   ");
		for(i=0;i<totalCols;i++)
		{
			//System.out.printf("%3s", toBase26(i));
			text=text+String.format("%3s", toBase26(i));

		}
		//System.out.println();
		text=text+"\n";
		//System.out.printf("%3s","   ");
		
		for(i=0;i<totalCols;i++)
		{
			//System.out.printf("%3s", "=");
			text= text+String.format("%3s", "=");
		}
		//System.out.println();
		text=text+"\n";

		for (row=0;row<totalRows;row++)
		{
			//System.out.printf("%3s", p+"|");
			text=text+String.format("%3s", p+"|");
			p++;//change printing
			for (col=0;col<totalCols;col++)
			{
				//System.out.printf("%3s", charMap[col][row]);
				text = text+String.format("%3s", charMap[col][row]);
			}
			//System.out.println();
			text = text+"\n";
		}
		text = text+"\n";

	}

}
