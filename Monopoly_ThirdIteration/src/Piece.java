
public class Piece {
	public Board board;
	public Square squareOn;
	public Piece(Board board){
		this.board=board;
		squareOn=new GoSquare(0);
	}
	public int Move(int n,Player p){
		int newLocation= squareOn.getSpaceFromFirstSquare() + n;
		newLocation%=40;
		this.squareOn=board.sArr.get(newLocation);
		switch(newLocation){
			case 0:
				//go square
				((GoSquare)squareOn).collectMoney(p);
				System.out.println(p.getName() + " take 200$");
				break;
			case 2:
				//empty square
				break;
			case 4:
				// income tax square square
				((IncomeTaxSquare)squareOn).giveMoney(p);
				System.out.println(p.getName() + " give %10 of his money as tax");
				break;
			case 5:
				//Rail Road 1
				((RailRoadSquare)squareOn).landedOn(p);
				break;
			case 7:
				//empty square
				break;
			case 10:
				//visitor square
				if(p.timeInJail<=0){
					System.out.println(p.getName() + " visit the players that stay in jail");
				}	
				break;
			case 12:
				//Electricity utility square
				((UtilitySquare)squareOn).landedOn(p);
				break;
			case 15:
				//Rail Road 2
				((RailRoadSquare)squareOn).landedOn(p);
				break;
			case 20:
				//free parking square
				System.out.println(p.getName() + "'s piece at parking");
				break;
			case 25:
				//Rail Road 3
				((RailRoadSquare)squareOn).landedOn(p);
				break;
			case 28:
				//Water Utility
				((UtilitySquare)squareOn).landedOn(p);
				break;
			case 30:
				//go to jail square
				((JailSquare)squareOn).goToJail(p);
				System.out.println(p.getName() + " is going to jail");
				break;
			case 35:
				//Rail Road 4
				((RailRoadSquare)squareOn).landedOn(p);
				break;
			case 36:
				//empty square
				break;
			case 38:
				//luxury tax square
				((LuxuryTaxSquare)squareOn).giveMoney(p);
				System.out.println(p.getName() + " give 75$ as tax");
				break;
			default:
				//lots square
				((LotsSquare)squareOn).landedOn(p);
				break;
		}
		if(p.money.getAmount()<0){
			System.out.println(p.getName() + " goes bankruptcy");
			board.pArr.remove(p);
			return 0;
		}
		squareOn.setSpaceFromFirstSquare(newLocation);
		return 1;

	}
}

