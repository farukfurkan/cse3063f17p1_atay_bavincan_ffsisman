

public class Player {
	private String name;
	private int RRCount;
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
	
	public void setRRCount(int c){
		this.RRCount=c;
	}
	public int getRRCount(){
		return this.RRCount;
	}
	
	public int movePiece(int sumOfDice){
		return piece.Move(sumOfDice,this);
	}
	
	public void attemptPurchase(RegularSquare s){
		Die d=new Die();
		d.roll();
		System.out.println(d.getFaceValue());
		if(d.getFaceValue()>=4){
			int pr=s.getPrice();
			if(this.money.getAmount() >= pr){
				s.setOwner(this);
				this.money.updateMoney(-pr);
				System.out.println(this.name+" purchase the"+ s.getName());
			}
		}
	}
}
