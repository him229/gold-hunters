/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */
package archeologydigtool;

/**
 * Holds data for Load GUI
 * @author karentrevino
 */
public class DataLoad 
{
    private String filename;

    /**
     * Instantiates filename
     */
    public DataLoad()
    {
            filename=new String("");
    }
    
    /**
     * Returns filename
     * @return
     */
    public String getFilename(){
        return filename;
    }
    
    /**
     * Sets filename
     * @param name
     */
    public void setFilename(String name){
        filename = name;
    }

}
