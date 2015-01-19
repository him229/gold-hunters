package archeology;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class helps the user to add/change features and finds of an element
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class SetFeatures {
	
	Scanner input;
	/**
	 * constructor
	 *  
	 */
	public SetFeatures()
	{
		input= new Scanner(System.in);
	}
	/**
	 * Changes feature for one square
	 *  
	 */
	
	public void oneSquare(MapData md, String col1, int row1, String answer1)
	{
		//System.out.println("Enter the column of the square");
		String userColstr = col1;
		
		int length = userColstr.length();
		int stringLoop=0;
		float power=1;
		int coeff=0;
		char letter=' ';
		int term=0;
		int total=0;
		
		for (stringLoop=length-1;stringLoop>=0;stringLoop--)
		{
			letter=userColstr.charAt(stringLoop);
			coeff=letter-'A'+1;
			term=(int) (coeff*power);
			total=total+term;
			power=power*26;
		}
		int userCol = total-1; //  col number
		
		//System.out.println("Enter the row of the square");
		int userRow = row1-1;//input.nextInt()-1; ... row number
		
		/*System.out.println("Here's a list of the FEATURES. What would you like to set?");
		System.out.println("N. Natural");
		System.out.println("S. Stone");
		System.out.println("P. Pit");*/
		
		char answer= (answer1).charAt(0);// (input.next()).charAt(0)
		
		ArrayList<MapNode> mapNodes = md.getMapNodes();
		int i=0;
		int listLength = mapNodes.size();
		for (i=0;i<listLength;i++)
		{
			MapNode temp = mapNodes.get(i);
			int oneRow = temp.getRow();
			int oneCol= temp.getCol();
			if ((oneRow == userRow) && (oneCol==userCol))
			{
				temp.setFeature(answer);
			}
		}
	}
	/**
	 * 
	 * changes feature for an entire row 
	 */

	public void rowSquare(MapData md, int row1, String answer1)
	{
		//System.out.println("Enter the row");
		int userRow = row1-1;//input.nextInt()-1;
		/*System.out.println("Here's a list of the FEATURES. Please enter the values you would like to set for the entire row.");
		System.out.println("N. Natural");
		System.out.println("P. Stone");
		System.out.println("S. Pit");*/
		
		String answer= answer1;
		ArrayList<MapNode> mapNodes = md.getMapNodes();
		int i=0;
		int j=0;
		int listLength = mapNodes.size();
		for (i=0;i<listLength;i++)
		{
			MapNode temp = mapNodes.get(i);
			int oneRow = temp.getRow();
			if (oneRow == userRow)
			{
				temp.setFeature(answer.charAt(j));
				j++;
			}
		}
		
	}
	public void markHeritage(MapData md, String col1, int row){
		String userColstr = col1;
		
		int length = userColstr.length();
		int stringLoop=0;
		float power=1;
		int coeff=0;
		char letter=' ';
		int term=0;
		int total=0;
		
		for (stringLoop=length-1;stringLoop>=0;stringLoop--)
		{
			letter=userColstr.charAt(stringLoop);
			coeff=letter-'A'+1;
			term=(int) (coeff*power);
			total=total+term;
			power=power*26;
		}
		int userCol = total-1; //  col number
		int userRow = row-1;
		ArrayList<MapNode> mapNodes = md.getMapNodes();
		int i=0;
		int listLength = mapNodes.size();
		for (i=0;i<listLength;i++)
		{
			MapNode temp = mapNodes.get(i);
			int oneRow = temp.getRow();
			int oneCol= temp.getCol();
			if ((oneRow == userRow) && (oneCol==userCol)){
				temp.markHeritage();
			}
		}
	}
	/**
	 * add/changes finds for a square
	 *  
	 */
	@SuppressWarnings("static-access")
	public void setFinds(MapData md, String col1,int row1, String type2, String property2)
	{
		// System.out.println("Enter the column of the square");
		String userColstr = col1;//input.next();
		
		int length = userColstr.length();
		int stringLoop=0;
		float power=1;
		int coeff=0;
		char letter=' ';
		int term=0;
		int total=0;
		
		for (stringLoop=length-1;stringLoop>=0;stringLoop--)
		{
			letter=userColstr.charAt(stringLoop);
			coeff=letter-'A'+1;
			term=(int) (coeff*power);
			total=total+term;
			power=power*26;
		}
		int userCol = total-1; //  col number
		
		//System.out.println("Enter the row of the square");
		int userRow = row1-1;//input.nextInt()-1; row number
		
		/*System.out.println("Here's the list:");
		System.out.println("1. Add Pottery finds");
		System.out.println("2. Add Metal finds");
		System.out.println("3. Add Charcoal finds");
		char answer= (input.next()).charAt(0);
		System.out.println("How many would you like to add?");
		int number = input.nextInt();*/
		
		ArrayList<MapNode> mapNodes = md.getMapNodes();
		int i=0;
		int listLength = mapNodes.size();
		for (i=0;i<listLength;i++)
		{
			MapNode temp = mapNodes.get(i);
			int oneRow = temp.getRow();
			int oneCol= temp.getCol();
			if ((oneRow == userRow) && (oneCol==userCol))
			{
				String[]token=property2.split(",");
				switch(type2)
					{
					case"Pottery Storage":
						//System.out.println("Please Enter a Date");
						int userDatePS = Integer.parseInt(token[0]);//input.nextInt();
						double volume2 = Double.parseDouble(token[1]);
						temp.addStoragePotteryNodes(userDatePS, volume2);
						break;
					case"Pottery Decorated":
						//System.out.println("Please Enter a Date");
						int userDatePD = Integer.parseInt(token[0]);//input.nextInt()
						String dec = token[1];
						temp.addDecoratedPotteryNodes(userDatePD, dec);
						break;
					case"Pottery Submerged":
						//System.out.println("Please Enter a Date");
						int userDatePSu = Integer.parseInt(token[0]);//.nextInt();
						int depth2 = Integer.parseInt(token[1]);
						temp.addSubmergedPotteryNodes(userDatePSu, depth2);
						break;
					case"Charcoal Kilns":
						//System.out.println("Please Enter a Date");
						int userDateCK = Integer.parseInt(token[0]); //.nextInt();
						double radius2 = Double.parseDouble(token[1]);
						temp.addKilnCharcoalNodes(userDateCK, radius2);
						break;
					case"Charcoal Hearths":
						//System.out.println("Please Enter a Date");
						int userDateCH = Integer.parseInt(token[0]);
						double length2 = Double.parseDouble(token[1]);
						double width2 = Double.parseDouble(token[2]);
						temp.addHearthCharcoalNodes(userDateCH, length2, width2);
						break;
					case"Metal Ferrous":
						//System.out.println("Please Enter a Date");
						int userDateMF = Integer.parseInt(token[0]);
						int strength2 = Integer.parseInt(token[1]);
						temp.addFerrousMetalNodes(userDateMF, strength2);
						break;
					case"Metal Non-Ferrous":
						//System.out.println("Please Enter a Date");
						int userDateMN = Integer.parseInt(token[0]);
						String mType = token[1];
						if (mType == ("gold")){
							if ((md.goldCol==-1) && (md.goldRow==-1)){
								md.goldNode = temp;
								md.goldRow= temp.getRow();
								md.goldCol=temp.getCol();
								md.goldDate = userDateMN;
								temp.addNonFerrousMetalNodes(userDateMN, mType);
							}
							
							else{
								int j=0;
								for (j=0;j<listLength;j++)
								{
									MapNode temp2 = mapNodes.get(j);
									int oneRow2 = temp2.getRow();
									int oneCol2= temp2.getCol();
									if ((oneRow2 == md.goldRow) && (oneCol2==md.goldCol))
									{
										for(MetalNode nfm:temp2.metalList){
											NonFerrousMetal gold = new NonFerrousMetal(md.goldDate, "gold");
											NonFerrousMetal Gold = new NonFerrousMetal(md.goldDate, "Gold");
											NonFerrousMetal GOLD = new NonFerrousMetal(md.goldDate, "GOLD");

											if((nfm.equals(gold))||(nfm.equals(Gold))||(nfm.equals(GOLD))){
												temp2.metalList.remove(nfm);
											}
										}
									}
							}
								md.goldNode = temp;
								md.goldRow= temp.getRow();
								md.goldCol=temp.getCol();
								md.goldDate = userDateMN;
								temp.addNonFerrousMetalNodes(userDateMN, mType);
						}
							}
						else{
							temp.addNonFerrousMetalNodes(userDateMN, mType);
					}
						break;
			}

		
			}

		}}}
