import java.util.*;

public class Board {
	public ArrayList<Player> pArr;
	public Board(){
		pArr=new ArrayList<Player>();
	}
	public void setPlayers(int numberOfPlayers){
		String name;
		Player p=new Player();
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=1;i<=numberOfPlayers;i++){
			System.out.println("Enter"+i+". player name:");
			name=sc.nextLine();
			pArr.add(new Player());
			p=pArr.get(i-1);
			p.name=name;
			
		}
	}
}
