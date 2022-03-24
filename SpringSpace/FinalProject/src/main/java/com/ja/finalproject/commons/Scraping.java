package com.ja.finalproject.commons;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;

public class Scraping {
	
	@Scheduled(fixedDelay = 10000)
	public void scraping() {
		try {
			String URL = "http://designnine.co.kr/project/project_list1.html?PHPSESSID=7cb3863d8bc2b28eb99a337710148688";
			Connection conn = Jsoup.connect(URL);
			
			Document document = conn.get();
			
			Element parsingTable = document.getElementsByTag("table").get(16);
			
			Element parsingTr = parsingTable.getElementsByTag("tr").get(12);

			Element parsingTd = parsingTr.getElementsByTag("td").get(0);

			Element parsingDiv = parsingTd.getElementsByTag("div").get(0);

			String board_no = parsingDiv.text();
			System.out.println(board_no);
			
			String scrapURL = "http://designnine.co.kr/project/project_view2.html?num=" + board_no + "&start=0";
			conn = Jsoup.connect(scrapURL);
			
			document = conn.get();
			document.outputSettings(new Document.OutputSettings().prettyPrint(false)); //makes html() preserve linebreaks and spacing
			
			Elements parsingPs = document.getElementsByClass("MsoNormal");

		    
		    parsingPs.select("br").append("\\n");		    
		    String s = parsingPs.html().replaceAll("\\\\n", "\n").replaceAll("&nbsp;", " ");;

		    String a = Jsoup.clean(s, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
		    
			System.out.println(a);
//			for(Element e : parsingPs) {
//				System.out.println(e.text());
//			}
		    
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
