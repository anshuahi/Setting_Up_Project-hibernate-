<html>
<body>

<jsp:include page="include/header.jsp"></jsp:include>

<h2>Hello World!</h2>



<jsp:include page="include/footer.jsp"></jsp:include>

</body>

</html>
04:25:13	update users set email='password123' where username='John'
Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.
To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.0019 sec
