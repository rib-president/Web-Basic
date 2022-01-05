<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String value = "안녕하세요!!!!"; // 출력돼야 할 데이터
	request.setAttribute("data", value);

	// redirect
	response.sendRedirect("./target.jsp");
%>
