package gui;
/**
 * This class creates a dialogue for Assigning a symbol
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

public class DialogueSymbol extends JDialog implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldSymbol;
	JLabel labelSymbol;
	String symbol;
	String unStone;
	String unPit;
	String unNatural;
	String eNatural;
	String ePit;
	String eStone;
	private DataSymbol localDataSymbol;
	JTextField textFieldUndugPit;
	JTextField textFieldUndugStone;
	JTextField textFieldUndugNatural;
	JTextField textFieldDugPit;
	JTextField textFieldDugStone;
	JTextField textFieldDugNatural;
	
	public DialogueSymbol()
	{
		this.setTitle("Change Symbols");
		Container content = this.getContentPane();
		buttonYes=new JButton("Yes");
		buttonYes.setBounds(6, 260, 188, 59);
		buttonNo=new JButton("No");
		buttonNo.setBounds(375, 260, 169, 59);
		labelSymbol=new JLabel("Feature (NPS)");
		labelSymbol.setBounds(61, 10, 188, 31);
		getContentPane().setLayout(null);
		
		getContentPane().add(labelSymbol);
		textFieldSymbol=new JTextField();
		textFieldSymbol.setBounds(319, 6, 142, 39);
		getContentPane().add(textFieldSymbol);
		
		
		getContentPane().add(buttonYes);
		getContentPane().add(buttonNo);
		
		textFieldUndugPit = new JTextField();
		textFieldUndugPit.setBounds(115, 83, 134, 28);
		getContentPane().add(textFieldUndugPit);
		textFieldUndugPit.setColumns(10);
		
		textFieldUndugStone = new JTextField();
		textFieldUndugStone.setBounds(115, 136, 134, 28);
		getContentPane().add(textFieldUndugStone);
		textFieldUndugStone.setColumns(10);
		
		textFieldUndugNatural = new JTextField();
		textFieldUndugNatural.setBounds(115, 206, 134, 28);
		getContentPane().add(textFieldUndugNatural);
		textFieldUndugNatural.setColumns(10);
		
		textFieldDugPit = new JTextField();
		textFieldDugPit.setBounds(404, 83, 134, 28);
		getContentPane().add(textFieldDugPit);
		textFieldDugPit.setColumns(10);
		
		textFieldDugStone = new JTextField();
		textFieldDugStone.setBounds(404, 136, 134, 28);
		getContentPane().add(textFieldDugStone);
		textFieldDugStone.setColumns(10);
		
		textFieldDugNatural = new JTextField();
		textFieldDugNatural.setBounds(404, 206, 134, 28);
		getContentPane().add(textFieldDugNatural);
		textFieldDugNatural.setColumns(10);
		
		JLabel lblUndugpit = new JLabel("UndugPit");
		lblUndugpit.setBounds(20, 89, 61, 16);
		getContentPane().add(lblUndugpit);
		
		JLabel lblUndugstone = new JLabel("UndugStone");
		lblUndugstone.setBounds(20, 142, 83, 16);
		getContentPane().add(lblUndugstone);
		
		JLabel lblUndugnatural = new JLabel("UndugNatural");
		lblUndugnatural.setBounds(6, 212, 97, 16);
		getContentPane().add(lblUndugnatural);
		
		JLabel lblDugpit = new JLabel("DugPit");
		lblDugpit.setBounds(330, 89, 61, 16);
		getContentPane().add(lblDugpit);
		
		JLabel lblDugstone = new JLabel("DugStone");
		lblDugstone.setBounds(319, 142, 61, 16);
		getContentPane().add(lblDugstone);
		
		JLabel lblDugnatural = new JLabel("DugNatural");
		lblDugnatural.setBounds(309, 212, 83, 16);
		getContentPane().add(lblDugnatural);


		buttonYes.addActionListener(this);
		buttonNo.addActionListener(this);

		setSize(544,341);
	}

	public void setDataSymbol (DataSymbol dataSymbol)
	{
		localDataSymbol = dataSymbol;
		return;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if  (e.getActionCommand()=="Yes")
		{
			
			symbol=this.textFieldSymbol.getText();
			unStone = this.textFieldUndugStone.getText();
			unPit = this.textFieldUndugPit.getText();
			unNatural=this.textFieldUndugNatural.getText();
			eNatural = this.textFieldDugNatural.getText();
			ePit = this.textFieldDugPit.getText();
			eStone = this.textFieldDugStone.getText();
		
			localDataSymbol.setSymbol(symbol);
			localDataSymbol.setuNatural(unNatural);
			localDataSymbol.setuPit(unPit);
			localDataSymbol.setuStone(unStone);
			localDataSymbol.setdNatural(eNatural);
			localDataSymbol.setdPit(ePit);
			localDataSymbol.setdStone(eStone);
			
		
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
