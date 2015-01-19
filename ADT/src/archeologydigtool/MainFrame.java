/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */
package archeologydigtool;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;


public class MainFrame extends JFrame implements ActionListener{

    JPanel tilePanel;
    JLabel statusBar;
    private MyPopUpMenu testMenu;

    private static final long serialVersionUID = 1156392119668344557L;

    //*******************************************************
    //
    //     The Subcontroller
    //
    //*******************************************************
    private SubController subController;

    //*******************************************************
    //
    //     The Map
    //
    //*******************************************************

    private MapData mapData;

    //*******************************************************
    //
    //     The Menus
    //
    //*******************************************************
    private static final String commandLoad="Load";
    private static final String commandSave="Save";
    private static final String commandExit="Exit";


    private static final String commandDig = "Dig";
    private static final String commandMagnetometer = "Scan with Magnetometer";
    private static final String commandMetalDetector = "Scan with Metal Detector";

    private static final String commandShowMap="View Map";
    private static final String commandShowMetalDetector="View Metal Detector Map";
    private static final String commandShowMagnetometer="View Magnetometer Map";
    private static final String commandShowPotteryFinds="View Pottery Finds Map";
    private static final String commandShowCharcoalFinds="View Charcoal Finds Map";
    private static final String commandShowMetalFinds="View Metal Finds Map";
    private static final String commandShowReport="View Report";

    private static final String commandAbout="About";

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuItemLoad;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemExit;

    private JMenu menuEdit;
    private JMenuItem menuItemDig;
    private JMenuItem menuItemMagnetometer;
    private JMenuItem menuItemMetalDetector;

    private JMenu menuView;
    private JMenuItem menuItemShowMap;
    private JMenuItem menuItemShowMetalDetector;
    private JMenuItem menuItemShowMagnetometer;
    private JMenuItem menuItemShowPotteryFinds;
    private JMenuItem menuItemShowCharcoalFinds;
    private JMenuItem menuItemShowMetalFinds;
    private JMenuItem menuItemShowReport;

    private JMenuItem menuItemAbout;

    //==============================================
    //
    // Dialog Boxes and Datastores
    //
    //==============================================	

    private DialogLoad tempDialogLoad;
    private DataLoad tempDataLoad;
    private DialogScan tempDialogMagnetometer;
    private DialogScan tempDialogMetalDetector;
    private DialogScan tempDialogDig;
    private DataSquare tempDataSquare;

    //*******************************************************
    //
    // The Text Area
    //
    //*******************************************************

    //JTextArea textArea;
    JScrollPane scrollPane;
    Container content;
	
	public MainFrame()
	{
                super ("MainFrame");
		Container contentPane=this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		statusBar=new JLabel("Load File");
		contentPane.add(statusBar,BorderLayout.SOUTH);
		
		tilePanel=new JPanel();
		tilePanel.setLayout(new GridLayout(30,70));
		
		contentPane.add(tilePanel,BorderLayout.CENTER);
	
			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(tilePanel);
		this.pack();

		this.setSize(new Dimension(1100,830));
		this.setVisible(true);
                
                //==================================================
                mapData=new MapData();
                //==================================================
                subController=new SubController();
                subController.setMapData(mapData);
                subController.setTilePanel(tilePanel);
                //==================================================
                MakeMenus();
                //MakeTextArea();
                MakeDialogAndData();	
               
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mainFrame=new MainFrame();
                mainFrame.run();
		
	}
        
        private JMenuItem makeMenuItem(String sLabel)
    {
        JMenuItem miTemp=null;
        miTemp=new JMenuItem(sLabel);
        miTemp.addActionListener(this);
        return miTemp;
    }

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

