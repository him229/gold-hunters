package archeology;

import java.util.ArrayList;
/**
 * This class creates a MapNode with details about a particular square and is used to represent a single unit on the Map
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*
*/ 
public class MapNode 	{
	
	private int row;//private
	private int col;
	private char feature;
	String goldTest = "";
public String getGoldTest() {
		return goldTest;
	}
	public void setGoldTest(String goldTest) {
		this.goldTest = goldTest;
	}
public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public char getFeature() {
		return feature;
	}
	public void setFeature(char feature) {
		this.feature = feature;
	}
boolean dug;
boolean heritage;
ArrayList <MetalNode>metalList;
ArrayList <CharcoalNode>charcoalList;
ArrayList <PotteryNode>potteryList; //new array
/**
 * constructor
 *  
 */
public MapNode()
{
	row=0;
	col=0;
	feature=0;
	dug=false;
	heritage = false;
}
/**
 * @param date - date of find
 * 
 */
//=================================================================================================
public void addFerrousMetalNodes(int date, int strength)
{
	FerrousMetal met = new FerrousMetal(date, strength);
	metalList.add(met);
}
public boolean getHeritage(){
	return heritage;
}
public void addNonFerrousMetalNodes(int date, String strength)
{
	NonFerrousMetal nonMet = new NonFerrousMetal(date, strength);
	metalList.add(nonMet);
}
/**
 * @param date - date of find
 */
public void addKilnCharcoalNodes(int date, double radius)
{
	KilnsCharcoal kilnsCoal = new KilnsCharcoal(date, radius);
	charcoalList.add(kilnsCoal);
}
public void addHearthCharcoalNodes(int date, double length, double width)
{
	HearthsCharcoal HearthsCoal = new HearthsCharcoal(date, length, width);
	charcoalList.add(HearthsCoal);
}
/**
 * @param date - date of find
 *  
 */
public void addDecoratedPotteryNodes(int date, String describe) // static pottery array list above
{
	DecoratedPottery decoratedPot = new DecoratedPottery(date, describe);
	potteryList.add(decoratedPot);
}
public void addStoragePotteryNodes(int date, double volume) // static pottery array list above
{
	StoragePottery StoragePot = new StoragePottery(date, volume);
	potteryList.add(StoragePot);
}
public void addSubmergedPotteryNodes(int date, int depth) // static pottery array list above
{
	SubmergedPottery SubmergedPot = new SubmergedPottery(date, depth);
	potteryList.add(SubmergedPot);
}

//=================================================================================================
/**
 * 
 * @return potteryList - List of pottery nodes
 */
public ArrayList<PotteryNode> getPotteryNodes(){
	return potteryList;
}
/**
 * 
 * @return metalList - list of metal nodes
 */
public ArrayList<MetalNode> getMetalNodes(){
	return metalList;
}
/**
 * 
 * @return charcoalList - list of charcoal nodes
 */
public ArrayList<CharcoalNode> getCharcoalNodes(){
	return charcoalList;
}

public void markHeritage()
{
	heritage = true;
}

public int returnMetalValue(){
	int count_non=0;
	int count_fer=0;
	int num =0;
	if (metalList.size()==0){
		return 0;
	}
	for(MetalNode mn : metalList){
		num = mn.respondToMetalDetector();
		if(num==4){
			count_non = count_non+1;
		}
		else if(num==2){
			count_fer=count_fer+1;
		}
	}
	
	if ((count_non >0) && (count_fer>0)){
		return 6;
	}
	else if ((count_non>0)&& (count_fer==0)){
		return 4;
	}
	else if ((count_non==0)&& (count_fer>0)){
		return 2;}
	else return 0;
}
/**
 * @param row2, col2, feature2, dug2
 * @return 
 *  
 */
public void setFeature(String newFeature){
	char newFeature1 = newFeature.charAt(0);
	feature = newFeature1;
}
public void markExcavated(){
	dug=true;
}

public MapNode(int row2, int col2, char feature2, boolean dug2, boolean heritage2)
{
	row= row2;
	col=col2;
	feature=feature2;
	dug=dug2;
	heritage = heritage2;
	metalList=new ArrayList<MetalNode>();
	charcoalList=new ArrayList<CharcoalNode>();
	potteryList=new ArrayList<PotteryNode>();
}
public boolean getDug() {

	// TODO Auto-generated method stub
	return dug;
}}

