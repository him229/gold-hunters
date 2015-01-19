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
public class Storage extends PotteryNode{

    private double volume;
    
    /**
     * Function sets date and volume
     * @param date1
     * @param volume1
     */
    public Storage(int date1,double volume1)  {
        super(date1);
        volume = volume1;
    }

    /**
     * Returns volume
     * @return
     */
    public double getVolume(){
        
        return volume;
    }
    
    /**
     * Sets volume
     * @param volume1
     */
    public void setVolume(double volume1){
        volume = volume1;
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
