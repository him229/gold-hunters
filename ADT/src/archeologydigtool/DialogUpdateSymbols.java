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
 * Builds GUI for Updating Symbols
 * @author karentrevino
 */
public class DialogUpdateSymbols extends JDialog implements ActionListener{
    
    private static final long serialVersionUID = 6542587319791401131L;
    private JButton buttonYes;
    private JButton buttonNo;
    private JTextField textFieldUndugStone;
    private JTextField textFieldDugStone;
    private JTextField textFieldUndugPit;
    private JTextField textFieldDugPit;
    private JTextField textFieldUndugNatural;
    private JTextField textFieldDugNatural;
    private JLabel labelUndugStone;
    private JLabel labelDugStone;
    private JLabel labelUndugPit;
    private JLabel labelDugPit;
    private JLabel labelUndugNatural;
    private JLabel labelDugNatural;
    private char undugStone;
    private char dugStone;
    private char undugPit;
    private char dugPit;
    private char undugNat;
    private char dugNat;
    private DataSymbols localDataSymbols;
    
    /**
     * Builds GUI for Updating Symbols
     */
    public DialogUpdateSymbols()
    {
        this.setTitle("Update Symbols");
        Container content = this.getContentPane();
        GridLayout layout = new GridLayout(4,2);
        content.setLayout(layout);
        buttonYes=new JButton("Yes");
        buttonNo=new JButton("No");
        labelUndugStone=new JLabel("Undug stone ");
        labelDugStone=new JLabel("Dug stone ");
        labelUndugPit=new JLabel("Undug pit ");
        labelDugPit=new JLabel("Dug pit ");
        labelUndugNatural=new JLabel("Undug natural ");
        labelDugNatural=new JLabel("Dug natural ");

        textFieldUndugStone=new JTextField();
        textFieldDugStone=new JTextField();
        textFieldUndugPit=new JTextField();
        textFieldDugPit=new JTextField();
        textFieldUndugNatural=new JTextField();
        textFieldDugNatural=new JTextField();

        this.add(labelUndugStone);
        this.add(textFieldUndugStone);
        this.add(labelDugStone);
        this.add(textFieldDugStone);
        this.add(labelUndugPit);
        this.add(textFieldUndugPit);
        this.add(labelDugPit);
        this.add(textFieldDugPit);
        this.add(labelUndugNatural);
        this.add(textFieldUndugNatural);
        this.add(labelDugNatural);
        this.add(textFieldDugNatural);

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
            undugStone = this.textFieldUndugStone.getText().charAt(0);
            dugStone = this.textFieldDugStone.getText().charAt(0);
            undugPit = this.textFieldUndugPit.getText().charAt(0);
            dugPit = this.textFieldDugPit.getText().charAt(0);
            undugNat = this.textFieldUndugNatural.getText().charAt(0);
            dugNat = this.textFieldDugNatural.getText().charAt(0);

            localDataSymbols.setUndugStone(undugStone);
            localDataSymbols.setDugStone(dugStone);
            localDataSymbols.setUndugPit(undugPit);
            localDataSymbols.setDugPit(dugPit);
            localDataSymbols.setUndugNatural(undugNat);
            localDataSymbols.setDugStone(dugNat);
            this.setVisible(false);
            dispose();
        }
        else if (e.getActionCommand()=="No")
        {
            this.setVisible(false);
            this.setModal(false);
            dispose();
        }

    }

    /**
     * Sets DataSymbols
     * @param dataSymbols
     */
    public void setDataSymbols(DataSymbols dataSymbols) {
            // TODO Auto-generated method stub
            localDataSymbols=dataSymbols;
    }
    
    
}
