package gui;
/**
 * This class creates a dialogue for finding a squares location
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class DialogueLocation extends JDialog implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldRow;
	JTextField textFieldCol;
	JLabel labelRow;
	JLabel labelCol;
	String row;
	String col;
	private DataLocation localDataLocation;
	
	public DialogueLocation()
	{
		this.setTitle("Set Location");
		Container content = this.getContentPane();
		buttonYes=new JButton("Yes");
		buttonYes.setBounds(6, 260, 188, 59);
		buttonNo=new JButton("No");
		buttonNo.setBounds(375, 260, 169, 59);
		labelRow=new JLabel("Row");
		labelRow.setBounds(98, 131, 62, 31);
		labelCol=new JLabel("Column");
		labelCol.setBounds(98, 46, 72, 39);
		textFieldCol=new JTextField();
		textFieldCol.setBounds(302, 46, 142, 39);
		getContentPane().setLayout(null);
				
		
		getContentPane().add(labelCol);
		getContentPane().add(textFieldCol);
		
		getContentPane().add(labelRow);
		textFieldRow=new JTextField();
		textFieldRow.setBounds(302, 127, 142, 39);
		getContentPane().add(textFieldRow);
		
		
		getContentPane().add(buttonYes);
		getContentPane().add(buttonNo);


		buttonYes.addActionListener(this);
		buttonNo.addActionListener(this);

		setSize(544,341);
	}

	public void setDataLocation (DataLocation dataLocation)
	{
		localDataLocation = dataLocation;
		return;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if  (e.getActionCommand()=="Yes")
		{
			
			row=this.textFieldRow.getText();
			col=this.textFieldCol.getText();
			localDataLocation.setRow(row);
			localDataLocation.setCol(col);
			this.setVisible(false);
			this.setModal(false);
			dispose();
		}
		else if (e.getActionCommand()=="No")
		{
			this.setVisible(false);
			this.setModal(false);
			dispose();
		}
		
		
	}
	
	
}

