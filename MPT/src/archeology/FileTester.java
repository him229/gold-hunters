
package archeology;
/**
 * This class reads from the file
 * Inspired by Dr. Becker's Basic GUI Example 
 *@author himankyadav
 *Himank Yadav
 *UTA ID - 1000958091
 *Date - 11.25.2014
*/ 
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTester {
	
	int colNum;
    int rowNum;
    char featureLetter;
    boolean dugBoolean;
    boolean heritageBoolean;
	
    /**
     *
     * @param filename
     * @param mapData
     */
    public void testFile(String filename, MapData mapData)
    {
        File inputFile=new File(filename);

        try
        {
            Scanner input=new Scanner(inputFile);
            String newline;

            if (input.hasNextLine())
            {
                newline=input.nextLine();
                String [] tokens = newline.split(",");
                mapData.setUserRow(Integer.valueOf(tokens[1]));
                mapData.setUserCol(Integer.valueOf(tokens[0]));
                
                mapData.setRowMax(Integer.valueOf(tokens[1]));
                mapData.setColMax(Integer.valueOf(tokens[0]));
            }

             ArrayList<MapNode> myMap;
             myMap = mapData.getMapNodes();


            while (input.hasNextLine())
            {
                newline=input.nextLine();
                String line []=newline.split(",");

                int pos=0;

                //System.out.println("============");
                pos=doSquare(line,pos);//Ends at BR 29
                MapNode mapNode = new MapNode(rowNum, colNum, featureLetter, dugBoolean, heritageBoolean);


                pos=doPots(line,pos,mapNode);//Ends at BR 29
                pos=doCoal(line,pos,mapNode);//Ends at BR 29
                pos=doMetal(line,pos,mapNode);//Ends at AM 9
                myMap.add(mapNode);

            }


            input.close();
            mapData.setMapNodeList(myMap);
            }
            catch (Exception e)
            {

            }
    }

    private int doCoal(String[] line, int pos, MapNode mapNode) {
        String coal;
        int coalMax;
        coal=line[pos];
        pos=pos+1;
        coalMax=Integer.parseInt(coal,10);
        //System.out.printf("Charcoal: %d\n",coalMax);
        int countCoal=0;
        String coalType;
        String coalRadius;
        String coalLength;
        String coalWidth;
        String coalYear;
        while (countCoal<coalMax)
        {
                //System.out.printf("%d:",countCoal);
                coalType=line[pos];
                pos=pos+1;

                switch (coalType)
                {
                case "Kiln":

                        coalRadius=line[pos];
                        pos=pos+1;
                        coalYear=line[pos];
                        pos=pos+1;
                        //System.out.printf("\tKiln \t%s\t%s",coalRadius,coalYear);
                        mapNode.addKilnCharcoalNodes(Integer.parseInt(coalYear),Double.parseDouble(coalRadius));
                        break;
                case "Hearth":

                        coalLength=line[pos];
                        pos=pos+1;
                        coalWidth=line[pos];
                        pos=pos+1;
                        coalYear=line[pos];
                        pos=pos+1;
                        //System.out.printf("\tHearth\t%s\t%s\t%s",coalLength,coalWidth,coalYear);
                        mapNode.addHearthCharcoalNodes(Integer.parseInt(coalYear),Double.parseDouble(coalLength),Double.parseDouble(coalWidth));
                        break;
                default:
                        //System.out.printf("%s\n",coalType);
                }
                //System.out.printf("\n");
                countCoal=countCoal+1;
        }
        return pos;
    }

    private int doMetal(String[] line, int pos, MapNode mapNode) {

        String metal;
        int metalMax;
        metal=line[pos];
        pos=pos+1;
        metalMax=Integer.parseInt(metal,10);
        //System.out.printf("MetalWork: %d\n",metalMax);
        int countMetal=0;
        String metalType;
        String metalKind;
        String metalStrength;
        String metalYear;
        while (countMetal<metalMax)
        {
                //System.out.printf("%d:",countMetal);
                metalType=line[pos];
                pos=pos+1;
                switch (metalType)
                {
                case "Non-Ferrous":

                        metalKind=line[pos];
                        pos=pos+1;
                        metalYear=line[pos];
                        pos=pos+1;
                        //System.out.printf("\tNon-Ferrous\t%s\t%s",metalKind,metalYear);
                        mapNode.addNonFerrousMetalNodes(Integer.parseInt(metalYear), metalType);
                        break;
                case "Ferrous":

                        metalStrength=line[pos];
                        pos=pos+1;
                        metalYear=line[pos];
                        pos=pos+1;
                       // System.out.printf("\tFerrous    \t%s\t%s",metalStrength,metalYear);
                        mapNode.addFerrousMetalNodes(Integer.parseInt(metalYear), Integer.parseInt(metalStrength));
                        break;
                default:
                        //System.out.printf("%s\n",metalType);
                }
                //System.out.printf("\n");
                countMetal=countMetal+1;
        }
        return pos;
    }

    private int doPots(String line [],int pos, MapNode mapNode)
    {
        String pots;
        int potMax;
        pots=line[pos];
        pos=pos+1;
        potMax=Integer.parseInt(pots,10);
        //System.out.printf("Pots: %d\n",potMax);
        int countPot=0;
        String potType;
        String potVol;
        String potDecor;
        String potDepth;
        String potYear;

        int year;
        double volume;
        while (countPot<potMax)
        {
                //System.out.printf("%d:",countPot);
                potType=line[pos];
                pos=pos+1;
                switch (potType)
                {
                case "Storage":

                        potVol=line[pos];
                        pos=pos+1;
                        potYear=line[pos];
                        pos=pos+1;
                        year = Integer.parseInt(potYear);
                        volume = Double.parseDouble(potVol);

                        //System.out.printf("\tStorage \t%s\t%s",potVol,potYear);
                        mapNode.addStoragePotteryNodes(year, volume);


                        break;
                case "Decorated":

                        potDecor=line[pos];
                        pos=pos+1;
                        potYear=line[pos];
                        pos=pos+1;
                        //System.out.printf("\tDecorated\t%s\t%s",potDecor,potYear);
                        mapNode.addDecoratedPotteryNodes(Integer.parseInt(potYear), potDecor);
                        break;
                case "Submerged":

                        potDepth=line[pos];
                        pos=pos+1;
                        potYear=line[pos];
                        pos=pos+1;
                        //System.out.printf("\tSubmerged\t%s\t%s",potDepth,potYear);
                        mapNode.addSubmergedPotteryNodes(Integer.parseInt(potYear), Integer.parseInt(potDepth));
                        break;
                default:
                        //System.out.printf("%s\n",potType);
                }
                //System.out.printf("\n");
                countPot=countPot+1;
        }
        return pos;
    }

    private int doSquare(String[] line, int pos) {
            String col;
            String row;
            String feature;
            String dug;
            String heritage;

            col=line[pos];
            pos=pos+1;
            row=line[pos];
            pos=pos+1;
            feature=line[pos];
            pos=pos+1;
            dug=line[pos];
            pos=pos+1;
            heritage=line[pos];
            pos=pos+1;

            colNum = MapData.stringToInt(col); 
            rowNum = Integer.valueOf(row);
            featureLetter = feature.charAt(0);
            dugBoolean = dug.equals("TRUE");
            heritageBoolean = heritage.equals("TRUE");



            //System.out.printf("Col %s, Row %s\n",col,row);
           
            //System.out.printf("%s,%s,%s\n",feature,dug,heritage);

            return pos;
    }
}