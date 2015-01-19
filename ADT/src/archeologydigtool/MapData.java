/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;


import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * MapData holds and creates myMap
 * @author karentrevino
 */
public class MapData {
    private int numRows; // number of rows in map
    private int numCols; // number of columns in map
    private ArrayList<TileComponent> myMap;
    private  FileTester fileTester;
    
    /** 
     * Instantiates numRows, numCols, and myMap
     */
    public MapData()
    {
       numRows = 0;
       numCols = 0;
       myMap = null;
    }
    
    /**
     * Asks user for input file and creates ArrayList myMap that holds all 
     * squares created from text file if it exists
     * Sets numRows and numCols equal to size of map
     * 
     * @param fileName
     */
    public void load(String fileName, JPanel panel, SubController subcontroller){
        
        myMap = new ArrayList<>();
    
        fileTester=new FileTester();
	fileTester.testFile(fileName, this, panel, subcontroller);
    }
    
    /**
     * @Author Dr.Eric Becker
     * @param data
     * @return total - 1 : integer rep. of column
     */
    public static int stringToInt(String data){    // used from Becker
    
        // Converts a string such as "AA" to a designated row number
        int length=data.length();

        int stringLoop;
        float power = 1;
        int coeff ;
        char letter;
        int term;
        int total = 0;

        for (stringLoop=length-1;stringLoop>=0;stringLoop--)
        {
            letter=data.charAt(stringLoop);
            coeff=letter-'A'+1;
            term=(int) (coeff*power);
            total=total+term;
            power=power*26;
        }
        //System.out.println(total-1);
        return total - 1;
    }

    /**
     * Get myMap
     * @return ArrayList<MapNode>, arraylist of mapnodes
     */
    public ArrayList<TileComponent> getMap(){
            return myMap;
    }
    
    /**
     * Return num rows
     * @return
     */
    public int getNumRows(){
        return numRows;
    }
    
    /**
     * Return num cols
     * @return
     */
    public int getNumCols(){
        return numCols;
    }
    
    /**
     * Set num rows
     * @param num
     */
    public void setNumRows(int num){
        numRows = num;
    }
    
    /**
     * set num cols
     * @param num
     */
    public void setNumCols(int num){
        numCols = num;
    }
}
    
