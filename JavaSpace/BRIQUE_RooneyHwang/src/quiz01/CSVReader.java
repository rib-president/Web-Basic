package quiz01;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CSVReader {
	private File csvFile;
	
	public CSVReader() {
		this.csvFile = new File("src/quiz01/sample.csv");
	}
	
	public CSVReader(File csvFile) {
		this.csvFile = csvFile;
	}
	
	public void read() {		
		
		BufferedReader br = null;
		String readLine = "";
		
		ArrayList<String> nonNumList = new ArrayList<>();
		
		int totalCnt = 0;
		int calCnt = 0;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			
			try {
				while((readLine = br.readLine()) != null) {
					totalCnt++;
					String[] lineArr = readLine.split(",");
					
					List<String> noNums = String.join("", lineArr).chars()
							.mapToObj(ch -> (char) ch)
							.filter(ch -> !Character.isDigit(ch))
							.map(Object::toString)
							.collect(Collectors.toList());
					if(noNums.size() != 0) {
						nonNumList.addAll(noNums);
						continue;
					} else {
						calCnt++;
						List<String> line = Arrays.asList(lineArr);														
						
						double min = line.stream().mapToDouble(num -> Double.valueOf(num)).min().getAsDouble();
						double max = line.stream().mapToDouble(num -> Double.valueOf(num)).max().getAsDouble();
						double sum = line.stream().mapToDouble(num -> Double.valueOf(num)).sum();
						double avg = line.stream().mapToDouble(num -> Double.valueOf(num)).average().getAsDouble();
						
						double ss = line.stream().mapToDouble(num -> Math.pow(Double.valueOf(num) - avg, 2.0)).sum();
						
						double std = Math.sqrt(ss / (line.size()-1));
						
						double median = 0;
						if(line.size() % 2 == 0) {
							List<Double> boxedList = line.stream().mapToDouble(num -> Double.valueOf(num)).sorted().boxed().collect(Collectors.toList());
							median = (boxedList.get((line.size() / 2) - 1) + boxedList.get(line.size() / 2)) / 2;
						} else {
							median = line.stream().mapToDouble(num -> Double.valueOf(num)).sorted().boxed().collect(Collectors.toList()).get(line.size() / 2);

						}
						
						
						System.out.println(min + " " + max + " " + sum + " " + avg + " " + std + " " + median);						
						
					}		
				}
			} catch (IOException e) {
				System.out.println("입출력 에러 ] " + e.getMessage());
			}
			System.out.println("---------------------------------");
			System.out.println("The total number of lines: " + totalCnt);
			System.out.println("The calculated lines: " + calCnt);
			System.out.print("The error values:");
			nonNumList.stream().forEach(x -> System.out.print(" " + x));
			

			
		} catch (FileNotFoundException e) {
			System.out.println("경로에 파일이 없습니다 ] " + e.getMessage());
		} 

	}
	
}
