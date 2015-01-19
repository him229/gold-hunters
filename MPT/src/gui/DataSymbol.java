package gui;
/**
 * This class is the data storage place for Symbol Dialogue 
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
public class DataSymbol {
	private String symbol;
	private String uStone;
	private String uPit;
	private String uNatural;
	private String dNatural;
	private String dPit;
	private String dStone;
	public DataSymbol(){
		setSymbol(new String(""));
		setuPit(new String(""));
		setuStone(new String(""));
		setuNatural(new String(""));
		setdNatural(new String(""));
		setdStone(new String(""));
		setdPit(new String(""));
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getuNatural() {
		return uNatural;
	}
	public void setuNatural(String uNatural) {
		this.uNatural = uNatural;
	}
	public String getuPit() {
		return uPit;
	}
	public void setuPit(String uPit) {
		this.uPit = uPit;
	}
	public String getuStone() {
		return uStone;
	}
	public void setuStone(String uStone) {
		this.uStone = uStone;
	}
	public String getdNatural() {
		return dNatural;
	}
	public void setdNatural(String dNatural) {
		this.dNatural = dNatural;
	}
	public String getdPit() {
		return dPit;
	}
	public void setdPit(String dPit) {
		this.dPit = dPit;
	}
	public String getdStone() {
		return dStone;
	}
	public void setdStone(String dStone) {
		this.dStone = dStone;
	}

}
