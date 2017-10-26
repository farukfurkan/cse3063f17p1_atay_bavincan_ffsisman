import java.util.*;
public class MonoplyGame {
	public void startGame(){
		int numberOfPlayers=1;
		int numberOfTurns=1;
		Player player=new Player();
		Die d1=new Die();
		Die d2=new Die();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of players:");	
		numberOfPlayers=sc.nextInt();

		Board board=new Board();
		board.setPlayers(numberOfPlayers);
		
		System.out.println("Enter the number of turns that played:");
		numberOfTurns=sc.nextInt();
		
		int currentTurn=1;
		int playerNumber;
		while(currentTurn!=numberOfTurns+1){
			playerNumber=(currentTurn-1)%numberOfPlayers;

			player = board.pArr.get(playerNumber);
			System.out.println(player.name+"'s turn");
			
			d1.roll();
			d2.roll();
			int sumOfDice=d1.getFaceValue()+d2.getFaceValue();
			System.out.println("Dice are rolling...\nSum of the numbers on dice is:"+ sumOfDice);
			
			System.out.print(player.name+"'s piece is move from " + (player.p.squareOn.spaceFromFirstSquare+1)+". square");
			player.movePiece(sumOfDice);
			
			System.out.println(" to "+(player.p.squareOn.spaceFromFirstSquare+1)+". square\n");
		
			currentTurn++;
		}
		System.out.println("\n\n********************Game is Over**********************");
	}
	
}
