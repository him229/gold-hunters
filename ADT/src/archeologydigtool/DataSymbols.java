/*
 * @author karentrevino
 * 1000908298
 * Team Gold Hunters
 * Inspired by Dr. Becker's Mary Ellen Carter and MyPopUp Example
 * Last Modified: 11/24/14
 */
package archeologydigtool;

/**
 * This class stores the map symbols updated by the GUI
 * @author karentrevino
 */
public class DataSymbols {
    private char undugStone;
    private char dugStone;
    private char undugPit;
    private char dugPit;
    private char undugNat;
    private char dugNat;
    
    /**
     * Constructor for DataSymbols
     */
    public void DataSymbols(){
        
        undugStone = ' ';
        dugStone = ' ';
        undugPit = ' ';
        dugPit = ' ';
        undugNat = ' ' ;
        dugNat= ' ';
    }

    /**
     * This method sets the undug stone symbol
     * @param newChar
     */
    public void setUndugStone(char newChar){
        undugStone = newChar;
    }

    /**
     * This method sets the dug stone symbol
     * @param newChar
     */
    public void setDugStone(char newChar){
        dugStone = newChar;
    }

    /**
     * This method sets the undug pit symbol
     * @param newChar
     */
    public void setUndugPit(char newChar){
        undugPit = newChar;
    }

    /**
     * This method sets the dug pit symbol
     * @param newChar
     */
    public void setDugPit(char newChar){
        dugPit = newChar;
    }

    /**
     * This method sets the undug natural symbol
     * @param newChar
     */
    public void setUndugNatural(char newChar){
        undugNat = newChar;
    }

    /**
     * This method sets the dug natural symbol
     * @param newChar
     */
    public void setDugNatural(char newChar){
        dugNat = newChar;
    }
    
    /**
     * This method returns symbol for undug stone
     * @return
     */
    public char getUndugStone(){
        return undugStone;
    }
    
    /**
     * This method returns symbol for dug stone
     * @return
     */
    public char getDugStone(){
        return dugStone;
    }

    /**
     * This method returns symbol for undug pit
     * @return
     */
    public char getUndugPit(){
        return undugPit;
    }

    /**
     * This method returns symbol for dug pit
     * @return
     */
    public char getDugPit(){
        return dugPit;
    }

    /**
     * This method returns symbol for undug natural
     * @return
     */
    public char getUndugNatural(){
        return undugNat;
    }

    /**
     * This method returns symbol for dug natural
     * @return
     */
    public char getDugNatural(){
        return dugNat;
    }
    
}
