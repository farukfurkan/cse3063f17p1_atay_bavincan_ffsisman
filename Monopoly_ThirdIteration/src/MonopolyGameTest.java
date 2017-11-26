import static org.junit.Assert.*;

import org.junit.Test;

public class MonopolyGameTest {

	@Test
	public void test() {
	    //check the giveMoney function in IncomeTaxSquare works correctly
		Board board=new Board();
		Player player=new Player(board);
		player.piece.squareOn=new IncomeTaxSquare(4);
		for(int i=0;i<1000;i++){
			player.money.setAmount((int)(Math.random()*100)+75);
			int oldMoney=player.money.getAmount();
			((IncomeTaxSquare)player.piece.squareOn).giveMoney(player);
			int newMoney=player.money.getAmount();
			int expectedMoney=oldMoney-oldMoney/10;
			assertEquals(newMoney,expectedMoney);
		}
		
	}
	@Test
	public void test2(){
		 //check the giveMoney function in LuxuryTaxSquare works correctly
		Board board=new Board();
		Player player=new Player(board);
		player.piece.squareOn=new LuxuryTaxSquare(38);
		for(int i=0;i<1000;i++){
			player.money.setAmount((int)(Math.random()*100)+75);
			int oldMoney=player.money.getAmount();
			((LuxuryTaxSquare)player.piece.squareOn).giveMoney(player);
			int newMoney=player.money.getAmount();
			int expectedMoney=oldMoney-75;
			assertEquals(newMoney,expectedMoney);
		}
	}
	
	@Test
	public void test3(){
		 //check the collectMoney function in GoSquare works correctly
		Board board=new Board();
		Player player=new Player(board);
		player.piece.squareOn=new GoSquare(0);
		for(int i=0;i<1000;i++){
			player.money.setAmount((int)(Math.random()*100)+75);
			int oldMoney=player.money.getAmount();
			((GoSquare)player.piece.squareOn).collectMoney(player);;
			int newMoney=player.money.getAmount();
			int expectedMoney=oldMoney+200;
			assertEquals(newMoney,expectedMoney);
		}
	}

}
