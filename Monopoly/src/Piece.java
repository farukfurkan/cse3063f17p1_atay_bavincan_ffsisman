
public class Piece {
	public Square squareOn;
	public Piece(){
		squareOn=new Square();
		squareOn.spaceFromFirstSquare=0;
	}
	public void Move(int n){
		squareOn.spaceFromFirstSquare+=n;
		if(squareOn.spaceFromFirstSquare >= 40){
			squareOn.spaceFromFirstSquare %=40;
		}
	}
}
