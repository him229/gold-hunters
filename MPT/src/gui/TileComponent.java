package gui;
/**
 * This class creates a TileComponent for Map Node
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import archeology.MapNode;


public class TileComponent extends JComponent implements MouseListener{
	
private static final long serialVersionUID = 1L;

BufferedImage image;

private MapNode mapRef;
	
	public TileComponent(BufferedImage img)
	{
		image=img;
		setMapRef(null);
		this.addMouseListener(this);
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

	public void setMapNode(MapNode tempMapNode) {
		// TODO Auto-generated method stub
		setMapRef(tempMapNode);
	}

	public MapNode getMapRef() {
		return mapRef;
	}

	public void setMapRef(MapNode mapRef) {
		this.mapRef = mapRef;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}    

	

}
