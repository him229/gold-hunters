package gui;
/**
 * This class is the data storage place for AddFinds Dialogue
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class DataAddFinds {
	
		private String row;
		private String col;
		private String findType;
		private String property;
		
		public DataAddFinds()
		{
			setRow(new String(""));
			setCol(new String(""));
			setFindType(new String(""));
			setProperty(new String(""));
			
		}

		public String getRow() {
			return row;
		}

		public void setRow(String row) {
			this.row = row;
		}

		public String getCol() {
			return col;
		}

		public void setCol(String col) {
			this.col = col;
		}

		public String getProperty() {
			return property;
		}

		public void setProperty(String property) {
			this.property = property;
		}

		public String getFindType() {
			return findType;
		}

		public void setFindType(String findType) {
			this.findType = findType;
		}

}