        menuItemLoad=makeMenuItem(commandLoad);
        menuItemSave=makeMenuItem(commandSave);
        menuItemExit=makeMenuItem(commandExit);
        menuFile.add(menuItemLoad);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemExit);
        menuBar.add(menuFile);

        //===========================
        //Edit Menu
        //===========================
        menuEdit=new JMenu("Edit");

        menuItemDig = makeMenuItem(commandDig);
        menuItemMagnetometer = makeMenuItem(commandMagnetometer);
        menuItemMetalDetector = makeMenuItem(commandMetalDetector);

        menuEdit.add(menuItemDig);
        menuEdit.add(menuItemMagnetometer);
        menuEdit.add(menuItemMetalDetector);
        menuBar.add(menuEdit);

        //===========================
        //View Menu
        //===========================
        menuView=new JMenu("View");

        menuItemShowMap=makeMenuItem(commandShowMap);
        menuItemShowMagnetometer=makeMenuItem(commandShowMagnetometer);
        menuItemShowMetalDetector=makeMenuItem(commandShowMetalDetector);
        menuItemShowPotteryFinds=makeMenuItem(commandShowPotteryFinds);
        menuItemShowCharcoalFinds=makeMenuItem(commandShowCharcoalFinds);
        menuItemShowMetalFinds=makeMenuItem(commandShowMetalFinds);
        menuItemShowReport=makeMenuItem(commandShowReport);

        menuView.add(menuItemShowMap);
        menuView.add(menuItemShowMagnetometer);
        menuView.add(menuItemShowMetalDetector);
        menuView.add(menuItemShowPotteryFinds);
        menuView.add(menuItemShowCharcoalFinds);
        menuView.add(menuItemShowMetalFinds);
        menuView.add(menuItemShowReport);


        menuBar.add(menuView);

        //===========================
        //About Menu Item
        //===========================
        menuItemAbout=makeMenuItem(commandAbout);
        menuBar.add(menuItemAbout);

    }
        
        @Override
    public void actionPerformed(ActionEvent arg0) {

        String command="";
        command=arg0.getActionCommand();

        switch(command)
        {
        case commandLoad:
            subController.load();
            statusBar.setText("File loaded");
            validate();
            repaint();
            break;
        case commandSave:
            subController.save();
            statusBar.setText("File saved");
            break;
        case commandExit:
            subController.exit();
            break;		
        case commandMagnetometer:
            tempDialogMagnetometer.setDataSquare(tempDataSquare);
            tempDialogMagnetometer.setModal(true);
            tempDialogMagnetometer.setVisible(true);
            subController.magnetometer(tempDataSquare.getRow(), tempDataSquare.getCol());
            statusBar.setText("Scanned with Magnetometer");
            validate();
            repaint();
            break;
        case commandMetalDetector:
            tempDialogMetalDetector.setDataSquare(tempDataSquare);
            tempDialogMetalDetector.setModal(true);
            tempDialogMetalDetector.setVisible(true);
            subController.metalDetector(tempDataSquare.getRow(), tempDataSquare.getCol());
            statusBar.setText("Scanned with Metal Detector");
            validate();
            repaint();
            break;
        case commandDig:
            tempDialogDig.setDataSquare(tempDataSquare);
            tempDialogDig.setModal(true);
            tempDialogDig.setVisible(true);
            subController.dig(tempDataSquare.getRow(), tempDataSquare.getCol());
            statusBar.setText("Digged");
            validate();
            repaint();
            break;
        case commandShowMap:
            subController.showMap();
            statusBar.setText("Viewing Map");
            validate();
            repaint();
            break;

        case commandShowMetalDetector:
            subController.showMetalDetector();
            statusBar.setText("Showing Metal Detector Map");
            validate();
            repaint();
            break;
        case commandShowMagnetometer:
            subController.showMagnetometer();
            statusBar.setText("Showing Magnetometer Map");
            validate();
            repaint();
            break;
        case commandShowPotteryFinds:
            subController.showPotteryFinds();
            statusBar.setText("Showing Pottery Finds Map");
            validate();
            repaint();
            break;
        case commandShowCharcoalFinds:
            subController.showCharcoalFinds();
            statusBar.setText("Showing Charcoal Finds Map");
            validate();
            repaint();
            break;
        case commandShowMetalFinds:
            subController.showMetalFinds();
            statusBar.setText("Showing Metal Finds Map");
            validate();
            repaint();
            break;
        case commandShowReport:
            subController.showReport();
            break;
        case commandAbout:
            //JOptionPane.showMessageDialog(main, "DD");
            subController.about();
            break;

        }


    }
    
    private void MakeDialogAndData() 
    {
        tempDataLoad=new DataLoad();
        tempDialogLoad=new DialogLoad();
        tempDialogMagnetometer = new DialogScan(1);
        tempDialogMetalDetector = new DialogScan(2);
        tempDialogDig = new DialogScan(3);
        tempDataSquare = new DataSquare();
    }
    
    public void run()
    {
        this.setVisible(true);
    }
    
    public void setBar(){
    
    }
 

}