package p02.nested_interface;

public class Button {
	OnClickListener listener;
	
	//	setter method	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	interface OnClickListener {
		void onClick();
	}
}
