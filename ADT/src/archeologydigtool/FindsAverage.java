/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;

import java.util.ArrayList;

/**
 * FindsAverage finds and stores average and standard deviation of squares that
 * have been dug
 * @author karentrevino
 */
public class FindsAverage {
    
    private double average;
    private double sd;
    private String text;
    
    /**
     * finds and stores average and standard deviation of squares that
     * have been dug
     * @param mapData
     */
    public void findAverage(MapData mapData)
    {
        ArrayList<TileComponent> myMap = mapData.getMap();
        double sum = 0;
        double count= 0;
        
        for(int i = 0; i < myMap.size(); i++)     // produces sum of all dug finds
        {
            if(myMap.get(i).getDug())
            {
                for(int k = 0; k < myMap.get(i).getCharcoalList().size(); k++)
                {
                    sum = sum + myMap.get(i).getCharcoalList().get(k).getDate();
                    count ++;
                }
        
                for(int k = 0; k < myMap.get(i).getMetalList().size(); k++)
                {
                    sum = sum + myMap.get(i).getMetalList().get(k).date;
                    count++;
                }
                for(int k = 0; k < myMap.get(i).getPotteryList().size(); k++)
                {
                    sum = sum + myMap.get(i).getPotteryList().get(k).date;
                    count++;
                }
            }
        }
        double variance = 0;
        average = sum / count;
        
        for(int i = 0; i < myMap.size(); i++)    // produces standard deviation
        {
            if(myMap.get(i).getDug())
            {
                for(int k = 0; k < myMap.get(i).getCharcoalList().size(); k++)
                {
                    variance = variance + Math.pow(myMap.get(i).getCharcoalList().get(k).getDate() - average, 2);
                }
            
            
                for(int k = 0; k < myMap.get(i).getMetalList().size(); k++)
                {
                    variance = variance + Math.pow(myMap.get(i).getMetalList().get(k).date - average,2);
                }
           
                for(int k = 0; k < myMap.get(i).getPotteryList().size(); k++)
                {
                    variance = variance + Math.pow(myMap.get(i).getPotteryList().get(k).date - average,2);
                }
            }
            
        }
        
        sd = Math.sqrt(variance/count);   //standard deviation
        text = String.format("Average = %.2f  ± %.2f\n", average,sd);
    }
    
    /**
     * Return text
     * @return
     */
    public String getText(){
        return text;
    }
}
