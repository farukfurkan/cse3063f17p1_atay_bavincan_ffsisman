
public class Player {
	private String name;
	public Piece piece;
	public Money money;
	public int timeInJail;
	public int numberOfDoubleDice;
	
	public Player(Board b){
		this.piece= new Piece(b);
		money=new Money();
		name=name;
		piece.squareOn.setSpaceFromFirstSquare(0);
		timeInJail=0;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public int movePiece(int sumOfDice){
		return piece.Move(sumOfDice,this);
	}
}
