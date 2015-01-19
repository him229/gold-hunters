/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;

import java.awt.Dimension;
import java.awt.Font;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Controls GUI and input to functions
 * @author karentrevino
 */
public class SubController {

    //private JTextArea output;
    private String text;
    private MapData map;
    private JPanel tilePanel;
    private PrintMapMenu printMenu;             //setup print menu
    private ExportMap exportMap;
    private ScanMap scanMap;
    private DigMap digMap;
    private MakeReport makeReport;
    private FindsAverage findsAverage;

    /**
     * Loads File
     * @param filename
     */
    public void load() {
        // TODO Auto-generated method stub

        printMenu = new PrintMapMenu();
        exportMap = new ExportMap(map);
        
        String fileName = "Tikal2.csv";
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(tilePanel);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            fileName = fileChooser.getSelectedFile().getName();
              map.load(fileName, tilePanel,this);
            
        }
        
    }

    /**
     * Saves files to external files
     */
    public void save() {

        if(map.getMap() != null)   {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showSaveDialog(tilePanel);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                String fileName = fileChooser.getSelectedFile().getName();
                exportMap.exportProcess(fileName);
            }
        }
        else{
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }
   
    }

    /**
     * Exits programs
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * Dig square
     * @param row
     * @param col
     */
    public void dig(int row, int col){
        
        if(map.getMap() != null)            // Map must be loaded first
        {
            digMap = new DigMap();
            int index = map.getNumCols()*(row) + col ;
            TileComponent mapNode = map.getMap().get(index);
            
            digMap.process(mapNode);
        }
        else {
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }
   }

    /**
     * Scan with magnetometer
     * @param row
     * @param col
     */
    public void magnetometer(int row, int col){
        if(map.getMap()!= null)            // Map must be loaded first
        {
            scanMap = new ScanMap();
            int index = map.getNumCols()*(row) + col ;
            TileComponent mapNode = map.getMap().get(index);
            scanMap.process(mapNode, 1);
        }
        else {
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }

    }

    /**
     * Scan with metal detector
     * @param row
     * @param col
     */
    public void metalDetector(int row, int col){
        if(map.getMap() != null)            // Map must be loaded first
        {
            scanMap = new ScanMap();
            int index = map.getNumCols()*(row) + col ;
            TileComponent mapNode = map.getMap().get(index);
            scanMap.process(mapNode, 2);
        }
        else {
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }

    }

    /**
     * Prints about info
     */
    public void about() {
              
        text="Archeology Dig Tool\n";
        text=text+"Karen Trevino\n";
        text=text+"1000908298\n";
        text=text+"Himank Yadav\n";
        text=text+"1000958091\n";
        text=text+"11/24/2014\n";
        text=text+"Version 0.3\n";
        
        JOptionPane.showMessageDialog(null,text);

    }

    /**
     * Shows map with features
     */
    public void showMap() {
            // TODO Auto-generated method stub

        if(map.getMap() != null)            // Map must be loaded first
        {
            printMenu.printMap(map);
        }
        else {
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }


    }

    /**
     * Shows maps with scanned square of metal detector
     */
    public void showMetalDetector() {
            // TODO Auto-generated method stub

        if(map.getMap() != null)            // Map must be loaded first
        {
            printMenu.printScannedMap(map,2,true);
        }
        else {
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }

    }

    /**
     * Shows maps with scanned square of magnetometer
     */
    public void showMagnetometer() {
            // TODO Auto-generated method stub

        if(map.getMap() != null)            // Map must be loaded first
        {
            printMenu.printScannedMap(map,1,true);
        }
        else {
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }

    }

    /**
     * Shows maps with pottery finds
     */
    public void showPotteryFinds() {
            

        if(map.getMap() != null)            // Map must be loaded first
        {
            printMenu.printScannedMap(map,3,false);

        }
        else {
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }

    }

    /**
     * Shows maps with charcoal finds
     */
    public void showCharcoalFinds() {
         

        if(map.getMap() != null)            // Map must be loaded first
        {
            printMenu.printScannedMap(map,1,false);
        }
        else {
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }

    }

    /**
     * Shows maps with metal finds
     */
    public void showMetalFinds() {
            

        if(map.getMap() != null)            // Map must be loaded first
        {
            printMenu.printScannedMap(map,2,false);

        }
        else {
            text = "Load a file first\n";
            JOptionPane.showMessageDialog(null,text);
        }

    }

    /**
     * Updates map symbols
     * @param dataSymbols
     */
    public void updateSymbols(DataSymbols dataSymbols){
        char us = dataSymbols.getUndugStone();
        char ds = dataSymbols.getDugStone();
        char up = dataSymbols.getUndugPit();
        char dp = dataSymbols.getDugPit();
        char un = dataSymbols.getUndugNatural();
        char dn = dataSymbols.getDugNatural();
//
//        printMenu.setSymbols(us, ds, up, dp, un, dn);
//        printMenu.activateSetup();
    }

    /**
     * Shows finds report
     */
    public void showReport(){
        JOptionPane reportDialog;
        if(map.getMap() != null)            // Map must be loaded first
        {
              makeReport = new MakeReport();
              makeReport.process(map.getMap());

              text = makeReport.getText() +"\n\n";

              findsAverage = new FindsAverage();
              findsAverage.findAverage(map);
              text = text+ findsAverage.getText();
              
              JTextArea textArea= new JTextArea(text);
              textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
              JScrollPane scrollPane = new JScrollPane(textArea);
              scrollPane.setPreferredSize(new Dimension(500,500));
              
              JOptionPane.showMessageDialog(null,scrollPane,"Report", JOptionPane.YES_NO_OPTION);
              
            

        }
        else {
             text = "Load a file first\n";
             JOptionPane.showMessageDialog(null,text);
             
        }
    }

    /**
     * Sets text area
     * @param textArea
     */
    public void setTilePanel(JPanel tilePanel1) {
            // TODO Auto-generated method stub
            tilePanel = tilePanel1;
    }

    /**
     * sets mapData
     * @param newMap
     */
    public void setMapData(MapData newMap)
    {
            map=newMap;
    }

    /**
     * sets text
     * @param newText
     */
    public void setText(String newText){
        text = newText;
    }
 
}
