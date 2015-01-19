/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;


public class TileComponent extends JComponent implements MouseListener
{
	
    private static final long serialVersionUID = 1L;

    BufferedImage image;
    JLabel localStatusBar;
    JPopupMenu popUpMenu;

    private int row;
    private int col;
    private char feature;
    private boolean dug;
    private boolean magnetometer;  // 
    private boolean metalDetector; // true means it was scanned with metalDetector
    //boolean visibleSpectrum;
    private boolean heritage;
    private ArrayList<MetalNode> metalList;
    private ArrayList<CharcoalNode> charcoalList;
    private ArrayList<PotteryNode> potteryList;
	
	
    public TileComponent(BufferedImage img ,int row2, int col2, char feature2, boolean dug2, boolean heritage2) {
        image=img;
            
        row = row2;
        col = col2;
        dug = dug2;
        feature = feature2;
        heritage = heritage2;
        magnetometer= false;
        metalDetector = false;
        metalList = new ArrayList<>();
        charcoalList= new ArrayList<>();
        potteryList = new ArrayList<>();
    }

    public void paint(Graphics g) {

    g.drawImage(image, 0, 0, null);
        
    }

  public Dimension getPreferredSize() {
        if (image == null) {
             return new Dimension(800,600);
        } else {
           return new Dimension(image.getWidth(null), image.getHeight(null));
       }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub
            Point p=arg0.getLocationOnScreen();

            popUpMenu.setLocation(p.x,p.y);

            popUpMenu.setVisible(true);
            
            
    }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("MouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("MouseExited");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//localStatusBar.setText("BOO!");
		//System.out.println("MousePressed");
            
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("MouseReleased");
	}

	public void setPopupMenu(JPopupMenu testMenu) {
		// TODO Auto-generated method stub
		popUpMenu=testMenu;
	}    

	
        
   public void addFerrousMetalNodes(int date, int signalStrength){
    Ferrous ferrousNode = new Ferrous(date, signalStrength);     // polymorphism to add inherited node
    metalList.add(ferrousNode);
    }
    
    /**
     * Adds a metal node with a given date to the Metal finds list
     * @param date
     * @param type
     */
    public void addNonFerrousMetalNodes(int date, String type){
        NonFerrous nonferrousNode = new NonFerrous(date, type);     // polymorphism to add inherited node
        metalList.add(nonferrousNode);
    }
    
    /**
     * Adds a charcoal node with a given date to the Charcoal finds list
     * @param date
     * @param radius
     */
    public void addKilnCharcoalNodes(int date, double radius)
    {
        Kiln kilnNode = new Kiln(date,radius);
        charcoalList.add(kilnNode);
    }

    /** 
     * Adds a charcoal node with a given date to the Charcoal finds list
     * @param date
     * @param length
     * @param width
     */
    public void addHearthCharcoalNodes(int date, double length, double width)
    {
        Hearth hearthNode = new Hearth(date, length, width);
        charcoalList.add(hearthNode);
    }
    
    /**
     * Adds a pottery node with a given date to the Pottery finds list
     * @param date
     * @param volume
     */
    public void addStoragePotteryNodes(int date, double volume) 
    {
        Storage storageNode = new Storage(date,volume);
        potteryList.add(storageNode);   
    }
    
    /**
     * Adds a pottery node with a given date to the Pottery finds list
     * @param date
     * @param description
     */
    public void addDecoratedPotteryNodes(int date,String description) 
    {
        Decorated decoratedNode = new Decorated(date, description);
        potteryList.add(decoratedNode);
    }
    
    /**
     * Adds a pottery node with a given date to the Pottery finds list
     * @param date
     * @param depth
     */
    public void addSubmergedPotteryNodes(int date, int depth) 
    {
        Submerged submergedNode = new Submerged(date,depth);
        potteryList.add(submergedNode);
    }
    
    public ArrayList<MetalNode> getMetalList(){
        return metalList;
    }

    /**
     * Returns charcoal list
     * @return
     */
    public ArrayList<CharcoalNode> getCharcoalList(){
        return charcoalList;
    }

    /**
     * returns pottery list
     * @return
     */
    public ArrayList<PotteryNode> getPotteryList(){
        return potteryList;
    }
    
    /**
     * returns row
     * @return
     */
    public int getRow(){
        return row;
    }
    
    /**
     * Returns column
     * @return
     */
    public int getCol(){
        return col;
    }
    
    /**
     * Returns feature
     * @return
     */
    public char getFeature(){
        return feature;
    }
    
    /**
     * Sets feature
     * @param feature1
     */
    public void setFeature(char feature1){
        feature = feature1;
    }
    
    /**
     * returns dug
     * @return
     */
    public boolean getDug(){
        return dug;
    }
    
    /**
     * sets dug
     * @param dug1
     */
    public void setDug(boolean dug1){
        dug = dug1;
    }
    
    /**
     * gets magnetometer
     * @return
     */
    public boolean getMagnetometer(){
        return magnetometer;
    }
    
    /**
     * sets magnetometer
     * @param magneto
     */
    public void setMagnetometer(boolean magneto){
        magnetometer = magneto;
    }
    
    /**
     * gets metal detector
     * @return
     */
    public boolean getMetalDetector(){
        return metalDetector;
    }
    
    /**
     * set metal detector
     * @param metal
     */
    public void setMetalDetector(boolean metal){
        
        metalDetector = metal;
    }
    
    /**
     * gets heritage
     * @return
     */
    public boolean getHeritage(){
        return heritage;
    }
 
    public void setImage(BufferedImage image1){
        image = image1;
        revalidate();
        repaint();
        
    }


}