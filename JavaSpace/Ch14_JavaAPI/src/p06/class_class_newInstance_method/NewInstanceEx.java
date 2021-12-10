package p06.class_class_newInstance_method;

public class NewInstanceEx {
	public static void main(String[] args) {

		String sendName = "p06.class_class_newInstance_method.SendAction";
		String receiveName = "p06.class_class_newInstance_method.ReceiveAction";
		String name;
		
		try {
			//name = sendName;
			name = receiveName;
			Class cls = Class.forName(name);

			Action action = (Action)cls.newInstance();
			action.excute();
		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {
			System.out.println("InstantiationException 발생");
		} catch (IllegalAccessException e) {

		}

	}
}
