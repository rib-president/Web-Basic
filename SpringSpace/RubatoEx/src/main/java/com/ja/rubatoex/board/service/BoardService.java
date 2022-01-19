package com.ja.rubatoex.board.service;

import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ja.rubatoex.board.mapper.BoardSQLMapper;
import com.ja.rubatoex.vo.BoardImageVO;
import com.ja.rubatoex.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
//	public ArrayList<BoardVO> getBoardList() {
//		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectAllBoard();
//		return titleEscape(resultVOList);
//	}
//	
//	public ArrayList<BoardVO> getBoardByTitle(String title) {
//		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectBoardByTitle(title);
//		
//		return titleEscape(resultVOList);
//	}
//	
//	public ArrayList<BoardVO> getBoardByContent(String content) {
//		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectBoardByContent(content);
//		return titleEscape(resultVOList);
//	}
//	
//	public ArrayList<BoardVO> getBoardByWriter(int member_no) {
//		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectBoardByWriter(member_no);
//		return titleEscape(resultVOList);
//	}
	
	public ArrayList<BoardVO> getBoardList(String category,
			String keyword, int page) {
		return titleEscape(boardSQLMapper.selectBoardList(category, keyword, page));
	}
	
	public int getCountBoard(String category, String keyword) {
		return boardSQLMapper.selectCountBoard(category, keyword);
	}

	public BoardVO getBoard(int no, boolean isEscape) {
		BoardVO resultVO = boardSQLMapper.selectBoardByNo(no);
		
		if(isEscape) {
			titleEscape(resultVO);
			contentEscape(resultVO);
		}
		
		return resultVO;
	}
	
	public ArrayList<BoardImageVO> getBoardImage(int board_no) {
		return boardSQLMapper.selectBoardImageByBoardNo(board_no);
	}
		
	public void increaseReadCount(int no) {
		boardSQLMapper.updateBoardReadCount(no);
	}
	
	public void deleteBoard(int no) {
		boardSQLMapper.deleteBoard(no);
		boardSQLMapper.deleteBoardImage(no);
	}
	
	public void deleteBoardImageByNo(int no) {
		boardSQLMapper.deleteBoardImageByNo(no);
	}
	
	public void writeBoard(BoardVO boardVO, ArrayList<BoardImageVO> boardImageVOList) {
		int board_no = boardSQLMapper.createBoardPK();
		
		boardVO.setBoard_no(board_no);
		boardSQLMapper.insertBoard(boardVO);
		
		for(BoardImageVO boardImageVO : boardImageVOList) {
			boardImageVO.setBoard_no(board_no);
			boardSQLMapper.insertBoardImage(boardImageVO);
		}
	}
	
	public void modifyBoard(BoardVO vo, ArrayList<BoardImageVO> boardImageVOList) {
		boardSQLMapper.updateBoard(vo);
		
		for(BoardImageVO boardImageVO : boardImageVOList) {
			boardImageVO.setBoard_no(vo.getBoard_no());
			boardSQLMapper.insertBoardImage(boardImageVO);
		}
	}
	
	public ArrayList<BoardVO> get4Board() {
		ArrayList<BoardVO> resultVOList = boardSQLMapper.select4Board();

		return titleEscape(resultVOList);
	}
	
	public ArrayList<BoardVO> titleEscape(ArrayList<BoardVO> voList) {
		for(BoardVO vo : voList) {
			vo.setBoard_title(StringEscapeUtils.escapeHtml4(vo.getBoard_title())
					.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));
		}
		return voList;
	}
	
	public BoardVO titleEscape(BoardVO vo) {
		vo.setBoard_title(StringEscapeUtils.escapeHtml4(vo.getBoard_title())
		.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));

		return vo;
	}
	
	public BoardVO contentEscape(BoardVO vo) {
		vo.setBoard_content(StringEscapeUtils.escapeHtml4(vo.getBoard_content())
		.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));

		return vo;
	}
	
	public String makeTailParam(String category, String keyword) {
		String tailParam = "";
		if(category != null) {			
			try {
				tailParam += "&category=" + URLEncoder.encode(category, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(keyword != null) {
			try {
				tailParam += "&keyword=" + URLEncoder.encode(keyword, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		return tailParam;
	}
	
	public ArrayList<BoardImageVO> setUploadFiles(MultipartFile[] uploadFiles) {
		ArrayList<BoardImageVO> boardImageVOList = new ArrayList<>();
		
		String rootPath = "C:/uploadfolder/"; 
		String childPath = new SimpleDateFormat("yyyy/MM/dd/")
							.format(new Date());
		File todayFolder = new File(rootPath + childPath);
		
		if(!todayFolder.exists()) {
			todayFolder.mkdirs();
		}

		for(MultipartFile uploadFile : uploadFiles) {
			String originalFilename = uploadFile.getOriginalFilename();
			
			String filename = UUID.randomUUID().toString()
					+ "_" + System.currentTimeMillis();
			filename += originalFilename.substring(originalFilename.lastIndexOf("."));
			
			try {
				uploadFile.transferTo(new File(rootPath + childPath
					 + filename));
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			BoardImageVO boardImageVO = new BoardImageVO();
			boardImageVO.setImage_url(childPath + filename);
			boardImageVO.setImage_original_filename(originalFilename);
			
			boardImageVOList.add(boardImageVO);				
		}
		
		return boardImageVOList;
	}
	
}
