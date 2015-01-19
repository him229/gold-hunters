package gui;
/**
 * This class creates a Pop Up Menu for a MapNode
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import archeology.MapNode;
import archeology.SubController;
public class TilePopUpMenu extends JPopupMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem mntmSetFeatures;
	private JMenuItem mntmToggleExcavated;
	private JMenuItem mntmToggleHeritage;
	private JMenuItem mntmAddMetalFind;
	private JMenuItem mntmAddPotteryFind;
	private JMenuItem mntmAddCharcoalFind;
	SubController subController;
	private MapNode tileMapNode;
	private MainFrame parent;
	String rowStr;
	String colStr;
	
	public void setSubController(SubController subController) {
		this.subController = subController;
	}


	public TilePopUpMenu()
	{
		mntmSetFeatures=new JMenuItem("Set Feature");
		mntmToggleExcavated=new JMenuItem("Toggle Excavated");
		mntmToggleHeritage= new JMenuItem("Toggle Heritage");
		mntmAddMetalFind =new JMenuItem("Add Metal Find") ;
		mntmAddPotteryFind=new JMenuItem("Add Pottery Find");
		mntmAddCharcoalFind=new JMenuItem("Add Charcoal Find");
		this.add(mntmSetFeatures);
		this.add(mntmToggleExcavated);
		this.add(mntmToggleHeritage);
		this.add(mntmAddMetalFind);
		this.add(mntmAddPotteryFind);
		this.add(mntmAddCharcoalFind);
		mntmSetFeatures.addActionListener(this);
		mntmToggleExcavated.addActionListener(this);
		mntmToggleHeritage.addActionListener(this);
		mntmAddMetalFind.addActionListener(this);
		mntmAddPotteryFind.addActionListener(this);
		mntmAddCharcoalFind.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String command="";
		command= arg0.getActionCommand();
		switch(command){
		case "Set Feature":
			String feature1 = JOptionPane.showInputDialog("Feature?");
			//String feature1 = parent.popUpInput("Please Enter a feaure");
			tileMapNode.setFeature(feature1);
			break;
		case "Toggle Excavated":
			tileMapNode.markExcavated();
			break;

		case "Toggle Heritage":
			tileMapNode.markHeritage();
			int row2 = tileMapNode.getRow()+1;
			String text = "Heriatge marked on "+toBase26(tileMapNode.getCol())+row2;
			JOptionPane.showMessageDialog(null, text);			

			break;

		case "Add Metal Find":
			rowStr = Integer.toString(tileMapNode.getRow());
			colStr = toBase26(tileMapNode.getCol());
			parent.popUpAddFind(colStr, rowStr);
			break;

		case "Add Pottery Find":
			rowStr = Integer.toString(tileMapNode.getRow());
			colStr = toBase26(tileMapNode.getCol());
			parent.popUpAddFind(colStr, rowStr);
			break;

		case "Add Charcoal Find":
			rowStr = Integer.toString(tileMapNode.getRow());
			colStr = toBase26(tileMapNode.getCol());
			parent.popUpAddFind(colStr, rowStr);
			break;
		}
		parent.refreshMap();
	}
	public String toBase26(int col)
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

	public MapNode getTileMapNode() {
		return tileMapNode;
	}

	public void setTileMapNode(MapNode tileMapNode) {
		this.tileMapNode = tileMapNode;
	}
	
	public void setParent(MainFrame parentPtr)
	{
		parent=parentPtr;
	}

}