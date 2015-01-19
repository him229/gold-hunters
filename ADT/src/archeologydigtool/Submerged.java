/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */


package archeologydigtool;

/**
 * This class extends PotteryNode that will be part of Pottery ArrayList
 * @author karentrevino
 */
public class Submerged extends PotteryNode{

    private int depth;
    
    /**
     * Function sets date and depth
     * @param date1
     * @param depth1
     */
    public Submerged(int date1, int depth1) {
        super(date1);
        depth = depth1;
    }
    
    /**
     * Returns depth
     * @return
     */
    public double getDepth(){
        
        return depth;
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
