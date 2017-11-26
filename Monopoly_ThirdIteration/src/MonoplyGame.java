
import java.util.Scanner;
public class MonoplyGame {
	public void startGame() throws Exception{
		int numberOfPlayers=1;
		int numberOfTurns=1;
		
		Player player;
		Die d1=new Die();
		Die d2=new Die();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of players:");	
		numberOfPlayers=sc.nextInt();

		Board board=new Board();
		board.setSquares();
		board.setPlayers(numberOfPlayers);
		
		System.out.println("Enter the number of turns that played:");
		numberOfTurns=sc.nextInt();
		
		int currentTurn=1;
		int playerNumber;
		//turn until the counter reach number Of turns that given from user or all of the players go bankruptcy.
		while((currentTurn!=numberOfTurns+1) && numberOfPlayers>1){
			playerNumber=(currentTurn-1)%numberOfPlayers;

			player = board.pArr.get(playerNumber);
			System.out.println(player.getName() + "'s turn");
			
			//determine if the player ,which in the jail, pay money to exit from jail, randomly. 
			if( ((int)(Math.random()*2)) == 1   &&   player.money.getAmount() >= 50   &&   player.timeInJail > 0){
				player.money.updateMoney(-50);
				player.timeInJail=0;
				System.out.println(player.getName() + " give 50$ to exit from Jail");
			}
			
			d1.roll();
			d2.roll();
			int sumOfDice=d1.getFaceValue()+d2.getFaceValue();
			System.out.println(player.getName() + "'s piece is located on " + (player.piece.squareOn.getSpaceFromFirstSquare()+1)+". square (" +board.sArr.get(player.piece.squareOn.getSpaceFromFirstSquare()).getName() + ")");
			System.out.println("Dice are rolling...\n   " + d1.getFaceValue() + "    "+ d2.getFaceValue() + "\nSum of the numbers on dice is:"+ sumOfDice);
			
			//Player can move if he is not in the jail or the dices that thrown by him are double although he is in jail
			if(d2.getFaceValue()==d1.getFaceValue() || player.timeInJail<=0 ){
				if(d2.getFaceValue()==d1.getFaceValue() && player.timeInJail<=0 && (player.piece.squareOn.getSpaceFromFirstSquare()+sumOfDice)!=30 ){
					player.numberOfDoubleDice++;
					currentTurn--;			
				}
				else{
					player.numberOfDoubleDice=0;
					player.timeInJail=0;
				}
				//Check if player throw double dice three times in a row and that cause him to go to jail. 
				if(player.numberOfDoubleDice==3){
					player.movePiece(30-player.piece.squareOn.getSpaceFromFirstSquare());
					currentTurn++;
					continue; 
				}

				System.out.println(player.getName() + "'s piece move to " +(player.piece.squareOn.getSpaceFromFirstSquare()+1+sumOfDice)%40 + ". square ("+board.sArr.get((player.piece.squareOn.getSpaceFromFirstSquare()+sumOfDice)%40).getName()+")");
				
				//if the player is goes bankruptcy then movePiece() function turns zero and the number of players decrease by one   
				if(player.movePiece(sumOfDice)==0){
					numberOfPlayers--;
					currentTurn--;
				}
				else{
					System.out.println(player.getName() + " has " + player.money.getAmount() + "$\n" );					
				}
				
				//if player located on the jail square is oriented to other jail square that visitors can visit them 
				if(player.piece.squareOn.getSpaceFromFirstSquare()==30){
					player.movePiece(20);
				}
				currentTurn++;
			}
			else{
				System.out.println(player.getName() + "'s piece contiune to stay in Jail\n");
				player.timeInJail--;
				currentTurn++;
			}
			
		}
		System.out.println("\n\n********************Game is Over**********************");
	}
	
}

