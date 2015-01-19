package gui;
/**
 * This class creates a dialogue for Adding Finds
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

public class DialogueAddFinds extends JDialog implements ActionListener {


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
	String prop;
	String findType;
	private DataAddFinds localDataAddFinds;
	private JComboBox comboBox;
	String[] comboStrings = {"","Pottery Storage","Pottery Decorated","Pottery Submerged","Charcoal Kilns","Charcoal Hearths", "Metal Ferrous", "Metal Non-Ferrous"};
	private JTextField findField;
	
	
	public DialogueAddFinds()
	{
		this.setTitle("Add Finds");
		Container content = this.getContentPane();
		buttonYes=new JButton("Yes");
		buttonYes.setBounds(6, 260, 188, 59);
		buttonNo=new JButton("No");
		buttonNo.setBounds(375, 260, 169, 59);
		labelRow=new JLabel("Row");
		labelRow.setBounds(343, 56, 62, 31);
		labelCol=new JLabel("Column");
		labelCol.setBounds(333, 1, 72, 39);
		textFieldCol=new JTextField();
		textFieldCol.setBounds(402, 1, 142, 39);
		getContentPane().setLayout(null);
				
		
		getContentPane().add(labelCol);
		getContentPane().add(textFieldCol);
		
		getContentPane().add(labelRow);
		textFieldRow=new JTextField();
		textFieldRow.setBounds(402, 52, 142, 39);
		getContentPane().add(textFieldRow);
		
		
		getContentPane().add(buttonYes);
		getContentPane().add(buttonNo);
		
		comboBox = new JComboBox(comboStrings);
		comboBox.setBounds(6, 24, 286, 27);
		getContentPane().add(comboBox);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		
		findField = new JTextField();
		findField.setBounds(46, 165, 449, 28);
		getContentPane().add(findField);
		findField.setColumns(10);
		
		JLabel lblFindlabel = new JLabel("Please enter the find's property - Date, property/properties");
		lblFindlabel.setBounds(81, 139, 414, 16);
		getContentPane().add(lblFindlabel);

		buttonYes.addActionListener(this);
		buttonNo.addActionListener(this);

		setSize(544,341);
	}

	public void setDataAddFinds(DataAddFinds dataAddFinds)
	{
		localDataAddFinds=dataAddFinds;
		return;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == comboBox){
			JComboBox cb = (JComboBox)e.getSource();
			String msg = (String)cb.getSelectedItem();
			localDataAddFinds.setFindType(msg);
			/*switch(msg){
			case "Pottery Storage":
				 findType= findField.getText();
				break;
			case "Pottery Decorated":
				break;
			case "Pottery Submerged":
				break;
			case "Charcoal Kilns":
				break;
			case"Charcoal Hearths":
				break;
			case "Metal Ferrous":
				break;
			case "Metal Non-Ferrous":
				break;
			}*/
			
		}
		if  (e.getActionCommand()=="Yes")
		{
			
			row=this.textFieldRow.getText();
			col=this.textFieldCol.getText();
			prop=this.findField.getText();
			localDataAddFinds.setRow(row);
			localDataAddFinds.setCol(col);
			localDataAddFinds.setProperty(prop);
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

