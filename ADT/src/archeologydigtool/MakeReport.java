/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */


package archeologydigtool;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Makes three tables for three types of finds
 * @author karentrevino
 */
public class MakeReport {
    
    private ArrayList<PotteryNode> allPottery;
    private ArrayList<CharcoalNode> allCharcoal;
    private ArrayList<MetalNode> allMetal;
    
    private ArrayList<MetalNode> tempMetal;
    private ArrayList<CharcoalNode> tempCharcoal;
    private ArrayList<PotteryNode> tempPottery;
    
    private String text;
    
    /**
     * Constructor sets lists to null
     */
    public MakeReport(){
        allPottery = null;
        allCharcoal = null;
        allMetal = null;
        
    }
    
    /**
     * Builds three arraylists from all the array lists in the map
     * @param myMap
     */
    public void process(ArrayList<TileComponent> myMap){
        allPottery = new ArrayList();
        allCharcoal = new ArrayList();
        allMetal = new ArrayList();
        
        for(TileComponent mapNode: myMap){
            if(mapNode.getDug()){
                tempMetal = mapNode.getMetalList();

                for(MetalNode metalNode:tempMetal){
                    metalNode.setRowCol(mapNode.getRow(), mapNode.getCol());
                    allMetal.add(metalNode);
                }
            }
        }
        
        for(TileComponent mapNode: myMap){
            if(mapNode.getDug()){
                tempPottery = mapNode.getPotteryList();

                for(PotteryNode potteryNode:tempPottery){
                    potteryNode.setRowCol(mapNode.getRow(), mapNode.getCol());
                    allPottery.add(potteryNode);
                }
            }
        }
        
        for(TileComponent mapNode: myMap){
            if(mapNode.getDug()){
                tempCharcoal = mapNode.getCharcoalList();

                for(CharcoalNode charcoalNode:tempCharcoal){
                    charcoalNode.setRowCol(mapNode.getRow(), mapNode.getCol());
                    allCharcoal.add(charcoalNode);
                }
            }
        }
        
        Collections.sort(allMetal);
        Collections.sort(allCharcoal);
        Collections.sort(allPottery);
        
        text = "-------------------------\nMetal Table\n-------------------------\n";
        text = text + "DATE   |SIGNAL STRENGTH|TYPE       |ROW|COL|\n";
        for(MetalNode metalNode: allMetal){
            //text = text + String.format("Date: %5d ")
            if(metalNode instanceof Ferrous){
                Ferrous node = (Ferrous) metalNode;
                text = text + String.format("%7d|%15d|           |%3d|%3d\n",node.getDate(), node.getSignalStrength(), node.getRow(), node.getCol());
            }
            if(metalNode instanceof NonFerrous){
                NonFerrous node = (NonFerrous) metalNode;
                text = text + String.format("%7d|               |%11s|%3d|%3d\n",node.getDate(), node.getType(), node.getRow(), node.getCol());
            }
        }
        
        text = text + "\n\n---------------------\nPottery Table\n---------------------\n";
        text = text + "DATE   |DESCRIPTION|DEPTH    |VOLUME   |ROW|COL|\n";
        for(PotteryNode potteryNode: allPottery){
            
            //text = text + String.format("Date: %5d ")
            if(potteryNode instanceof Decorated){
                Decorated node = (Decorated) potteryNode;
                text = text + String.format("%7d|%11s|         |         |%3d|%3d\n",node.getDate(), node.getString(), node.getRow(), node.getCol());
            }
            if(potteryNode instanceof Submerged){
                Submerged node = (Submerged) potteryNode;
                text = text + String.format("%7d|           |%9.2f|         |%3d|%3d\n",node.getDate(), node.getDepth(), node.getRow(), node.getCol());
            }
            if(potteryNode instanceof Storage){
                Storage node = (Storage) potteryNode;
                text = text + String.format("%7d|           |         |%9.2f|%3d|%3d\n",node.getDate(), node.getVolume(), node.getRow(), node.getCol());
            }
        }

        text = text + "\n\n---------------------\nCharcoal Table\n---------------------\n";
        text = text + "DATE   |LENGTH|WIDTH|RADIUS|ROW|COL|\n";
        for(CharcoalNode charcoalNode: allCharcoal){
            
            //text = text + String.format("Date: %5d ")
            if(charcoalNode instanceof Hearth){
                Hearth node = (Hearth) charcoalNode;
                text = text + String.format("%7d|%6.2f|%5.2f|      |%3d|%3d\n",node.getDate(), node.getLength(), node.getWidth(), node.getRow(), node.getCol());
            }
            if(charcoalNode instanceof Kiln){
                Kiln node = (Kiln) charcoalNode;
                text = text + String.format("%7d|      |     |%6.2f|%3d|%3d\n",node.getDate(), node.getRadius(), node.getRow(), node.getCol());
            }
        }
        
        text = text + "\n";
        
    }
    
    /**
     * Returns text
     * @return
     */
    public String getText(){
        return text;
    }
}