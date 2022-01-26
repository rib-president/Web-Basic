package com.lotto.shinnanda.commons;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.lotto.shinnanda.vo.BoardImageVo;

public class MultipartFileUtil {
	public static ArrayList<BoardImageVo> transferToUploadFolder(MultipartFile[] uploadFiles) {
		ArrayList<BoardImageVo> voList = new ArrayList<>();
		
		String uploadFolder = "C:/uploadfolder/";
		
		if(uploadFiles != null) {
			for(MultipartFile uploadFile : uploadFiles) {
				if(uploadFile.isEmpty()) {
					continue;
				}
				
				Date today = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
				String folderPath = sdf.format(today);
				
				File todayFolder = new File(uploadFolder + folderPath);
				
				if(!todayFolder.exists()) {
					todayFolder.mkdirs();
				}
				
				String fileName = "";
				
				UUID uuid = UUID.randomUUID();
				fileName += uuid.toString();
				fileName += "_" + System.currentTimeMillis();
				
				String originalFileName = uploadFile.getOriginalFilename();
				fileName += originalFileName.substring(originalFileName.lastIndexOf("."));
				
				try {
					uploadFile.transferTo(new File(uploadFolder + folderPath + fileName));
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				BoardImageVo boardImageVo = new BoardImageVo();
				boardImageVo.setImage_url(folderPath + fileName);
				boardImageVo.setImage_originalname(originalFileName);
				
				voList.add(boardImageVo);
			}
		}
		
		return voList;
	}
}
