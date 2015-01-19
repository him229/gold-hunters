package archeology;

import gui.MainFrame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

/**
 * This class saves the Map Data on a text file
 * Inspired by Dr. Becker's Mary Ellen Carter 09/15/14
*@author himankyadav
*Himank Yadav
*UTA ID - 1000958091
*Date - 11.25.14
*
*/ 

public class SaveMap {
	/**
	 * 
	 * @param col
	 * @return
	 */
	File fl;
	String finalStr;
	MainFrame parent;
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
	/**
	 * writes the map data to a text file
	 *  
	 */
	public void writeMap(MapData mapData)
	{
		try
		{
		ArrayList<MapNode> mn = mapData.getMapNodes();
		JFileChooser fileChooser = new JFileChooser();
		int userSelection = fileChooser.showSaveDialog(parent);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    fl = new File(fileChooser.getSelectedFile()+".csv");
		    
		// = new File("MapOutput.txt");
		FileWriter vmfw = new FileWriter(fl);
		BufferedWriter fbw = new BufferedWriter(vmfw);
		int tr = mapData.getUserRow();
		int tc = mapData.getUserCol();
		
		String td  = tc+","+tr+"\n";
		System.out.println(td);
		fbw.append(td);
		int i=0;
		int j=0;
		for(i=0;i<mn.size();i++){
			MapNode temp = mn.get(i);
			ArrayList<PotteryNode> pn = temp.getPotteryNodes();
			ArrayList<MetalNode> men = temp.getMetalNodes();
			ArrayList<CharcoalNode> cn = temp.getCharcoalNodes();
			j=0;
			String menStr;
			String cnStr;
			String pnStr=menStr=cnStr="";
			for(j=0;j<pn.size();j++)
			{
				String pnStr1 = Integer.toString(pn.get(j).getDate());
				//pn.get(j).get;
				pnStr = pnStr + pnStr1 + ',';
			}
			j=0;
			for(j=0;j<men.size();j++)
			{
				String menStr1 = Integer.toString(men.get(j).getDate());
				menStr = menStr + menStr1 + ',';
			}
			j=0;
			for(j=0;j<cn.size();j++)
			{
				String cnStr1 = Integer.toString(cn.get(j).getDate());
				cnStr = cnStr + cnStr1 + ',';
			}
			String colc = toBase26(temp.getCol());
			String dugs = "";
			if(temp.getDug()==false)
			{
				dugs = "FALSE";
			}
			else
			{
				dugs = "TRUE";
			}
			String hers="";
			if(temp.getHeritage()==false)
			{
				hers = "FALSE";
			}
			else
			{
				hers = "TRUE";
			}
			
			finalStr = colc+","+Integer.toString(temp.getRow())+','+temp.getFeature()+','+dugs+','+hers+','+Integer.toString(pn.size())+','+pnStr+Integer.toString(cn.size())+","+cnStr+Integer.toString(men.size())+','+menStr;
			finalStr = finalStr.substring(0,finalStr.length()-1);
			finalStr=finalStr+"\n";
			System.out.println(finalStr);
			fbw.append(finalStr);
		}
		fbw.close();
		}}

		catch(IOException ex){
            
        }

		
	}
	
	public void setParent(MainFrame parent1){
		parent = parent1 ;
	}

}
