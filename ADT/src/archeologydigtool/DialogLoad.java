/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */

package archeologydigtool;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Builds GUI for loading file
 * @author karentrevino
 */
public class  DialogLoad extends JDialog implements ActionListener {

	private static final long serialVersionUID = 6542587319791401131L;
	private JButton buttonYes;
	private JButton buttonNo;
	private JTextField textFieldFile;
	private JLabel labelFile;
	private String filename;
	private DataLoad localDataLoad;
	
    /**
     * Builds GUI for loading a file
     */
    public DialogLoad()
    {
        this.setTitle("Load");
        Container content = this.getContentPane();
        GridLayout layout = new GridLayout(2,2);
        content.setLayout(layout);
        buttonYes=new JButton("Yes");
        buttonNo=new JButton("No");
        labelFile=new JLabel("File");

        textFieldFile=new JTextField();

        this.add(labelFile);
        this.add(textFieldFile);

        this.add(buttonYes);
        this.add(buttonNo);

        buttonYes.addActionListener(this);
        buttonNo.addActionListener(this);

        setSize(300,200);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        
        if  (e.getActionCommand()=="Yes")
        {

                filename=this.textFieldFile.getText();

                localDataLoad.setFilename(filename);
                this.setVisible(false);
                dispose();
        }
        else if (e.getActionCommand() == "No")
        {
                this.setVisible(false);
                this.setModal(false);
                dispose();
        }
    }

    /**
     * Sets dataload
     * @param dataLoad
     */
    public void setDataLoad(DataLoad dataLoad) {

        localDataLoad = dataLoad;
    }
	

	
	
}
