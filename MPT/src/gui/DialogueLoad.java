package gui;
/**
 * This class creates a dialogue for Loading file
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class  DialogueLoad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;

	JTextArea textArea;
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	JScrollPane scrollPane;
	Container content;
	
	public DialogueLoad()
	{
		this.setTitle("Show Messages");
		content = this.getContentPane();
	
		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", 0, 10));
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
		//content = this.getContentPane();
		content.add(scrollPane, BorderLayout.CENTER);
		setSize(600,500);
	}

}