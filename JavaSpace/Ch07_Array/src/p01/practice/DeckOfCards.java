package p01.practice;

//	카드게임(Space, Heart, Diamond, Club)
//	1.deck원소의 값
//	- 0~12 => Spades(0: Ace, 12: King)		=> 13으로 나누면 값이 0
//	- 13~25 => Hearts(13: Ace, 25: King)	=> 13으로 나누면 값이 1
//	- 26~38 => Diamonds(26: Ace, 38: King)	=> 13으로 나누면 값이 2
//	- 39~51 => Clubs(39: Ace, 51: King)		=> 13으로 나누면 값이 3
public class DeckOfCards {
	public static void main(String[] args) {
		int[] deck = new int[52];	// deck : 카드 전체 52장을 관리하는 변수
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "Jack", "Queen", "King"};
		
		//	52장 초기 카드 순서대로 초기화
		for(int i=0;i<deck.length;i++) {
			deck[i] = i;
		}
		
//		for(int element : deck) {
//			System.out.println(element);
//		}
		
		//	카드 섞기
		for(int i=0;i<deck.length;i++) {
			// 0~51의 랜덤한 수
			int index = (int)(Math.random()*deck.length);
			//	random으로 가져온 index에 해당하는 deck[index]의 카드값과
			//	deck[i]의 카드값을 서로 교환
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		
		//	첫번째부터 5번째까지의 카드 정보
		for(int i=0;i<5;i++) {
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			System.out.println("Card Number " + deck[i] + " : "
					 + suit + "의 " + rank);
		}
		
		
	}
}
