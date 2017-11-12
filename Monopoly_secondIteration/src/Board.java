import java.util.*;

public class Board {
	public ArrayList<Square> sArr;
	public ArrayList<Player> pArr;
	public Board(){
		sArr=new ArrayList<Square>();
		pArr=new ArrayList<Player>();
	}
	
	public void setSquares(){
		for(int i=0;i<40;i++){
			switch(i){
				case 0:
					//go square
					sArr.add(new GoSquare(i));
					break;
				case 4:
					//income tax square
					sArr.add(new IncomeTaxSquare(i));
					break;
				case 10:	
					//visitor square
					sArr.add(new JailSquare(i));
					break;
				case 20:
					//free parking square
					sArr.add(new FreeParkingSquare(i));
					break;
				case 30:
					//go to jail square
					sArr.add(new JailSquare(i));
					break;
				case 38:
					//luxury tax square
					sArr.add(new LuxuryTaxSquare(i));
					break;
				default:
					//regular square
					sArr.add(new RegularSquare(i));
					break;
			}
		}
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
