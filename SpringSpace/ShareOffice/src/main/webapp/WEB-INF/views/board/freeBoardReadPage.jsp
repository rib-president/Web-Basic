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
						작성자 : <span>${data.memberVo.member_nick }</span> 
					</div>
				</div>
				
				<div class="row">
					<div class="col">
						제목  : <span>${data.freeBoardVo.freeboard_title } &nbsp &nbsp</span>
						조회수 : <span>${data.freeBoardVo.freeboard_readCount }</span>
					</div>	
				</div>	
				
				<hr>			
				<div class="row">
					<div class="col">
						내용 : <div>${data.freeBoardVo.freeboard_content }</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col mt-2">
					<%-- 수정
				<c:if test="${!empty sessionUser && sessionUser.member_no == data.boardVo.member_no }">
				</c:if>
					 --%>
					<a style="background-color: rgb(58,208,171);" class="float-end btn btn-light" href="./deleteContentProcess?freeboard_no=${data.freeBoardVo.freeboard_no }">삭제</a>	
					<a style="background-color: rgb(58,208,171);" class="float-end btn btn-light" href="./updateFreeBoardPage?freeboard_no=${data.freeBoardVo.freeboard_no }">수정</a> 
					<a style="background-color: rgb(58,208,171);" class="float-end btn btn-light" href="./freeBoardPage">목록</a>	
					
					 
					</div>
				</div>
				<hr class="mt-3">
				<div class="row">
					<div class="col mt-2">
						<form action="./freeBoardCommentWriteProcess" method="get">
							<p>
								<label>댓글</label>
								<%--
								코멘트리스트는 배열 같은 거라서 인덱스로 뽑아 오는거 아니면 에러남	
								작성자 : <span>${freeBoardCommentList.get(0).memberVo.member_nick }</span>
								 --%>
								작성자 : <span>${sessionUser.member_nick }</span>
								
								<input type="hidden" name="freeboard_no" value="${data.freeBoardVo.freeboard_no }">
								
							</p>
							<p>
								<textarea rows="2" class="form-control" name="comment_content"></textarea>
							</p>
							<p>
								<%-- 수정
								<c:if test="${!empty sessionUser }">
								</c:if>
								 --%> 
								<input type="submit" style="background-color: rgb(58,208,171);" class="float-end btn btn-light" value="댓글작성">
							</p>
							
						</form>
					</div>
				</div>
				<table class="table mt-2">
				 
				    <tr>
				      <th class="text-center">작성자</th>
				      <th class="text-center">내용</th>
				      <th class="text-center">날짜</th>
				
				    </tr>
				 
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
				
			</table>	
				
			</div>
		</div>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>