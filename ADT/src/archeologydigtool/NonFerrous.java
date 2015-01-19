/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */


package archeologydigtool;

/**
 * NonFerrous extends MetalNode
 * @author karentrevino
 */
public class NonFerrous extends MetalNode{

    private String type;
    
    /**
     * Sets date and type
     * @param date1
     * @param type1
     */
    public NonFerrous(int date1, String type1) {
        super(date1);
        type = type1;
    }
    
    /**
     * Returns type
     * @return
     */
    public String getType(){
        return type;
    }
      
    /**
     * Returns response to metal detector
     * @return
     */
    @Override
    public int respondToMetalDetector(){
        return 4;
    }
}
