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
public class Decorated extends PotteryNode{

    private String description;
    
    /**
     * Function sets date and description
     * @param date1
     * @param description1
     */
    public Decorated(int date1,String description1) {
        super(date1);
        description = description1;
    }
 
    /**
     * Returns description
     * @return
     */
    public String getString(){
        
        return description;
    }
    
    /**
     * Returns a respnse to metal detector
     * @return
     */
    @Override
    public int respondToMetalDetector(){
        return 0;
    }
}
