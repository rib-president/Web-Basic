import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TT implements Serializable, Cloneable{
	private final String name;
	public TT(String name) {
		this.name = name;
	}
	
	@Override
	protected TT clone() throws CloneNotSupportedException {
		return (TT)super.clone();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException{
		TT t1 = new TT("test");
		System.out.println(t1);
		TT t2 = t1.clone();
		System.out.println(t2);
		TT t3 = serializeAndDeserialize(t1);
		System.out.println(t3);
		TT t4 = t1;
		System.out.println(t4);
		
		System.out.println(t1 + ", " + t2 + ", " + t3 + ", " + t4);
	}
	
	private static TT serializeAndDeserialize(TT t1) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(t1);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
		return (TT)ois.readObject();
		
	}
}
