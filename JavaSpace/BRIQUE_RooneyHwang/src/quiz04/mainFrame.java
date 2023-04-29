package quiz04;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class mainFrame extends JFrame implements ActionListener {
	
	private JTextField[] temper = new JTextField[12];
	private JTextField[] moist = new JTextField[12];
	
	private JScrollPane scrolledTable;
	private JTable table;
	private JLabel label;
	private JButton addBtn;
	private JButton randBtn;
	
	public mainFrame() {
		
		setTitle("브릭 코딩테스트_황루니");
		this.setLayout(new BorderLayout(10,10));
		
		JPanel topPanel=new JPanel(new GridLayout(6,4,10,5));

		for(int i=0;i<12;i++) {
			topPanel.add(new JLabel((i+1) + "월"));
	
			temper[i]=new JTextField(30);
			moist[i]=new JTextField(30);
			topPanel.add(temper[i]);
			topPanel.add(moist[i]);
			temper[i].setText("0");
			moist[i].setText("0");
		}
		topPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.add("North",topPanel);	
		
		String header[]= {" ", "평균 기온", "평균 습도"};
		DefaultTableModel model=new DefaultTableModel(header,0);
		
		table=new JTable(model);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrolledTable=new JScrollPane(table);
		scrolledTable.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));	
		this.add("Center",scrolledTable);		
		
		
		JPanel rightPanel=new JPanel(new GridLayout(5,1,10,10));
		
		addBtn=new JButton("테이블 갱신");
		randBtn = new JButton("random");
		
		rightPanel.add(addBtn);
		rightPanel.add(randBtn);
		rightPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		this.add("East",rightPanel);
		
		JPanel southPanel = new JPanel();
		label = new JLabel("");
		southPanel.add(label);
		this.add("South", southPanel);
		 
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(620,620);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		addBtn.addActionListener(this);	
		randBtn.addActionListener(this);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		if(table.getRowCount() > 0) {
			int length = table.getRowCount();
			for(int i=0;i<length;i++) {

				model.removeRow(0);			
			}			
		}	
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("avg temperature");
	    XYSeries series2 = new XYSeries("avg moist");
		
		 if(e.getSource() == randBtn) {
			for(int i=0;i<12;i++) {
				temper[i].setText(String.valueOf(Math.round(Math.random()*10000)/100.0));
				moist[i].setText(String.valueOf(Math.round(Math.random()*10000)/100.0));
				
			}
		}
		
		for(int i=0;i<12;i++) {
			String[] record=new String[3]; 
			try {
			record[0] = (i+1) + "month";			
			record[1] = temper[i].getText();
			record[2] = moist[i].getText();
			
			series1.add((i+1), Double.valueOf(record[1]));
			series2.add((i+1), Double.valueOf(record[2]));
			} catch(Exception ex) {
				label.setText("숫자가 아닌 값이 있음");
				return;
			}
			model.addRow(record);
		}
		
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		JFreeChart chart = ChartFactory.createXYLineChart("chart", "month", "number",
				dataset);
	
		Chart ch = new Chart(chart);
		ch.openChart();

	}

}
