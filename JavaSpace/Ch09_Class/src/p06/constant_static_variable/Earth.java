package p06.constant_static_variable;


//	1.field를 final로 선언하면, field값을 수정하지 못함
//	2.instance field를 final을 사용하여 상수처럼 사용할 때 문제 있음
//	- new로 인스턴스를 만들어야지만 사용가능
//	- 인스턴스마다 만들어져서 다양한 값으로 초기화된 final 필드를 상수라고할 수 없음
//	3.Java에서는 상수를 만들 때 static final 사용
//	- 장점 : new로 인스턴스 만들지 않아도 되고, 하나의 상수만 존재
public class Earth {
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA = 4*Math.PI*EARTH_RADIUS*EARTH_RADIUS;

}
