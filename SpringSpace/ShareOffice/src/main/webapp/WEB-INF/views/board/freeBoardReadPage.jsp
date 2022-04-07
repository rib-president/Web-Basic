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
		border: 0.063em solid #ddd;
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
<div class="container-fluid px-0" style="overflow-x : hidden">
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 2em; padding-bottom: 2em;">
	<div class="col" style="margin-left: 1rem; margin-right: 1rem;">
	<%-- 내용작성 --%>
		<div class="row">
			<div class="col">
				<div class="row">
					<div class="col text-fs-23 text-center mb-2">상세글보기</div>
				</div>
				<div class="row text-fs-13">
					<div class="col">No. ${data.freeBoardVo.freeboard_no}</div>
					<div class="col text-right">
						<fmt:formatDate value="${data.freeBoardVo.freeboard_writeDate }" pattern="yyyy/MM/dd" />
					</div>
				</div>
				
				<div class="row">
					<div class="col text-fs-23 bold">
						<span>
							${data.freeBoardVo.freeboard_title }
							<i class="bi bi-x-lg float-right" onclick="location.href='../board/freeBoardPage';"></i>
						</span>
					</div>
				</div>
				
				<div class="row mt-3">
					<div class="col text-fs-16">
						<span>작성자</span>
						<span class="inline-block pl-3 bold">${data.memberVo.member_nick }</span> 
					</div>
					<div class="col text-fs-13">
						<div class="row">
							<div class="col text-right">조회수 : ${data.freeBoardVo.freeboard_readCount }</div>
						</div>
					</div>	
				</div>	
				
				<hr>			
				<div class="row">
					<div class="col">
						<div>${data.freeBoardVo.freeboard_content }</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col mt-2">
					
				<c:if test="${!empty sessionUser && sessionUser.member_no == data.freeBoardVo.member_no }">
					 
					<a style="background-color: #BBA586; color: white; margin-left: 0.5em;" class="float-end btn btn-light" href="./deleteContentProcess?freeboard_no=${data.freeBoardVo.freeboard_no }">삭제</a>	
					<a style="background-color: #BBA586; color: white;" class="float-end btn btn-light" href="./updateFreeBoardPage?freeboard_no=${data.freeBoardVo.freeboard_no }">수정</a> 
					<!--  <a style="background-color: rgb(58,208,171);" class="float-end btn btn-light" href="./freeBoardPage">목록</a> -->	
				</c:if>
					
					 
					</div>
				</div>
				<hr class="mt-3">
				<div class="row">
					<div class="col">
					<c:choose>
					<c:when test="${!empty sessionUser }">
						<form action="./freeBoardCommentWriteProcess" method="get">
							<p style="margin-bottom: 0.5em;">
								<label>댓글</label>
								<%--
								코멘트리스트는 배열 같은 거라서 인덱스로 뽑아 오는거 아니면 에러남	
								작성자 : <span>${freeBoardCommentList.get(0).memberVo.member_nick }</span>
								 --%>
								작성자<span class="pl-3 bold">${sessionUser.member_nick }</span>
								
								<input type="hidden" name="freeboard_no" value="${data.freeBoardVo.freeboard_no }">
								
							</p>
							<p style="margin-bottom: 0.5em;">
								<textarea rows="2" class="form-control" name="comment_content"></textarea>
							</p>
							<p>
								<%-- 수정
								<c:if test="${!empty sessionUser }">
								</c:if>
								 --%> 
								<input type="submit" style="background-color: #BBA586; color: white;" class="float-end btn btn-light" value="등록">
							</p>
						</form>
						</c:when>
						<c:otherwise>
							<div class="row">
								<div class="col text-center" style="color: #868e96; margin: 1rem;">로그인 후 댓글을 작성해 주세요.</div>
							</div> 
						</c:otherwise>
						</c:choose>
					</div>
				</div>
				<!-- 
				<table class="table" style="margin-top: 1em;">
				 <thead>
				    <tr>
				      <th class="text-center">작성자</th>
				      <th class="text-center">내용</th>
				      <th class="text-center">날짜</th>
				
				    </tr>
				 </thead>
				 <tbody>
				  <c:forEach items="${freeBoardCommentList }" var="freeBoardCommentList">
				    <tr>
				      	<td>
				      		<span>${freeBoardCommentList.memberVo.member_nick } :</span>
				      	</td>
				      	<td>
				      		<span>${freeBoardCommentList.freeBoardCommentVo.comment_content }</span>
				      	</td>
				      	<td>
				      		<span><fmt:formatDate value="${freeBoardCommentList.freeBoardCommentVo.comment_writeDate }" pattern="MM월dd일" /></span>
				      	</td>
				    	</tr>
					</c:forEach>
				</tbody>
			</table>  -->
			<div class="row mt-5">
				<div class="col text-fs-16">
					<c:forEach items="${freeBoardCommentList }" var="freeBoardCommentList">
						<div class="row">
							<div class="col bold">${freeBoardCommentList.memberVo.member_nick }</div>
							<div class="col text-fs-13" style="text-align: right; color: #868e96">
								<fmt:formatDate value="${freeBoardCommentList.freeBoardCommentVo.comment_writeDate }" pattern="MM월dd일" />
							</div>
						</div>
						<div class="row mt-2">
							<div class="col">${freeBoardCommentList.freeBoardCommentVo.comment_content }</div>
						</div>
						<hr style="margin-top: 0.7em; margin-bottom: 0.7em;">
					</c:forEach>
				</div>
			</div>
				
			</div>
		</div>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>