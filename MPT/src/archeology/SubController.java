package archeology;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import archeology.MapData;
/**
 * This class creates a SubController to add functionality to the GUI
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class SubController {


		private JTextArea output;
		String text;
		MapData mapData;
		MapMaker mapMaker;
		SetFeatures setFeatures;
		FileTester fileTester;
		String goldCheck = " ";

		public void load(String filename) {
			// TODO Auto-generated method stub
			fileTester = new FileTester();
			fileTester.testFile(filename, mapData);
			mapMaker.setMapData(mapData);
		}

		public void save() {
			// TODO Auto-generated method stub
			SaveMap saveMap = new SaveMap();
			saveMap.writeMap(mapData);
		}

		public void exit() {
			System.exit(0);
		}

		public void setSize() {
			// TODO Auto-generated method stub
					
			
		}

		public void clear() {
			// TODO Auto-generated method stub	

		}	

		
		public void about() {
			// TODO Auto-generated method stub
			text = "";
			text=text+"\n";
			text=text+"=================\n";
			text=text+"Gold Hunters\n";
			text=text+"Himank Yadav - 1000958091\n";
			text=text+"Karen Trevino - 1000908298\n";
			text=text+"Map Population Tool\n";
			text=text+"11/25/14 \n";
			text=text+"Version 0.2\n";
			text=text+"=================\n";
			text=text+"\n";
			JOptionPane.showMessageDialog(null, text);;		

		}

		public void setTextArea(JTextArea textArea) {
			// TODO Auto-generated method stub
			output=textArea;
		}

		public void createMap(String col, String row) {
			// TODO Auto-generated method stub
			int iCol = Integer.parseInt(col);
			int iRow = Integer.parseInt(row);
			mapData.creation(iCol, iRow);
			mapMaker.setMapData(mapData);
			
			//text=output.getText();
			//text=text+"Map Created\n";
			//output.setText(text);

		}

		public void setMapMaker(MapMaker mapMaker2) {
			// TODO Auto-generated method stub
			mapMaker=mapMaker2;
		}
		public void setSetFeatures(SetFeatures setFeatures2) {
			// TODO Auto-generated method stub
			setFeatures = setFeatures2;
		}
		public void setMapData(MapData newMap)
		{
			mapData=newMap;
		}

		public void updateSquareFeature(String col, String row, String answer) {
			// TODO Auto-generated method stub
			int iRow = Integer.parseInt(row);
			setFeatures.oneSquare(mapData, col, iRow, answer);
			
		}

		public void updateRowFeature(String row, String answer1) {
			// TODO Auto-generated method stub
			int iRow = Integer.parseInt(row);
			setFeatures.rowSquare(mapData, iRow, answer1);
		
		}

		public void addFinds(String col, String row, String findType,
				String property) {
			int iRow = Integer.parseInt(row);
			setFeatures.setFinds(mapData, col, iRow, findType, property);
			// TODO Auto-generated method stub
			if (findType==""){
					text="";
			}
			else
				text=findType+" Find Added";
			JOptionPane.showMessageDialog(null, text);			
		}

		public void markHeritage(String col, String row) {
			int row1 = Integer.parseInt(row);
			setFeatures.markHeritage(mapData, col, row1);
			// TODO Auto-generated method stub
			
			text="Heritage Marked on "+col+row+ "\n";
			JOptionPane.showMessageDialog(null, text);			
		}

		public void setFileTester(FileTester fileTester2) {
			fileTester = fileTester2;
			// TODO Auto-generated method stub
			
		}

		public void sameSymbol() {
			// TODO Auto-generated method stub
			mapMaker.setDefaultDisplay();
			String text2 = mapMaker.getText();
			text=output.getText();
			text=text+text2;
			output.setText(text);
		}

		public void updateSymbol(String dNatural, String dPit, String dStone, String uNatural, String uPit, String uStone) {
			char dPit2=dPit.charAt(0);
			char dStone2=dStone.charAt(0);
			char dNatural2=dNatural.charAt(0);
			char uNatural2=uNatural.charAt(0);
			char uPit2=uPit.charAt(0);
			char uStone2=uStone.charAt(0);
			
			mapMaker.setUserDisplay(uNatural2, uPit2, uStone2, dNatural2, dPit2, dStone2);
			String text2 = mapMaker.getText();
			text=output.getText();
			text=text+text2;
			output.setText(text);
		}

}
