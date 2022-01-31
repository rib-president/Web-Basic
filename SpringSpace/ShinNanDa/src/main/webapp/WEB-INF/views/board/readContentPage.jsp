<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<% pageContext.setAttribute("crlf","\r\n");%>
<% pageContext.setAttribute("lf","");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<script>
	function modifyCommentContent(comment_content, comment_no, board_no, pageNum, tailParam) {
		var fast_modify_comment = document.getElementsByClassName("cur_modify_comment");
		for(fmc of fast_modify_comment) {
			fmc.remove();
		}
		
		var div_hidden = document.getElementsByClassName("hidden_comment_box");
		for(dh of div_hidden) {
			dh.setAttribute("style", "visiblity: visible;");
		}
		
		var textarea = document.createElement("textarea");
		textarea.setAttribute("name", "comment_content");
		textarea.setAttribute("class", "form-control"); 

		var regex = /<br\s*[\/]?>/gi;
		comment_content = comment_content.replace(regex,"\r\n");
		textarea.value = comment_content;
		
		var hidden_comment_no = document.createElement("input");
		hidden_comment_no.setAttribute("type", "hidden");
		hidden_comment_no.setAttribute("name", "comment_no");
		hidden_comment_no.setAttribute("value", comment_no);

		var hidden_board_no = document.createElement("input");
		hidden_board_no.setAttribute("type", "hidden");
		hidden_board_no.setAttribute("name", "board_no");
		hidden_board_no.setAttribute("value", board_no);		

		var hidden_pageNum = document.createElement("input");
		hidden_pageNum.setAttribute("type", "hidden");
		hidden_pageNum.setAttribute("name", "pageNum");
		hidden_pageNum.setAttribute("value", pageNum);

		var hidden_tailParam = document.createElement("input");
		hidden_tailParam.setAttribute("type", "hidden");
		hidden_tailParam.setAttribute("name", "tailParam");
		hidden_tailParam.setAttribute("value", tailParam);

		var btn = document.createElement("button");
		btn.setAttribute("class", "btn btn-primary");
		btn.innerText = "수정 완료";

		var frm = document.createElement("form");
		frm.setAttribute("action", "../board/modifyCommentProcess");
		frm.setAttribute("method", "post");
		frm.setAttribute("class", "cur_modify_comment");

		frm.appendChild(textarea);
		frm.appendChild(hidden_comment_no);
		frm.appendChild(hidden_board_no);
		frm.appendChild(hidden_pageNum);
		frm.appendChild(hidden_tailParam);
		frm.appendChild(btn);

		var comment_content_box = document.getElementById("comment_content_box_" + comment_no);
		var cur_comment = comment_content_box.children[0];
		cur_comment.setAttribute("class", "hidden_comment_box col");
		cur_comment.setAttribute("style", "display: none;");		
		//comment_content_box.innerText = "";
		comment_content_box.appendChild(frm);
		

		
		var comment_control_box = document.getElementById("comment_control_box_" + comment_no);
		comment_control_box.setAttribute("class", "hidden_comment_box col-2");
		comment_control_box.setAttribute("style", "display: none;");

	}
</script>

