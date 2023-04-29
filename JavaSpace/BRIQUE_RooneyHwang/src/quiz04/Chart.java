package quiz04;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class Chart extends JFrame {
	private ChartPanel cp; 

	Chart(JFreeChart chart) {
		cp = new ChartPanel(chart);
	}
	
	public void openChart() {
		this.add(cp);
		
		this.setSize(620,620);
		this.setVisible(true);
	}

}
