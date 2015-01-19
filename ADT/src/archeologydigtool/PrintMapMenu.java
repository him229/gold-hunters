/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
/**
 *
 * @author karentrevino
 */
public class PrintMapMenu {
    
    //private MapData mapData;
    private ArrayList<TileComponent> myMap;
    BufferedImage undugNatImage=null;
    BufferedImage dugNatImage=null;
    BufferedImage undugPitImage=null;
    BufferedImage dugPitImage=null;
    BufferedImage undugStoneImage=null;
    BufferedImage dugStoneImage=null;
    BufferedImage zeroImage=null;
    BufferedImage oneImage=null;
    BufferedImage twoImage = null;
    BufferedImage threeImage = null;
    BufferedImage fourImage = null;
    BufferedImage fiveImage = null;
    BufferedImage sixImage = null;
    BufferedImage sevenImage = null;
    BufferedImage eightImage = null;
    BufferedImage nineImage = null;
    BufferedImage falseImage = null;
    BufferedImage trueImage = null;
    BufferedImage unknownImage = null;

    File undugNatFile=null;
    File dugNatFile=null;
    File undugPitFile=null;
    File dugPitFile=null;
    File undugStoneFile=null;
    File dugStoneFile = null;
    File zeroFile = null;
    File oneFile = null;
    File twoFile = null;
    File threeFile = null;
    File fourFile = null;
    File fiveFile = null;
    File sixFile = null;
    File sevenFile = null;
    File eightFile = null;
    File nineFile = null;
    File falseFile = null;
    File trueFile = null;
    File unknownFile = null;
   
    
    /**
     * When object is created, symbols will not have been set
     */
    public PrintMapMenu(){
        try {
            undugNatFile=new File("NATURAL.png");
            dugNatFile = new File("DIRT.png");
            undugPitFile = new File("BRIGHTGREEN.png");
            dugPitFile = new File("PIT.png");
            undugStoneFile = new File("YELLOW.png");
            dugStoneFile = new File("STONE.png");
            zeroFile = new File("0.png");
            oneFile = new File("1.png");
            twoFile = new File("2.png");
            threeFile = new File("3.png");
            fourFile = new File("4.png");
            fiveFile = new File("5.png");
            sixFile = new File("6.png");
            sevenFile = new File("7.png");
            eightFile = new File("8.png");
            nineFile = new File("9.png");
            falseFile = new File("FALSE.png");
            trueFile = new File("TRUE.png");
            unknownFile = new File("UNKNOWN.png");

            undugNatImage=ImageIO.read(undugNatFile);
            dugNatImage = ImageIO.read(dugNatFile);
            undugPitImage = ImageIO.read(undugPitFile);
            dugPitImage = ImageIO.read(dugPitFile);
            undugStoneImage = ImageIO.read(undugStoneFile);
            dugStoneImage = ImageIO.read(dugStoneFile);
            zeroImage = ImageIO.read(zeroFile);
            oneImage = ImageIO.read(oneFile);
            twoImage = ImageIO.read(twoFile);
            threeImage = ImageIO.read(threeFile);
            fourImage = ImageIO.read(fourFile);
            fiveImage = ImageIO.read(fiveFile);
            sixImage = ImageIO.read(sixFile);
            sevenImage = ImageIO.read(sevenFile);
            eightImage = ImageIO.read(eightFile);
            nineImage = ImageIO.read(nineFile);
            trueImage = ImageIO.read(trueFile);
            falseImage = ImageIO.read(falseFile);
            unknownImage = ImageIO.read(unknownFile);
            
            


        } 
        catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
}

    

    /**
     * Print letter map
     * @param mapData - Object map data that holds myMap
     * @param subcontroller
     */
    public void printMap(MapData mapData){
        int i;
        int k;
        TileComponent mapNode;
        
        ArrayList<TileComponent> myMap = mapData.getMap();

        
        for(i = 0; i < ( mapData.getNumRows() *  mapData.getNumCols()); i+=  mapData.getNumCols())
        {
            for(k = 0; k <  mapData.getNumCols(); k++)
            {
                
                mapNode = myMap.get(k+i);
               
                if(mapNode.getFeature() == 'R')
                   mapNode.setImage(dugStoneImage);
                else if(mapNode.getFeature() == 'Y')
                    mapNode.setImage(undugStoneImage);
                else if(mapNode.getFeature() == 'H')
                    mapNode.setImage(dugPitImage);
                else if(mapNode.getFeature() == 'G')
                    mapNode.setImage(undugPitImage);
                else if(mapNode.getFeature() == 'D')
                    mapNode.setImage(dugNatImage);
                else if(mapNode.getFeature() == 'g')
                    mapNode.setImage(undugNatImage);   
            }   
            
        }
        
    }

