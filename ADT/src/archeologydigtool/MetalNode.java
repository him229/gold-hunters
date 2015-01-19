/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;

/**
 * MetalNode contains instance variables of a metal node
 * @author karentrevino
 */
public abstract class MetalNode implements Comparable<MetalNode> {
    
    int date;
    int row;
    int col;
    
    /**
     * Constructor class sets metal node date
     * @param date1
     */
    public MetalNode(int date1){
        date = date1;
    }
    
    /**
     * Sets row and col
     * @param row1
     * @param col1
     */
    public void setRowCol(int row1, int col1){
        row = row1;
        col = col1;
    }
    
    /**
     * Return date
     * @return
     */
    public int getDate(){
        return date;
    }

    /**
     * Returns row
     * @return
     */
    public int getRow(){
        return row;
    }

    /**
     * Returns col
     * @return
     */
    public int getCol(){
        return col;
    }
    
    @Override
    public int compareTo(MetalNode arg0) {
            // TODO Auto-generated method stub

            int iResult=0;

            if (this.getDate()==arg0.getDate())
            {
                    iResult=0;
            }
            else if (this.getDate()>arg0.getDate())
            {
                    iResult=1;
            }
            else if (this.getDate()<arg0.getDate())
            {
                    iResult=-1;
            }


            return iResult;
    }

    
    abstract int respondToMetalDetector();
    
}
