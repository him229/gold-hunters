/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */


package archeologydigtool;

/**
 * Take square from user to scan with magnetometer or metal detector
 * @author karentrevino
 */
public class ScanMap {
    
    private String text;
    
    
    /**
     * User inputs which square is to be scanned and which tool to use
     * The node's metal detector or magnetometer is changed to true
     * @param mapData
     * @param row
     * @param col
     * @param menuInput
     */
    public static void process(TileComponent mapNode, int menuInput){
                
        //tool 1) Magnetometer 2)Metal Detector 3)Visible Spectrum

   
        if(menuInput == 1)
            mapNode.setMagnetometer(true);
        else if(menuInput == 2){
            mapNode.setMetalDetector(true);
            
                
                //System.out.printf("Nonferrous: %d  ferrous: %d\n", responseNonFerrous, responseFerrous);

            }
            
            
        
    }
    
    /**
     * Square input from user is converted to integers
     * @param line
     */
    public void sqrInputConversion(String line){
        
        
        String colString = "";
        String rowString = "";
        int i;

        for(i = 0; i <line.length(); i++ )
        {
            if(Character.isLetter(line.charAt(i)))
                colString = colString + line.charAt(i);
            else
                break;
        }

        for(;i < line.length(); i++)
        {
            rowString = rowString + line.charAt(i);
        }
        //row = Integer.parseInt(rowString) - 1;
        //col = MapData.stringToInt(colString);  
       
    }
    
    /**
     * Returns text
     * @return
     */

    
}
