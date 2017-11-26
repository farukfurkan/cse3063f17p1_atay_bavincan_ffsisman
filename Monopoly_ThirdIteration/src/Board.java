
import java.util.*;
import java.io.*;
import com.opencsv.CSVReader;

import java.io.*;
public class Board {
	public ArrayList<Square> sArr;
	public ArrayList<Player> pArr;
	public Board(){
		sArr=new ArrayList<Square>();
		pArr=new ArrayList<Player>();
	}
	
	public void setSquares() throws Exception{
		for(int i=0;i<40;i++){
			switch(i){
				case 0:
					//go square
					sArr.add(new GoSquare(i));
					break;
				case 1:
					//lots square
					sArr.add(new LotsSquare(i,60,2,"Square 2"));
					break;
				case 2:
					//empty square
					sArr.add(new EmptySquare(i));
					break;
				case 3:
					//lots square
					sArr.add(new LotsSquare(i,60,4,"Square 4"));
					break;
				case 4:
					//income tax square
					sArr.add(new IncomeTaxSquare(i));
					break;
				case 5:
					//Rail Road 1
					sArr.add(new RailRoadSquare(i,150,0,"RailRoad"));
					break;
				case 6:
					//lots square
					sArr.add(new LotsSquare(i,100,6,"Square 7"));
					break;
				case 7:
					//empty square
					sArr.add(new EmptySquare(i));
					break;
				case 8:
					//lots square
					sArr.add(new LotsSquare(i,100,6,"Square 9"));
					break;
				case 9:
					//lots square
					sArr.add(new LotsSquare(i,120,8,"Square 10"));
					break;
				case 10:	
					//visitor square
					sArr.add(new JailSquare(i));
					break;
				case 11:
					//lots square
					sArr.add(new LotsSquare(i,140,10,"Square 12"));
					break;
				case 12:
					//Electricity Utility
					sArr.add(new UtilitySquare(i,150,0,"Electricity Square"));
					break;
				case 13:
					//lots square
					sArr.add(new LotsSquare(i,140,10,"Square 14"));
					break;
				case 14:
					//lots square
					sArr.add(new LotsSquare(i,160,12,"Square 15"));
					break;
				case 15:
					//rail Road 2
					sArr.add(new RailRoadSquare(i,150,0,"Rail Road 1"));
					break;
				case 16:
					//lots square
					sArr.add(new LotsSquare(i,60,2,"Square 17"));
					break;
				case 17:
					//lots square
					sArr.add(new LotsSquare(i,180,14,"Square 18"));
					break;
				case 18:
					//lots square
					sArr.add(new LotsSquare(i,180,14,"Square 19"));
					break;
				case 19:
					//lots square
					sArr.add(new LotsSquare(i,200,16,"Square 20"));
					break;
				case 20:
					//free parking square
					sArr.add(new FreeParkingSquare(i));
					break;
				case 21:
					//lots square
					sArr.add(new LotsSquare(i,60,2,"Square 22"));
					break;
				case 22:
					//lots square
					sArr.add(new LotsSquare(i,220,18,"Square 23"));
					break;
				case 23:
					//lots square
					sArr.add(new LotsSquare(i,200,18,"Square 24"));
					break;
				case 24:
					//lots square
					sArr.add(new LotsSquare(i,240,20,"Square 25"));
					break;
				case 25:
					//Rail Road 3
					sArr.add(new RailRoadSquare(i,150,0,"Rail Road 3"));
					break;
				case 26:
					//lots square
					sArr.add(new LotsSquare(i,260,22,"Square 27"));
					break;
				case 27:
					//lots square
					sArr.add(new LotsSquare(i,260,22,"Square 28"));
					break;
				case 28:
					//Water Utility
					sArr.add(new UtilitySquare(i,150,0,"Water Square"));
					break;
				case 29:
					//lots square
					sArr.add(new LotsSquare(i,280,24,"Square 30"));
					break;
				case 30:
					//go to jail square
					sArr.add(new JailSquare(i));
					break;
				case 31:
					//lots square
					sArr.add(new LotsSquare(i,300,26,"Square 32"));
					break;
				case 32:
					//lots square
					sArr.add(new LotsSquare(i,300,26,"Square 33"));
					break;
				case 33:
					//lots square
					sArr.add(new LotsSquare(i,300,26,"Square 34"));
					break;
				case 34:
					//lots square
					sArr.add(new LotsSquare(i,320,28,"Square 35"));
					break;
				case 35:
					//Rail Road 4
					sArr.add(new RailRoadSquare(i,150,0,"Rail Road 4"));
					break;
				case 36:
					//empty square
					sArr.add(new EmptySquare(i));
					break;
				case 37:
					//lots square
					sArr.add(new LotsSquare(i,350,35,"Square 38"));
					break;
				case 38:
					//luxury tax square
					sArr.add(new LuxuryTaxSquare(i));
					break;
				case 39:
					//lots square
					sArr.add(new LotsSquare(i,400,50,"Square 40"));
					break;
				default:
					break;
			}
		}

			//CSVReader reader = new CSVReader(new FileReader("Monopoly-Lots.csv"));
			//String [] nextLine;
			//while ((nextLine = reader.readNext()) != null) {
			    // nextLine[] is an array of values from the line
			//    System.out.println(nextLine[0] + nextLine[1] + "etc...");
			//}
		
	}
	
	public void setPlayers(int numberOfPlayers){
		String name;
		Player p=new Player(this);
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=1;i<=numberOfPlayers;i++){
			System.out.println("Enter"+i+". player name:");
			name=sc.nextLine();
			pArr.add(new Player(this));
			p=pArr.get(i-1);
			p.setName(name);
			
		}
	}
	
}