    /**
     * Export scanned map or map of finds
     * @param mapData
     * @param menuInput - metal detector or magnetometer if scanned map
     *                    or metal, charcoal, or pottery finds map
     * @param scanned - boolean whether to print scanned map or finds map
     * @param subcontroller
     */
    public void printScannedMap(MapData mapData, int menuInput, boolean mapScanned)
    {
        int i;
        int k;
        myMap = mapData.getMap();
        int num;
        
      
        
        
        for(i = 0; i < (mapData.getNumRows() *  mapData.getNumCols()); i+=  mapData.getNumCols())
        {
            for(k = 0; k <  mapData.getNumCols(); k++)
            {
                if(menuInput == 1)    // charcoal
                {
                    if(mapScanned)
                    {
                        if(myMap.get(k+i).getMagnetometer() == true)
                        {
                            if(myMap.get(k+i).getCharcoalList().size() !=  0)
                                myMap.get(k+i).setImage(trueImage);
                            else
                                myMap.get(k+i).setImage(falseImage);
                        }
                        else
                             myMap.get(k+i).setImage(unknownImage);
                    }
                    else
                    {
                        if(myMap.get(k+i).getDug())
                        {
                            num = myMap.get(k+i).getCharcoalList().size();
                            switch(num){
                                case 0:
                                    myMap.get(k+i).setImage(zeroImage);
                                    break;
                                case 1:
                                    myMap.get(k+i).setImage(oneImage);
                                    break;
                                case 2:
                                    myMap.get(k+i).setImage(twoImage);
                                    break;
                                case 3:
                                    myMap.get(k+i).setImage(threeImage);
                                    break;
                                case 4:
                                    myMap.get(k+i).setImage(fourImage);
                                    break;
                                case 5:
                                    myMap.get(k+i).setImage(fiveImage);
                                    break;
                                case 6:
                                    myMap.get(k+i).setImage(sixImage);
                                    break;
                                case 7:
                                    myMap.get(k+i).setImage(sevenImage);
                                    break;
                                case 8:
                                    myMap.get(k+i).setImage(eightImage);
                                    break;
                                case 9:
                                    myMap.get(k+i).setImage(nineImage);
                                    break;           
                            }
                        }
                        else
                           myMap.get(k+i).setImage(unknownImage);
                    }
                }
                else if(menuInput == 2)    // metal
                {
                    if(mapScanned)
                    {
                        if(myMap.get(k+i).getMetalDetector() == true)
                        {
                            if(myMap.get(k+i).getMetalList().size() !=  0)
                                myMap.get(k+i).setImage(trueImage);
                            else
                                myMap.get(k+i).setImage(falseImage);
                        }
                        else
                             myMap.get(k+i).setImage(unknownImage);
                    }
                    else
                    {
                        if(myMap.get(k+i).getDug())
                        {
                            num = myMap.get(k+i).getMetalList().size();
                            switch(num){
                                case 0:
                                    myMap.get(k+i).setImage(zeroImage);
                                    break;
                                case 1:
                                    myMap.get(k+i).setImage(oneImage);
                                    break;
                                case 2:
                                    myMap.get(k+i).setImage(twoImage);
                                    break;
                                case 3:
                                    myMap.get(k+i).setImage(threeImage);
                                    break;
                                case 4:
                                    myMap.get(k+i).setImage(fourImage);
                                    break;
                                case 5:
                                    myMap.get(k+i).setImage(fiveImage);
                                    break;
                                case 6:
                                    myMap.get(k+i).setImage(sixImage);
                                    break;
                                case 7:
                                    myMap.get(k+i).setImage(sevenImage);
                                    break;
                                case 8:
                                    myMap.get(k+i).setImage(eightImage);
                                    break;
                                case 9:
                                    myMap.get(k+i).setImage(nineImage);
                                    break;           
                            }
                        }
                        else
                               myMap.get(k+i).setImage(unknownImage);
                    }
                }
                
                else if(menuInput == 3)    // pottery
                {
                    if(mapScanned)
                    {
                        if(myMap.get(k+i).getMagnetometer() == true)
                        {
                            if(myMap.get(k+i).getPotteryList().size() !=  0)
                                myMap.get(k+i).setImage(trueImage);
                            else
                                myMap.get(k+i).setImage(falseImage);
                        }
                        else
                             myMap.get(k+i).setImage(unknownImage);
                    }
                    else
                    {
                        if(myMap.get(k+i).getDug())
                        {
                            num = myMap.get(k+i).getPotteryList().size();
                            switch(num){
                                case 0:
                                    myMap.get(k+i).setImage(zeroImage);
                                    break;
                                case 1:
                                    myMap.get(k+i).setImage(oneImage);
                                    break;
                                case 2:
                                    myMap.get(k+i).setImage(twoImage);
                                    break;
                                case 3:
                                    myMap.get(k+i).setImage(threeImage);
                                    break;
                                case 4:
                                    myMap.get(k+i).setImage(fourImage);
                                    break;
                                case 5:
                                    myMap.get(k+i).setImage(fiveImage);
                                    break;
                                case 6:
                                    myMap.get(k+i).setImage(sixImage);
                                    break;
                                case 7:
                                    myMap.get(k+i).setImage(sevenImage);
                                    break;
                                case 8:
                                    myMap.get(k+i).setImage(eightImage);
                                    break;
                                case 9:
                                    myMap.get(k+i).setImage(nineImage);
                                    break;           
                            }
                        }
                        else
                           myMap.get(k+i).setImage(unknownImage);
                    }
                }   
            }
        }
    }
    
     /**
     * Converts integer column to string letter for printing
     * @Author Dr. Eric Becker
     * @param col - integer column index
     * @return -result, String code for column.
     */

    public static String toBase26(int col)
    {
        String result=null;
        ArrayList <Integer> tempArray = new ArrayList<Integer>();
        int value=col;
        int modulus=0;
        int iTemp1=0;
        int iTemp2=0;
        char temp=' ';	



        result=new String();
        boolean flag=true;


        //Convert from Base 10 to Base 26
        while (flag)
        {
                modulus=value%26;
                value=value/26;
                tempArray.add(modulus);
                if (value<1)
                        flag=false;
        }

        //Convert Base 26 to Character SEt 
        int loop=0;
        for (loop=0;loop<tempArray.size();loop++)
        {
                int iTemp3=tempArray.get(loop);

                //If the current character is higher than the first significant column.
                if (loop>0)
                {	temp=(char)('A'+iTemp3-1);

                }
                //Else, we want there to be a blank, not an '@'
                else
                {
                        temp=(char)('A'+iTemp3);
                }
                result=temp+result;

        }
        return result;
    }
}
        

