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
import javax.swing.JOptionPane;

/**
 * User inputs which square to dig and symbol is updated in map
 * @author karentrevino
 */
public class DigMap{
   
    
    /**
     * Method takes user input and the input is converted into ints to correspond
     * to a row and column. ArrayList index is also generated.
     * @param mapData
     * @param row
     * @param col
     */
    public static void process(TileComponent mapNode){
 
        ArrayList<TileComponent> myMap;

        
        
        
        try
        {
            if(mapNode.getHeritage())
            {
                throw new SquareHeritageException();
            }
            if(mapNode.getDug() != true)  // Only send to function if square is not already dug
            {
                updateFeature(mapNode);
                
            }
            
        }
        catch(SquareHeritageException ex)
        {
            String text = "Exception: Square has heritage\n";
            JOptionPane.showMessageDialog(null,text);
        }
    }
    
    /**
     * Mapnode feature is update to new dug character
     * @param mn - mapnode to be updated
     */
    public static void updateFeature(TileComponent mapNode){
        
        BufferedImage undugNatImage=null;
        BufferedImage dugNatImage=null;
        BufferedImage undugPitImage=null;
        BufferedImage dugPitImage=null;
        BufferedImage undugStoneImage=null;
        BufferedImage dugStoneImage=null;

        File undugNatFile=null;
        File dugNatFile=null;
        File undugPitFile=null;
        File dugPitFile=null;
        File undugStoneFile=null;
        File dugStoneFile = null;



        try {
            undugNatFile=new File("NATURAL.png");
            dugNatFile = new File("DIRT.png");
            undugPitFile = new File("BRIGHTGREEN.png");
            dugPitFile = new File("PIT.png");
            undugStoneFile = new File("YELLOW.png");
            dugStoneFile = new File("STONE.png");

            undugNatImage=ImageIO.read(undugNatFile);
            dugNatImage = ImageIO.read(dugNatFile);
            undugPitImage = ImageIO.read(undugPitFile);
            dugPitImage = ImageIO.read(dugPitFile);
            undugStoneImage = ImageIO.read(undugStoneFile);
            dugStoneImage = ImageIO.read(dugStoneFile);


        } 
        catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

        
        
        mapNode.setDug(true);
        
        if(mapNode.getFeature() == 'Y')
        {
            mapNode.setFeature('R');
            mapNode.setImage(dugStoneImage);
            
        }

        else if(mapNode.getFeature() == 'G')
        {
            mapNode.setFeature('H');
            mapNode.setImage(dugPitImage);
        }

        else if (mapNode.getFeature() == 'g')
        {
            mapNode.setFeature('D');
            mapNode.setImage(dugNatImage);
        }
        
    }
    
    /**
     * Input from user is converted to integers
     * @param line - input string to convert to row and column
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


    
}
