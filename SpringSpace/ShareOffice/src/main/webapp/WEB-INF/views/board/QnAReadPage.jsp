<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">

<style>
	table {
		border-collapse: collapse;
		border-spacing: 0;
		width: 100%;
		border: 1px solid #ddd;
		font-size: 1em;
	}
	th, td {
  		text-align: left;
	}

	tr:nth-child(even) {
		background-color: #f2f2f2;
	}
</style>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 2em;">
	<div class="col" style="margin:2rem">
	<%-- 내용작성 --%>
		<div class="row">
			<div class="col">
				<h4 class="text-center">글읽기 페이지</h4>
			
				
				<div class="row">
					<div class="col">
						작성자 : <span>${readQnABoardRow.MemberVo.member_nick }</span> 
					</div>
				</div>
				
				<div class="row">
					<div class="col">
						제목  : <span>${readQnABoardRow.QnAVo.qna_title } &nbsp &nbsp</span>
						
					</div>	
				</div>	
				
				<hr>			
				<div class="row">
					<div class="col">
						내용 : <div>${readQnABoardRow.QnAVo.qna_content }</div>
					</div>
					<br>
				<%-- 수정 로그인 했을때만 쓸수있게 
					
				--%>
				<div class="row">
					<div class="col-5"></div>
					<div class="col-2 text-center pt-2" style="border: 1px solid gold;">
						<c:if test="${!empty sessionUser }">
							<c:choose>
								<c:when test="${myLikeCount > 0}">
									<a href="./likeProcess?qna_no=${readQnABoardRow.QnAVo.qna_no }"><h2><i class="bi bi-hand-thumbs-up"></i></h2></a>
								</c:when>
								<c:otherwise>
									<a href="./likeProcess?qna_no=${readQnABoardRow.QnAVo.qna_no }"><h2><i class="bi bi-hand-thumbs-down"></i></h2></a>
								</c:otherwise>
							</c:choose>
						</c:if>	
					</div>
					<div class="col-5"></div>
				</div>
					<div class="row">
						<div class="col">
							<div>좋아요 수 : ${totalLikeCount }</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col mt-2">
					<%--
				<c:if test="${!empty sessionUser && sessionUser.member_no == readQnARow.QnAVo.member_no }">
					 --%>
					<a style="background-color: rgb(58,208,171);" class="float-end btn btn-light" href="./deleteQnAContentProcess?qna_no=${readQnABoardRow.QnAVo.qna_no }">삭제</a>	
					<a style="background-color: rgb(58,208,171);" class="float-end btn btn-light" href="./updateQnAPage?qna_no=${readQnABoardRow.QnAVo.qna_no }">수정</a> 
					<a style="background-color: rgb(58,208,171);" class="float-end btn btn-light" href="./QnAPage">목록</a>	
					<%--
				</c:if>
					 --%>
					</div>
				</div>
				<hr class="mt-3">
				<c:if test="${!empty adminUser }">
				<div class="row">
					<div class="col mt-2">
						<form action="./QnAAnswerWriteProcess" method="get">
							<p>
								<label>댓글</label>
								<%--
								코멘트리스트는 배열 가틍ㄴ거	
								작성자 : <span>${freeBoardCommentList.get(0).memberVo.member_nick }</span>
								 수정 세션 정보 혹은 어드민 세션 정보 있을때만 나오게 
								<c:if test="${!empty sessionUser }">
								작성자 : <span>${sessionUser.member_nick }</span>
								</c:if>
								
								<c:if test="${!empty adminUser }">
								작성자 : <span>${adminUser.admin_name }</span>
								</c:if>
								 --%>
								
								<input type="hidden" name="qna_no" value="${readQnABoardRow.QnAVo.qna_no }">
								
							</p>
							<p>
								<textarea rows="2" class="form-control" name="answer_content"></textarea>
							</p>
							<p>
								<%-- 수정
								<c:if test="${!empty sessionUser }">
								</c:if>
								 --%> 
								<input type="submit" style="background-color: #f0edcc;" class="float-end btn btn-light" value="댓글작성">
							</p>
							
						</form>
					</div>
				</div>
				</c:if>
				<table class="table mt-2">
				 
				    <tr>
				      <th class="text-center">작성자</th>
				      <th class="text-center">내용</th>
				      <th class="text-center">날짜</th>
				
				    </tr>
				 
				  <c:forEach items="${answerList }" var="answer">
				    <tr>
				      	<td>
				      		
								<span>${answer.author }</span>
								
				      	</td>
				      	<td>
				      		<span>${answer.QnAAnswerVo.answer_content }</span>
				      	</td>
				      	<td>
				      		<span><fmt:formatDate value="${answer.QnAAnswerVo.answer_writeDate }" pattern="M.dd" /></span>
				      	</td>
				    	</tr>
					</c:forEach>
				
			</table>	
			</div>	
			
		</div>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>