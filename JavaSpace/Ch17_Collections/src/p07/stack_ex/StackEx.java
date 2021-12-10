package p07.stack_ex;

import java.util.*;

public class StackEx {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전 : " + coin.getValue() + "원");
		}

//		FIFO로 꺼내짐
//		for(Coin coin : coinBox) {
//			System.out.println("꺼내온 동전 : " + coin.getValue() + "원");		
//		}

	}
}
