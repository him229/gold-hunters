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
public class Kiln extends CharcoalNode{

    private double radius;
    
    /**
     * Sets date and radius
     * @param date1
     * @param radius1
     */
    public Kiln(int date1, double radius1){
        super(date1);
        radius = radius1;
    }
    
    /**
     * Returns radius
     * @return
     */
    public double getRadius(){
        
        return radius;
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
