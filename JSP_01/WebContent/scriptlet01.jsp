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
<%
	
	System.out.println("input");
	Scanner sc = new Scanner(System.in);
	int i = Integer.parseInt(sc.nextLine());
	System.out.println("input end");
	
	for(; i < 10 ; i++) {
			out.println(i+"단 <br/>");
		for(int j=1 ; j < 10 ; j++) {
// 			System.out.printf("%d * %d = %d\n", i, j, i*j);
 			out.print(i);
 			out.print(" * ");
 			out.print(j);
 			out.print(" = ");
 			out.print(i*j + "<br/>");
		}
		out.print("<br/>");
	}
%>
</body>
</html>