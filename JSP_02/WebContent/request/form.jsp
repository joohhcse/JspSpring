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
	<form action="form_receive.jsp" method="get">
		이름 : <input type="text" name="name" /><br/>
		나이 : <input type="text" name="age" /><br/>
		생일 : <input type="date" name="birth" /><br/>
		취미 :
			<label for="00">영화</label> 
			<input id="00" type="checkbox" name="hobby" value="00"/>
			<label for="01">만화</label> 
			<input id="01" type="checkbox" name="hobby" value="01"/>
			<label for="02">등산</label>
			<input id="02" type="checkbox" name="hobby" value="02"/>
			<label for="03">섯다</label> 
			<input id="03" type="checkbox" name="hobby" value="03"/>
			<label for="04">낮잠</label> 
			<input id="04" type="checkbox" name="hobby" value="04"/>
			<label for="05">구땡</label> 
			<input id="05" type="checkbox" name="hobby" value="05"/>
			<br/>
		<input type="submit" value="전송" />
	</form>
</body>
</html>