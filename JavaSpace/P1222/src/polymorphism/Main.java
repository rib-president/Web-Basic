package polymorphism;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		User user = new User();
		user.watchingTv(new LgTv());
		
		String name = "samsung";	// 설정파일에서 로드한 문자가 samsung일 때
		
		TvContainer tvContainer = new TvContainer();
		
		user.watchingTv(tvContainer.getTv(name));
	}
}


class TvContainer {
	
	private HashMap<String, Tv> map = new HashMap<>();
	
	public TvContainer() {
		map.put("samsung", new SamsungTv());
		map.put("lg", new LgTv());
		map.put("test", new TestTv());
	}
	
	public Tv getTv(String name) {
		return map.get(name);
	}
}


class User {
	private Tv tv;
	
	// setter 주입
	public void setTv(Tv tv) {
		this.tv = tv;
	}
	
	public void watchingTv() {
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();

		System.out.println("TV 사용 프로그램 종료");
	}
	
	public void watchingTv(Tv tv) {
		// 삼성TV를 보는 로직 구현
//		SamsungTv tv = new SamsungTv();
//		
//		tv.turnOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.turnOff();

		// LG TV를 보는 로직 구현
//		LgTv tv = new LgTv();
//		tv.turnOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.turnOff();
		
//		Tv tv = new SamsungTv();
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();

		System.out.println("TV 사용 프로그램 종료");
	}	
}


interface Tv {
	public void turnOn();
	public void soundUp();
	public void soundDown();
	public void turnOff();
}


class SamsungTv implements Tv {
	// 응집도 : 삼성TV와 관련된 것만 모아둠
	public void turnOn() {
		System.out.println("삼성TV : 켭니다. ---로직(2천 라인)");
	}
	
	public void soundUp() {
		System.out.println("삼성TV : 소리를 올린다. ---로직(2천 라인)");		
	}
	
	public void soundDown() {
		System.out.println("삼성TV : 소리를 내린다. ---로직(2천 라인)");		
	}
	
	public void turnOff() {
		System.out.println("삼성TV : 끕니다. ---로직(2천 라인)");		
	}
}


class LgTv implements Tv {
	// 응집도 : LG TV와 관련된 것만 모아둠
	public void turnOn() {
		System.out.println("LG TV : 켭니다. ---로직(2천 라인)");
	}
	
	public void soundUp() {
		System.out.println("LG TV : 소리를 올린다. ---로직(2천 라인)");		
	}
	
	public void soundDown() {
		System.out.println("LG TV : 소리를 내린다. ---로직(2천 라인)");		
	}
	
	public void turnOff() {
		System.out.println("LG TV : 끕니다. ---로직(2천 라인)");		
	}
}


class TestTv implements Tv {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("테스트 켠다.");
	}

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		System.out.println("테스트 볼륨 올린다.");
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		System.out.println("테스트 볼륨 내린다.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("테스트 끈다.");		
	}
	
}









