<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="org.anshuahi.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List users</title>
</head>
<body>

<jsp:include page="include/header.jsp"></jsp:include>

<h3>List Users</h3>

<table border="1" padding="1">
	<thead>
		<th>User Id </th>
		<th>Username </th>
		<th>Email </th>
	</thead>


<%
	if(request.getAttribute("users") == null){
		out.print("<tr> No users found </tr>");
	}
	else {
		
		List<User> users = (List) request.getAttribute("users");
	
		for(User usr: users){
			out.print("<tr>");
			out.print("<td>"+ usr.getUser_id() +"</td>");
			out.print("<td>"+ usr.getUsername() +"</td>");
			out.print("<td>"+ usr.getEmail() +"</td>");
			out.print("</tr>");
		}
	}
%>
</table>

<jsp:include page="include/footer.jsp"></jsp:include>

</body>
</html>