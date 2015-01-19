/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Maps are exported into text files
 * @author karentrevino
 */
public class ExportMap {
    
    private ArrayList<TileComponent> myMap;
    private MapData mapData;
    
    /**
     * Get myMap from mapData
     * @param mapData2
     */
    public ExportMap(MapData mapData2){
        
        myMap = mapData2.getMap();
        mapData = mapData2;
        
    }
    
    /**
     * Create files to export maps
     * @param printMenu - printMenu holds symbols for symbol map
     */
    public void exportProcess(String fileName)
    {
        
        File visibleMap = new File(fileName);               //Map Symbols
        try {
            FileWriter vmfw = new FileWriter(visibleMap);
            
            BufferedWriter vmbw = new BufferedWriter(vmfw);
    
            exportVM(vmbw);
            
            vmbw.close();
            
        } 
        catch (IOException ex) {
            System.out.println("Error");
        }                
    }
    
    /**
     * Exports Symbol Map
     * @param bw - buffered writer for file
     * @param printMenu - printMenu holds symbols for symbol map
     */ 
    public void exportVM(BufferedWriter bw){
        int i;
        int k;
        int p = 1;
        String ps;
        try
        {
            bw.append("   |");
        
            for(i = 0; i < mapData.getNumCols(); i++)     // Produces letters
            { 
                bw.append(String.format("%3s",PrintMapMenu.toBase26(i)));
            }
            bw.append("\n");


            bw.append("---+");
            for(i = 0; i < 3*mapData.getNumCols(); i++)     // Produces line seperation
                bw.append("-");
            bw.append("\n");

            for(i = 0; i < (mapData.getNumRows() * mapData.getNumCols()); i+= mapData.getNumCols())
            {
                ps = "";
                ps = String.format("%3s", Integer.toString(p++));
                bw.append(ps);
                bw.append("|");
                for(k = 0; k < mapData.getNumCols(); k++)
                {
                        bw.append(String.format("%3s",mapData.getMap().get(i+k).getFeature()));
                }   
                bw.append("\n");
            }
        }
        catch(IOException ex){
            
        }
    }
     
    /**
     * Exports scanned map or map of finds
     * @param menuInput - Magnetometer, metal detector
     * @param scanned - whether to print finds map or scanned map
     * @param bw - buffered writer
     */
    public void exportScannedMap(int menuInput, boolean scanned,BufferedWriter bw)
    {
        int i;
        int k;
        int p = 1;
        String ps;
        
        try{
            bw.append("   |");

            for(i = 0; i < mapData.getNumCols(); i++)     // Produces letters
            { 
                bw.append(String.format("%3s",PrintMapMenu.toBase26(i)));
            }
            bw.append("\n");


            bw.append("---+");
            for(i = 0; i < 3* mapData.getNumCols(); i++)     // Produces line seperation
                bw.append("-");
            bw.append("\n");


            for(i = 0; i < (mapData.getNumRows() * mapData.getNumCols()); i+= mapData.getNumCols())
            {
                ps = "";
                ps = String.format("%3s", Integer.toString(p++));
                bw.append(ps);
                bw.append("|");
                for(k = 0; k <mapData.getNumCols(); k++)
                {
                    if(menuInput == 1)    // charcoal
                    {
                        if(scanned)
                        {
                            if(myMap.get(k+i).getMagnetometer() == true)
                            {
                                if(myMap.get(k+i).getCharcoalList().size() !=  0)
                                    bw.append("  T");
                                else
                                    bw.append("  F");
                            }
                            else
                                bw.append("   ");
                        }
                        else
                        {
                            if(myMap.get(k+i).getDug())
                            {
                                bw.append(String.format("%3s",String.valueOf(myMap.get(k+i).getCharcoalList().size())));
                            }
                            else
                                bw.append("   ");
                        }
                    }
                    else if(menuInput == 2)    // metal
                    {
                        if(scanned)
                        {
                            if(myMap.get(k+i).getMetalDetector() == true)
                            {
                                if(myMap.get(k+i).getMetalList().size() !=  0)
                                    bw.append("  T");
                                else
                                    bw.append("  F");
                            }
                            else
                                bw.append("   ");
                        }
                        else
                        {
                            if(myMap.get(k+i).getDug())
                            {
                                bw.append(String.format("%3s",String.valueOf(myMap.get(k+i).getMetalList().size())));
                            }
                            else
                                bw.append("   ");
                        }
                    }
                    else if(menuInput == 3)     //pottery
                    {
                        if(scanned)
                        {

                                bw.append("   ");
                        }
                        else
                        {
                            if(myMap.get(k+i).getDug())
                            {
                                bw.append(String.format("%3s", String.valueOf(myMap.get(k+i).getPotteryList().size())));
                            }
                            else
                                bw.append("   ");
                        }
                    }
                }   
                bw.append("\n");
            }
        }
        catch(IOException ex){
            
        }
    }
}
