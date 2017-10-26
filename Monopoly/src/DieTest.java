import static org.junit.Assert.*;

import org.junit.Test;

public class DieTest {

	@Test
	public void test() {
		Die die=new Die();
		int faceValue=1;
		for(int i=0;i<1000;i++){
			faceValue=die.roll();
			if(faceValue<2){
				assertEquals(1, faceValue);
			}
			if(faceValue>5)
				assertEquals(6,faceValue);
		}
	}

}
