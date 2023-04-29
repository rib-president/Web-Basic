package quiz05;

public class Main {
	public static void main(String[] args) {
		
		DataProcess dataProcess = new DataProcess();
		
		for(int i=0;i<100;i++) {		
			Request request = new Request();	
			String[] splitArr = dataProcess.getSplitData(request.call());
			
			String id = dataProcess.getId(splitArr);
			String quote = dataProcess.getQuote(splitArr);
			dataProcess.count(id);
			dataProcess.put(id, quote);
		}
		
		dataProcess.sortDesc();
		dataProcess.print();
	}
	
}
