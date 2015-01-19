/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;
/**
 * Class holds row and col from GUI input
 * @author karentrevino
 */
public class DataSquare {
    private int row;
    private int col;
    
    /**
     * Sets row
     * @param row1
     */
    public void setRow(int row1){
        row = row1;
    }

    /**
     * Sets column
     * @param col1
     */
    public void setCol(int col1){
        col = col1;
    }
    
    /**
     * Returns row
     * @return
     */
    public int getRow(){
        return row;
    }
    
    /**
     * Returns column
     * @return
     */
    public int getCol(){
        return col;
    }
}
