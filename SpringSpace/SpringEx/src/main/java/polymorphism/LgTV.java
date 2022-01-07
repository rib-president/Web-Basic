package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	@Autowired	// DI(setter 안 만들어도 됨)
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("LG TV 생성됨1");
	}

	public void powerOn() {
		System.out.println("LG TV --- 전원을 켠다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

	public void powerOff() {
		System.out.println("LG TV --- 전원을 끈다.");
	}

}
