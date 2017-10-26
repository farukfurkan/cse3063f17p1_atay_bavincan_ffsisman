
public class Player {
	public String name;
	public Piece p;

	public Player(){
		p= new Piece();
		name=name;
		p.squareOn.spaceFromFirstSquare=0;
	}
	public void movePiece(int sumOfDice){
		p.Move(sumOfDice);
	}
}
