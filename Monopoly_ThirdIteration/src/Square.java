

abstract class Square {
	private int spaceFromFirstSquare=0;
	private String name="Regular square";
	public void  setName(String name){
		this.name=name;
	}
	public String getName(){
			return this.name;																
	}
	public void setSpaceFromFirstSquare(int distance){
		this.spaceFromFirstSquare=distance;
	}
	public int getSpaceFromFirstSquare(){
		return this.spaceFromFirstSquare;
	}
}

class GoSquare extends Square{
	public GoSquare(int distance){
		super.setName("Go Square");
		super.setSpaceFromFirstSquare(distance);
	}
	public void collectMoney(Player p){
		int salary=200;
		p.money.updateMoney(salary);
	}
}
class JailSquare extends Square{
	public JailSquare(int distance){
		super.setName("Jail Square");
		super.setSpaceFromFirstSquare(distance);
	}
	public void goToJail(Player p){
		p.timeInJail=3;
	}

}
class FreeParkingSquare extends Square{
	public FreeParkingSquare(int distance){
		super.setName("Free Parking Square");
		super.setSpaceFromFirstSquare(distance);
	}
}
class IncomeTaxSquare extends Square{
	public IncomeTaxSquare(int distance){
		super.setName("Income Tax Square");
		super.setSpaceFromFirstSquare(distance);
	}
	public void giveMoney(Player p){
		int tax=p.money.getAmount() / 10;
		p.money.updateMoney(-tax);
	}
}
class LuxuryTaxSquare extends Square{
	public LuxuryTaxSquare(int distance){
		super.setName("Luxury Tax Square");
		super.setSpaceFromFirstSquare(distance);
	}
	public void giveMoney(Player p){
		int tax=75;
		p.money.updateMoney(-tax);
	}
}

abstract class RegularSquare extends Square{
	private int rent;
	private int price;
	private Player owner;
	private int isOwned=0;
	
	public void setRent(int rent){
		this.rent=rent;
	}
	public int getRent(){
		return this.rent;	
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	public int getPrice(){
		return this.price;	
	}
	
	public void setOwner(Player owner){
		this.owner=owner;
	}
	public Player getOwner(){
		return this.owner;	
	}
	
	public void setIsOwned(int status){
		this.isOwned=status;
	}
	public int getIsOwned(){
		return this.isOwned;	
	}
	
	public RegularSquare(int distance,int price,int rent, String name){
		super.setSpaceFromFirstSquare(distance);
		this.owner=new Player(null);
		this.price=price;
		this.rent=rent;
		this.setName(name);
	}
	public void landedOn(Player p){
		if(isOwned==0){
			p.attemptPurchase(this);
		}
		else{
			payRent(p);
		}
	}
	public void payRent(Player p){
		p.money.updateMoney(-rent);
		owner.money.updateMoney(rent);
		System.out.println(p.getName() + "give " + this.rent + " to " + this.owner.getName() +" as rent" );
	}
		
}

class LotsSquare extends RegularSquare{
	
	
	public LotsSquare(int distance,int price,int rent,String name) {
		super(distance,price,rent,name);
	}

	public int getRent(){
		return this.getRent();
	}

}
class RailRoadSquare extends RegularSquare{
	
	public RailRoadSquare(int distance,int price,int rent,String name) {
		super(distance,price,rent,name);
	}

	public int getRent(){
		int c=getOwner().getRRCount();
		return c*25; 
	}

	public void payRent(Player p){
		int r=getRent();
		p.money.updateMoney(-r);
		getOwner().money.updateMoney(r);
		System.out.println(p.getName() + "give " + this.getRent() + " to " + this.getOwner().getName() +" as rent" );
	}
	public void landedOn(Player p){
		if(super.getIsOwned()==0){
			p.attemptPurchase(this);
		}
		else{
			payRent(p);
		}
	}
}
class UtilitySquare extends RegularSquare{
		
	
	public UtilitySquare(int distance,int price,int rent,String name) {
		super(distance,price,rent,name);
	}
	public int getRent(){
		Cup c=new Cup();
		int tot=c.getTotal();
		return tot*10;
	}
	public void payRent(Player p){
		int r=getRent();
		p.money.updateMoney(-r);
		getOwner().money.updateMoney(r);
		System.out.println(p.getName() + "give " + this.getRent() + " to " + this.getOwner().getName() +" as rent" );
	}
	public void landedOn(Player p){
		if(super.getIsOwned()==0){
			p.attemptPurchase(this);
		}
		else if(getOwner()!=p) {
			payRent(p);
		}
	}
}
class EmptySquare extends Square{
	public EmptySquare(int distance){
		super.setName("Empty Square");
		super.setSpaceFromFirstSquare(distance);
	}
}