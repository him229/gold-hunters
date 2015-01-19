/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */


package archeologydigtool;

/**
 * Class extends CharcoalNode
 * @author karentrevino
 */
public class Hearth extends CharcoalNode{

    private double length;
    private double width;
    
    /**
     * Function sets date, length and width
     * @param date1
     * @param length1
     * @param width1
     */
    public Hearth(int date1, double length1, double width1) {
        super(date1);
        length = length1;
        width = width1;
    }
    
    /**
     * Returns length
     * @return
     */
    public double getLength(){
        
        return length;
    }
    
    /**
     * Returns width
     * @return
     */
    public double getWidth(){
        
        return width;
    }
    
    /**
     * Returns response to metal detector
     * @return
     */
    @Override
    public int respondToMetalDetector(){
        return 0;
    }
    
}
