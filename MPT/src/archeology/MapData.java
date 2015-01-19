package archeology;
	
	import java.util.ArrayList;
	import java.io.File;
	import java.util.Scanner;
	/**
	 * This class helps extract data from the input source and create a map
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
	*/ 	
	
	public class MapData {
		ArrayList <MapNode> mapNodeList = new ArrayList<MapNode>();
		private int userCol;
		public static int goldRow;
		public static int goldCol;
		public static int goldDate;
		public static MapNode goldNode;
		int rowMax;
		int colMax;

		
		public int getRowMax() {
			return rowMax;
		}
		public void setRowMax(int rowMax) {
			this.rowMax = rowMax;
		}
		public int getColMax() {
			return colMax;
		}
		public void setColMax(int colMax) {
			this.colMax = colMax;
		}
		public MapData(){
			goldRow = -1;
			goldCol = -1;
			goldNode=null;
			goldDate=-1;
		}
		public void setMapNodeList(ArrayList<MapNode> mapNodeList) {
			this.mapNodeList = mapNodeList;
		}

		public void setUserCol(int userCol) {
			this.userCol = userCol;
		}

		public void setUserRow(int userRow) {
			this.userRow = userRow;
		}
		private int userRow;
	
		/**
		 * This method creates a new map
		 * 
		 */
		
		public void creation(int col, int row)
		{			
			userRow = row;
			this.setRowMax(userRow);
			userCol = col;
			this.setColMax(userRow);
			//close input
			int colLoop;
			int rowLoop = colLoop = 0;
			for(rowLoop=0;rowLoop<userRow;rowLoop++)
			{
				for(colLoop=0;colLoop<userCol;colLoop++)
				{
					MapNode newNode=new MapNode(rowLoop,colLoop,'N',false, false);
					mapNodeList.add(newNode);
				}
			}
			}		

	/**
	 * 
	 * @return
	 */
		/**
		 * 
		 * @return mapNodeList - ArrayList of MapNodes
		 */
	public ArrayList<MapNode> getMapNodes() {
		return mapNodeList;
	}
	/**
	 * 
	 * @return userRow - Total number of rows in the map
	 */
	public int getUserRow() {
		return userRow;
	}
	/**
	 * 
	 * @return userCol - Total number of colums in the map
	 */
	public int getUserCol() {
		return userCol;
	}
	public static int stringToInt(String data)
	{		
		int length=data.length();
		
		
		int stringLoop=0;
		float power=1;
		int coeff=0;
		char letter=' ';
		int term=0;
		int total=0;
		
		for (stringLoop=length-1;stringLoop>=0;stringLoop--)
		{
			letter=data.charAt(stringLoop);
			coeff=letter-'A'+1;
			term=(int) (coeff*power);
			total=total+term;
			power=power*26;
		}
		return (total-1);
		
	}
	

}
	
	
	
