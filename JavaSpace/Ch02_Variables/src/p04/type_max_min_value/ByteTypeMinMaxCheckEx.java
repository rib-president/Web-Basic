package p04.type_max_min_value;

public class ByteTypeMinMaxCheckEx {
	public static void main(String[] args) {
		int num = 121;
		
		if ( (num < Byte.MIN_VALUE) || ( num > Byte.MAX_VALUE)) {
			System.out.println("byte 타입으로 변환할 수 없습니다.");
		} else {
			byte bNum = (byte)num;
			System.out.println("bNum = " + bNum);
		}
		
	}
}
