package gui;
/**
 * This class creates a mainframe for the programs GUI 
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import archeology.MapMaker;
import archeology.MapNode;
import archeology.SaveMap;
import archeology.SubController;
import archeology.MapData;
import archeology.SetFeatures;
import archeology.FileTester;


public class MainFrame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1156392119668344557L;

	private SubController subController;
	String fileName;

	private MapData mapData;
	private MapMaker mapMaker;
	private SetFeatures setFeatures;
	private FileTester fileTester;
	//*******************************************************
	//
	//     The Menus
	//
	//*******************************************************
	private static final String commandLoad="Load";
	private static final String commandSave="Save";
	private static final String commandExit="Exit";
	
	private static final String commandCreateMap="Create Map";
	private static final String commandUpdateSquareFeature="Update Square Feature";
	private static final String commandUpdateRowFeature="Update Row Feature";
	private static final String commandAddFind="Add Find";
	private static final String commandMarkHeritage="Mark Heritage";
	
	private static final String commandSameSymbol="Same Symbol";
	private static final String commandUpdateSymbol="Update Symbol";
	
	private static final String commandAbout="About";
	
	private JMenuBar menuBar;
	private JMenu menuFile;

	
	private JMenu menuEdit;
	
	
	private JMenu menuView;
	
	FileWriter vmfw;

	

	
	//==============================================
	//
	// Dialog Boxes and Datastores
	//
	//==============================================	

	DialogueLoad tempDialogueLoad;
	DataLoad tempDataLoad;
	
	DialogueAddFinds tempDialogueAddFinds;
	DataAddFinds tempDataAddFinds;
	DialogueSymbol tempDialogueSymbol;
	DataSymbol tempDataSymbol;
	DataLocation tempDataLocation;
	DialogueLocation tempDialogueLocation;

	

	//*******************************************************
	//
	// The Text Area
	//
	//*******************************************************

	/*JTextArea textArea;
	JScrollPane scrollPane;
	Container content;*/
	
	private JScrollPane mapScrollPane;
	private JPanel mapPanel;

	private Container contentPane;
	
	private File undugNaturalFile;
	private File undugStoneFile;
	private File undugPitFile;
	private File dugPitFile;
	private File dugStoneFile;
	private File dugNaturalFile;
	
	private BufferedImage undugNaturalImage;
	private BufferedImage undugStoneImage;
	private BufferedImage undugPitImage;
	private BufferedImage dugNaturalImage;
	private BufferedImage dugStoneImage;
	private BufferedImage dugPitImage;
	
	private JMenuItem mntmLoad;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmUpdateSymbol;
	private JMenuItem mntmSameSymbol;
	private JMenuItem mntmCreatemap;
	private JMenuItem mntmUpdateSquareFeature;
	private JMenuItem mntmUpdateRowFeature;
	private JMenuItem mntmAddFind;
	private JMenuItem mntmMarkHeritage;
	SaveMap saveMap;
	
	private void MakeMenus()
	{
		
		
		//===========================
		//Menu Bar
		//===========================
		menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		
		//===========================
		//File Menu
		//===========================
		menuFile=new JMenu("File");

		mntmLoad = new JMenuItem(commandLoad);
		mntmLoad.addActionListener(this);
		menuFile.add(mntmLoad);
		
		mntmSave = new JMenuItem(commandSave);
		mntmSave.addActionListener(this);
		menuFile.add(mntmSave);
		
		mntmExit = new JMenuItem(commandExit);
		mntmExit.addActionListener(this);
		menuFile.add(mntmExit);
		
		menuBar.add(menuFile);
		
		//===========================
		//Edit Menu
		//===========================
		menuEdit=new JMenu("Edit");
		menuBar.add(menuEdit);
		
		mntmCreatemap = new JMenuItem(commandCreateMap);
		mntmCreatemap.addActionListener(this);
		menuEdit.add(mntmCreatemap);
		
		mntmUpdateSquareFeature = new JMenuItem(commandUpdateSquareFeature);
		mntmUpdateSquareFeature.addActionListener(this);
		menuEdit.add(mntmUpdateSquareFeature);
		
		mntmUpdateRowFeature = new JMenuItem(commandUpdateRowFeature);
		mntmUpdateRowFeature.addActionListener(this);
		menuEdit.add(mntmUpdateRowFeature);
		
		mntmAddFind = new JMenuItem(commandAddFind);
		mntmAddFind.addActionListener(this);
		menuEdit.add(mntmAddFind);
		
		mntmMarkHeritage = new JMenuItem(commandMarkHeritage);
		mntmMarkHeritage.addActionListener(this);
		menuEdit.add(mntmMarkHeritage);

		//===========================
		//View Menu
		//===========================
		menuView=new JMenu("View");
		menuBar.add(menuView);

		mntmUpdateSymbol = new JMenuItem(commandUpdateSymbol);
		mntmUpdateSymbol.addActionListener(this);
		menuView.add(mntmUpdateSymbol);
		
		mntmSameSymbol = new JMenuItem(commandSameSymbol);
		mntmSameSymbol.addActionListener(this);
		menuView.add(mntmSameSymbol);

		//===========================
		//About Menu Item
		//===========================
		JMenu menuAbout = new JMenu("About");
		JMenuItem mntmAbout = new JMenuItem(commandAbout);
		menuAbout.add(mntmAbout);
		mntmAbout.addActionListener(this);
		menuBar.add(menuAbout);
		
	}
	
	/*private void MakeTextArea()
	{
		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", 0, 10));
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
		content = this.getContentPane();
		content.add(scrollPane, BorderLayout.CENTER);
		subController.setTextArea(textArea);
	    
	}*/
	//subController.setTextArea(tempDialogueLoad.getTextArea())
	
	public MainFrame()
	{
		super ("Reference Frame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//==================================================
		mapData=new MapData();
		mapMaker=new MapMaker();
		setFeatures = new SetFeatures();
		saveMap = new SaveMap();

		//==================================================
		subController=new SubController();
		subController.setMapData(mapData);
		subController.setMapMaker(mapMaker);
		subController.setFileTester(fileTester);
		subController.setSetFeatures(setFeatures);


		//==================================================
		MakeMenus();
		//MakeTextArea();
		MakeDialogAndData();
		//==================================================		
		this.setSize(new Dimension(800, 600));
		
		loadImage();
		makeImageArea();
		resizeMainframe();
		this.pack();
		setVisible(true);
		
	}
	private void resizeMainframe() {
		// TODO Auto-generated method stub

	}

	private void loadImage() 
	{
		
		// TODO Auto-generated method stub
		undugNaturalFile=new File("NATURAL.png");
		undugStoneFile=new File("YELLOW.png");
		undugPitFile=new File("FALSE.png");
		dugStoneFile = new File("STONE.png");
		dugNaturalFile = new File("DIRT.png");
		dugPitFile = new File("PIT.png");

		try
		{
		undugNaturalImage=ImageIO.read(undugNaturalFile);
		undugStoneImage=ImageIO.read(undugStoneFile);
		undugPitImage=ImageIO.read(undugPitFile);
		dugNaturalImage=ImageIO.read(dugNaturalFile);
		dugStoneImage=ImageIO.read(dugStoneFile);
		dugPitImage=ImageIO.read(dugPitFile);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	private void makeImageArea() 
	{
		contentPane=this.getContentPane();
		mapPanel=new JPanel();	
		
		JPanel fixer=new JPanel();
		fixer.setLayout(new BorderLayout());
		fixer.add(mapPanel,BorderLayout.CENTER);
		
		mapScrollPane = new JScrollPane(fixer);
		contentPane.add(mapScrollPane);		
	}
	
	public String popUpInput(String inputStr){
		String featurePopUp = JOptionPane.showInputDialog(inputStr);
		return featurePopUp;
	}
	public void popUpAddFind(String colStr, String rowStr){
		tempDialogueAddFinds.setDataAddFinds(tempDataAddFinds);		
		tempDialogueAddFinds.setModal(true);
		tempDialogueAddFinds.textFieldCol.setEditable(false);
		tempDialogueAddFinds.textFieldRow.setEditable(false);
		tempDialogueAddFinds.setVisible(true);
		subController.addFinds(colStr,rowStr, tempDataAddFinds.getFindType(), tempDataAddFinds.getProperty());
	}
	private void MakeDialogAndData() 
	{
		// TODO Auto-generated method stub
		tempDialogueSymbol=new DialogueSymbol();
		tempDataSymbol = new DataSymbol();
		tempDataLocation=new DataLocation();
		tempDialogueLocation=new DialogueLocation();
		tempDataAddFinds=new DataAddFinds();
		tempDialogueAddFinds  = new DialogueAddFinds();
		
		tempDataLoad=new DataLoad();
		tempDialogueLoad=new DialogueLoad();
	}

	public void run()
	{
		this.pack();
		this.setVisible(true);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame main=new MainFrame();
		main.run();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String command="";
		command=arg0.getActionCommand();
		
		switch(command)
		{
		case commandLoad:
			JFileChooser fileChooser = new JFileChooser();
			int val = fileChooser.showOpenDialog(this);
			if(val==JFileChooser.APPROVE_OPTION){
				fileName = fileChooser.getSelectedFile().getName();				
			}
			//tempDialogueLoad.setDataLoad(tempDataLoad);		
			//tempDialogueLoad.setModal(true);
			//tempDialogueLoad.setVisible(true);
			subController.load(fileName);
			//JOptionPane.showMessageDialog(this, "File Loaded");
		    //this.putMap();
			break;
		case commandSave:
			saveMap.setParent(this);
			saveMap.writeMap(mapData);
			break;
		case commandExit:
			subController.exit();
			break;		
		case commandCreateMap:
			tempDialogueLocation.setDataLocation(tempDataLocation);		
			tempDialogueLocation.setModal(true);
			tempDialogueLocation.setVisible(true);
			subController.createMap(tempDataLocation.getCol(), tempDataLocation.getRow());
			break;
		case commandUpdateSquareFeature:
			tempDialogueLocation.setDataLocation(tempDataLocation);		
			tempDialogueLocation.setModal(true);
			tempDialogueLocation.setVisible(true);
			
			tempDialogueSymbol.setDataSymbol(tempDataSymbol);		
			tempDialogueSymbol.setModal(true);
			tempDialogueSymbol.setVisible(true);
			
			subController.updateSquareFeature(tempDataLocation.getCol(), tempDataLocation.getRow(), tempDataSymbol.getSymbol());
			break;
		case commandUpdateRowFeature:
			tempDialogueLocation.setDataLocation(tempDataLocation);		
			tempDialogueLocation.setModal(true);
			tempDialogueLocation.setVisible(true);
			tempDialogueLocation.textFieldCol.setEditable(false);
			

			tempDialogueSymbol.setDataSymbol(tempDataSymbol);		
			tempDialogueSymbol.setModal(true);
			tempDialogueSymbol.setVisible(true);
			
			subController.updateRowFeature(tempDataLocation.getRow(), tempDataSymbol.getSymbol());
			break;
		case commandAddFind:

			tempDialogueAddFinds.setDataAddFinds(tempDataAddFinds);		
			tempDialogueAddFinds.setModal(true);
			tempDialogueAddFinds.setVisible(true);
			subController.addFinds(tempDataAddFinds.getCol(), tempDataAddFinds.getRow(), tempDataAddFinds.getFindType(), tempDataAddFinds.getProperty());
			break;
		case commandMarkHeritage:

			tempDialogueLocation.setDataLocation(tempDataLocation);		
			tempDialogueLocation.setModal(true);
			tempDialogueLocation.setVisible(true);
			subController.markHeritage(tempDataLocation.getCol(), tempDataLocation.getRow());
			break;
		case commandUpdateSymbol:
			tempDialogueSymbol.setDataSymbol(tempDataSymbol);		
			tempDialogueSymbol.setModal(true);
			tempDialogueSymbol.setVisible(true);
			tempDialogueSymbol.textFieldSymbol.setEditable(false);
			subController.updateSymbol(tempDataSymbol.getdNatural(),tempDataSymbol.getdPit(), tempDataSymbol.getdStone(), tempDataSymbol.getuNatural(), tempDataSymbol.getuPit(), tempDataSymbol.getuStone());			
			break;
		case commandSameSymbol:
			this.putMap();
			//subController.sameSymbol();
			break;
		case commandAbout:
			subController.about();
			break;
		
		}
		
		this.refreshMap();
	}
	
	private void putMap() {
		int maxX=mapData.getUserRow();
		int maxY=mapData.getUserCol();
		
		

		mapPanel.removeAll();
		mapPanel.setBackground(new Color(0,0,0));
		GridLayout gl=new GridLayout(maxX,maxY);
		mapPanel.setLayout(gl);
		
		Dimension mapSize=new Dimension(100+maxX*undugNaturalImage.getWidth(),100+maxY*undugNaturalImage.getHeight());
		this.setPreferredSize(mapSize);
		this.setSize(mapSize);
	
		//this.setResizable(false);
		ArrayList <MapNode> tempList=mapData.getMapNodes();
		
		
		
		int length=tempList.size();
		int nodeLoop=0;
		MapNode tempMapNode;
		TileComponent tempTile=new TileComponent(undugNaturalImage);
		
		
		TilePopUpMenu tempPopup=null;
		for (nodeLoop=0;nodeLoop<length;nodeLoop++)
		{
			tempMapNode=tempList.get(nodeLoop);
			switch (tempMapNode.getFeature())
			{
			case 'N':
				if (tempMapNode.getDug()==true){
					tempTile=new TileComponent(dugNaturalImage);
					tempPopup=new TilePopUpMenu();
					tempTile.setMapNode(tempMapNode);
					tempPopup.setTileMapNode(tempMapNode);
					tempPopup.setParent(this);
					tempTile.setComponentPopupMenu(tempPopup);
					break;}
				else
					{tempTile=new TileComponent(undugNaturalImage);
					tempPopup=new TilePopUpMenu();
					tempTile.setMapNode(tempMapNode);
					tempPopup.setTileMapNode(tempMapNode);
					tempPopup.setParent(this);
					tempTile.setComponentPopupMenu(tempPopup);
					break;}
					
			case 'P':
				if (tempMapNode.getDug()==true){
					tempTile=new TileComponent(dugPitImage);
					tempPopup=new TilePopUpMenu();
					tempTile.setMapNode(tempMapNode);
					tempPopup.setTileMapNode(tempMapNode);
					tempPopup.setParent(this);
					tempTile.setComponentPopupMenu(tempPopup);
					break;}
				else
					{tempTile=new TileComponent(undugPitImage);
					tempPopup=new TilePopUpMenu();
					tempTile.setMapNode(tempMapNode);
					tempPopup.setTileMapNode(tempMapNode);
					tempPopup.setParent(this);
					tempTile.setComponentPopupMenu(tempPopup);
					break;}
			case 'S':
				if (tempMapNode.getDug()==true){
					tempTile=new TileComponent(dugStoneImage);
					tempPopup=new TilePopUpMenu();
					tempTile.setMapNode(tempMapNode);
					tempPopup.setTileMapNode(tempMapNode);
					tempPopup.setParent(this);
					tempTile.setComponentPopupMenu(tempPopup);
					break;}
				else
					{tempTile=new TileComponent(undugStoneImage);
					tempPopup=new TilePopUpMenu();
					tempTile.setMapNode(tempMapNode);
					tempPopup.setTileMapNode(tempMapNode);
					tempPopup.setParent(this);
					tempTile.setComponentPopupMenu(tempPopup);
					break;}
			}
	

			
			mapPanel.add(tempTile);
		}
		
		mapPanel.repaint();
		mapPanel.validate();
		
	}
	
	public void refreshMap() {
		// TODO Auto-generated method stub
		this.putMap();
	}

}

