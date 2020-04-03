<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<%!
	Scanner sc = new Scanner(System.in);
%>

<%!
		public int input() {
			System.out.println("정수를 입력!");
			int dan = Integer.parseInt(sc.nextLine());
			return dan;		
		}
%>

<%
		int dan = input();
		for(; dan < 10 ; dan++) {
%>

		<%=dan%>단 입니다. <br/>
		
<%
		for(int gop=1 ; gop<10 ; gop++) {
%>

		<%=	dan%> * <%=gop%> = <%= dan*gop%> <br/>

<%
		}
%>
	<br/>
<%
	}
%>
</body>
</html>