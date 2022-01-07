package polymorphism;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		// aaa.xml을 load하여 컨테이너 가동
		GenericXmlApplicationContext container = 
				new GenericXmlApplicationContext("bbb.xml");
		
		//Dependency Lookup(의존성을 뽑아옴) -> 안 쓸것(DI쓸거임)
		TV tv = (TV) container.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
