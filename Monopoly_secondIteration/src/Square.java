
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
class RegularSquare extends Square{
	public RegularSquare(int distance){
		super.setSpaceFromFirstSquare(distance);
	}
}