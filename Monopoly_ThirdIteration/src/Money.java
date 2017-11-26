

public class Money {
	private int amount;
	
	public Money(){
		this.amount=200;
	}
	public void setAmount(int amount){
		this.amount=amount;
	}
	public int getAmount(){
		return this.amount;
	}
	public void updateMoney(int updateAmount){
		this.amount+=updateAmount;
	}
}