</head>
<body>
<div style="width:1200px;margin : 0 auto">
  <div class="container-fluid">
	<div class="row">
		<div class="col"><!-- 글로벌 nav -->
			<jsp:include page="../commons/global_nav.jsp"></jsp:include>
		</div>
	</div>
	
	<div class="row mt-5">
		<div class="col">
			<h1>작성글 보기</h1>
		</div>
	</div>
	
	<div class="row mt-5">
		<div class="col-1"><h3>제목 : </h3></div>
		<div class="col">${resultMap.board_title }</div>
		<div class="col-1"><h5>조회수 : </h5></div>
		<div class="col-1">${readCount }</div>
		<div class="col-1"><h5>작성일 : </h5></div>
		<div class="col-1"><fmt:formatDate value="${resultMap.BOARD_WRITEDATE }" pattern="yy-MM-dd (hh:mm)" /></div>		
	</div>
	<div class="row mt-3">
		<div class="col-1"><h5>작성자 : </h5></div>
		<div class="col">${resultMap.MEMBER_NICK }</div>
	</div>
	<div class="row mt-3">
		<div class="col">
			<c:forEach items="${boardImageVo }" var="Imagevo">
				<img src="/upload/${Imagevo.image_url }" style="width: 30%;"><br>
			</c:forEach>
		</div>
	</div>

	<div class="row mt-3">
		<div class="col"><h3>내용 : </h3></div>
	</div>
	<div class="row mt-2">
		<div class="col">${resultMap.board_content }</div>
	</div>
	
	<div class="row mt-3">
		<div class="col">
		  <c:choose>
		  	<c:when test="${!empty sessionUser }">
		  	  <c:choose>
		  	  	<c:when test="${userLikeCategoryNo == 1 }">
				  <a href="../board/likeCancleProcess?board_no=${resultMap.BOARD_NO }&member_no=${sessionUser.member_no }&likecategory_no=1&pageNum=${pageNum}&tailParam=${tailParam }">
				  <i class="bi bi-emoji-heart-eyes-fill"></i></a>
				</c:when>
				<c:otherwise>
				  <a href="../board/likeProcess?board_no=${resultMap.BOARD_NO }&member_no=${sessionUser.member_no }&likecategory_no=1&pageNum=${pageNum}&tailParam=${tailParam }">
				  <i class="bi bi-emoji-heart-eyes"></i></a>
				</c:otherwise>
			  </c:choose> ${likeCountMap.get('1') }개
			  
			  <c:choose>
		  	  	<c:when test="${userLikeCategoryNo == 2 }">
				  <a href="../board/likeCancleProcess?board_no=${resultMap.BOARD_NO }&member_no=${sessionUser.member_no }&likecategory_no=2&pageNum=${pageNum}&tailParam=${tailParam }">
				  <i class="bi bi-emoji-angry-fill"></i></a>
				</c:when>
				<c:otherwise>
				  <a href="../board/likeProcess?board_no=${resultMap.BOARD_NO }&member_no=${sessionUser.member_no }&likecategory_no=2&pageNum=${pageNum}&tailParam=${tailParam }">
				  <i class="bi bi-emoji-angry"></i></a>				
				</c:otherwise>
			  </c:choose> ${likeCountMap.get('2') }개
			  
			  <c:choose>
		  	  	<c:when test="${userLikeCategoryNo == 3 }">
				  <a href="../board/likeCancleProcess?board_no=${resultMap.BOARD_NO }&member_no=${sessionUser.member_no }&likecategory_no=3&pageNum=${pageNum}&tailParam=${tailParam }">
				  <i class="bi bi-emoji-frown-fill"></i></a>
				</c:when>
				<c:otherwise>
				  <a href="../board/likeProcess?board_no=${resultMap.BOARD_NO }&member_no=${sessionUser.member_no }&likecategory_no=3&pageNum=${pageNum}&tailParam=${tailParam }">
				  <i class="bi bi-emoji-frown"></i></a>				
				</c:otherwise>
			  </c:choose> ${likeCountMap.get('3') }개
			  
			  <c:choose>
			    <c:when test="${userLikeCategoryNo == 4 }">
				  <a href="../board/likeCancleProcess?board_no=${resultMap.BOARD_NO }&member_no=${sessionUser.member_no }&likecategory_no=4&pageNum=${pageNum}&tailParam=${tailParam }">
				  <i class="bi bi-emoji-expressionless-fill"></i></a>
				</c:when>
				<c:otherwise>
				  <a href="../board/likeProcess?board_no=${resultMap.BOARD_NO }&member_no=${sessionUser.member_no }&likecategory_no=4&pageNum=${pageNum}&tailParam=${tailParam }">
				  <i class="bi bi-emoji-expressionless"></i></a>
				</c:otherwise>
			  </c:choose> ${likeCountMap.get('4') }개
			  
		    </c:when>
		    <c:otherwise>
				<i class="bi bi-emoji-heart-eyes"></i> ${likeCountMap.get('1') }개
				<i class="bi bi-emoji-angry"></i> ${likeCountMap.get('2') }개
				<i class="bi bi-emoji-frown"></i> ${likeCountMap.get('3') }개	
				<i class="bi bi-emoji-expressionless"></i> ${likeCountMap.get('4') }개															    	
		    </c:otherwise>
		  </c:choose>
		</div>

	</div>
	
	<div class="row mt-3">
		<div class="col">
			<c:if test="${!empty resultCommentMapList }">
				<c:forEach items="${resultCommentMapList }" var="resultCommentMap">
					<div class="row mt-2 mb-2">
						<div class="col-2">
							${resultCommentMap.MEMBER_NICK }
						</div>
						<div class="col">
							<div id="comment_content_box_${resultCommentMap.COMMENT_NO }" class="row">
								<div class="col">${resultCommentMap.COMMENT_CONTENT }</div>
							</div>
						</div>
						<div class="col-1">
							<fmt:formatDate value="${resultCommentMap.COMMENT_WRITEDATE }" pattern="yy-MM-dd" />
						</div>
						<c:if test="${!empty sessionUser && sessionUser.member_no == resultCommentMap.MEMBER_NO }">		
						  <div id="comment_control_box_${resultCommentMap.COMMENT_NO }" class="col-2">	
							<span><a onclick="modifyCommentContent('${fn:replace(resultCommentMap.COMMENT_CONTENT_NONE_ESCAPE,crlf,'<br/>') }', ${resultCommentMap.COMMENT_NO }, ${resultCommentMap.BOARD_NO}, ${pageNum }, '${tailParam }')">수정</a></span>
							<span>&nbsp;|&nbsp;</span>
							<span><a href="../board/deleteCommentProcess?comment_no=${resultCommentMap.COMMENT_NO }&board_no=${resultCommentMap.BOARD_NO}&pageNum=${pageNum}${tailParam }">삭제</a></span>
						  </div>	
						</c:if>						
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
	
	<c:choose>
	  	<c:when test="${!empty sessionUser }">
		  <form action="../board/writeCommentProcess" method="post">
			<div class="row mt-3">
				<div class="col">
					<textarea name="comment_content" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="댓글을 입력하세요"></textarea>
					<input type="hidden" name="member_no" value="${sessionUser.member_no }">
					<input type="hidden" name="board_no" value="${resultMap.BOARD_NO }">
					<input type="hidden" name="pageNum" value="${pageNum }">
					<input type="hidden" name="tailParam" value="${tailParam }">										
				</div>
				<div class="col-1">
					<button class="btn btn-dark d-grid">작성</button>
				</div>
			</div>
		  </form>
		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="col">
					<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="로그인 후 이용 가능한 서비스입니다" disabled></textarea>
				</div>
				<div class="col">
					<button class="btn btn-dark" disabled>작성</button>
				</div>
			</div>			
		</c:otherwise>
	</c:choose>
	
	<div class="row mt-3">
		<div class="col">
			<a class="btn btn-primary" href="../board/mainPageRN?pageNum=${pageNum }${tailParam }">목록</a>
		</div>
		<c:if test="${!empty sessionUser && sessionUser.member_no == resultMap.MEMBER_NO }">
			<div class="col-2">
				<a id="writeBtn" href="./modifyContentPage?board_no=${resultMap.BOARD_NO }&pageNum=${pageNum }${tailParam }" class="btn btn-primary">수정</a>
				<a id="writeBtn" href="./deleteContentProcess?board_no=${resultMap.BOARD_NO }&pageNum=${pageNum }${tailParam }" class="btn btn-primary">삭제</a>
			</div>
		</c:if>
	</div>
	
	
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>