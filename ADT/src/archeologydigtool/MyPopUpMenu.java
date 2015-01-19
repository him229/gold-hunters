/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author karentrevino
 */
public class MyPopUpMenu extends JPopupMenu implements ActionListener {

	private JMenuItem dig;
	private JMenuItem scanMagneto;
        private JMenuItem scanMetal;
        private TileComponent mapNode;
        private SubController subcontroller;
	
    /**
     *
     * @param mapNode1
     */
    public MyPopUpMenu(TileComponent mapNode1)
	{
		dig=new JMenuItem("Dig");
		scanMagneto = new JMenuItem("Scan with Magnetometer");
                scanMetal = new JMenuItem("Scan with MetalDetector");
                
		this.add(dig);
		this.add(scanMagneto);
                this.add(scanMetal);
		dig.addActionListener(this);
		scanMagneto.addActionListener(this);
                scanMetal.addActionListener(this);
                
                mapNode = mapNode1;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
                String command = arg0.getActionCommand();
                
                switch (command){
                    case "Dig":
                        DigMap.process(mapNode);
                        break;
                    case "Scan with Magnetometer":
                        ScanMap.process(mapNode, 1);
                        break;
                    case "Scan with MetalDetector":
                        ScanMap.process(mapNode, 2);
                        break;
                        
                }
	}
        
    /**
     *
     * @param subcontroller1
     */
    public void setSub(SubController subcontroller1){
            subcontroller = subcontroller1;
        }

}
