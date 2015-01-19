/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */


package archeologydigtool;

/**
 * Ferrous extends MetalNode
 * @author karentrevino
 */
public class Ferrous extends MetalNode{

    private int signalStrength;
    
    /**
     * Sets date and signal strength
     * @param date1
     * @param signalStrength1
     */
    public Ferrous(int date1, int signalStrength1) {
        super(date1);
        signalStrength = signalStrength1;
    }
    
    /**
     * Returns signal strength
     * @return
     */
    public int getSignalStrength(){
        
        return signalStrength;
    }
    
    /**
     * Returns response to metal detector
     * @return
     */
    @Override
    public int respondToMetalDetector(){
        return 2;
    }
    
}
