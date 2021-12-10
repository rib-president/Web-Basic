package practice_6.Question04.Q08_03;

public class SoundableExample {
	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());
	}

	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}	
}
