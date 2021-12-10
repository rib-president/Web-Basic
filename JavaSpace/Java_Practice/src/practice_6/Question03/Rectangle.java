package practice_6.Question03;

public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle rect = (Rectangle)obj;
			if(this.width == rect.width && this.height == rect.height)
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "넓이 : " + width + ", 길이 : " + height;
	}
	
}
