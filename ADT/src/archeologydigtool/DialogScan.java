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
 * Builds GUI for scan and dig
 * @author karentrevino
 */
public class DialogScan extends JDialog implements ActionListener{
    private static final long serialVersionUID = 6542587319791401131L;
    private JButton buttonYes;
    private JButton buttonNo;
    private JTextField textFieldRow;
    private JTextField textFieldCol;
    private JLabel labelRow;
    private JLabel labelCol;
    private int row;
    private int col;
    private DataSquare localDataSquare;

    /**
     * Builds GUI for scan and dig
     * @param tool
     */
    public DialogScan(int tool)
    {
        if(tool == 1)
            this.setTitle("Scan with Magnetometer");
        else if(tool == 2)
            this.setTitle("Scan with Metal Detector");
        else if(tool == 3)
            this.setTitle("Dig a square");
        Container content = this.getContentPane();
        GridLayout layout = new GridLayout(3,2);
        content.setLayout(layout);
        buttonYes=new JButton("Yes");
        buttonNo=new JButton("No");
        labelRow=new JLabel("Row");
        labelCol = new JLabel("Column");
        textFieldRow=new JTextField();
        textFieldCol=new JTextField();


        this.add(labelCol);
        this.add(textFieldCol);

        this.add(labelRow);
        this.add(textFieldRow);

        this.add(buttonYes);
        this.add(buttonNo);

        buttonYes.addActionListener(this);
        buttonNo.addActionListener(this);

        setSize(300,200);

    }   
    
    public void actionPerformed(ActionEvent e) {

        if  (e.getActionCommand()=="Yes")
        {
            col= MapData.stringToInt(this.textFieldCol.getText());
            row= Integer.parseInt(this.textFieldRow.getText());

            //System.out.printf("row: %d col: %d\n", row, col);

            localDataSquare.setRow(row - 1);
            localDataSquare.setCol(col);

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
     * Sets datasquare
     * @param dataSquare
     */
    public void setDataSquare(DataSquare dataSquare) {
            // TODO Auto-generated method stub
            localDataSquare=dataSquare;
    }

}
