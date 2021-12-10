package p01.basic;

//	배열원소 중 최대값 찾기
public class ArrayBasic7 {
	public static void main(String[] args) {
		double[] myList = new double[10];
		
		for(int i=0;i<myList.length;i++) {
			myList[i] = Math.random()*100;
		}
		

		for(double element : myList) {
			System.out.println(element);
		}
		
		double max = myList[0];
		for(int i=1;i<myList.length;i++) {
			if(myList[i] > max) {
				max = myList[i];
			}
		}
		
		System.out.println("max = " + max);
	}
}
