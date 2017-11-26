

public class Cup {
	private Die d1;
	private Die d2;
	public int getTotal(){
		d1=new Die();
		d2=new Die();
		
		d1.roll();
		d2.roll();
		
		return d1.getFaceValue()+d2.getFaceValue();		
	}
}
