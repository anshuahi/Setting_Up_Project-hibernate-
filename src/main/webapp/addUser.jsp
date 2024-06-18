<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<style>

 form {
 	padding: 40px;
 }
 
/*  input {
 	padding: 10px;
 }
 	 */
	
	input {
	  padding: 0.75rem 0;
	  border: 2px solid black;
	  background: none;
	  border-radius: 10px;
	  font-size: 1.05rem;
	  font-weight: bolder;
	}
</style>
<body>

<jsp:include page="include/header.jsp"></jsp:include>

<h4>Add new User</h4>

<form action="<%= request.getContextPath() %>/site" method="post">
	User name: <input type="text" name="username" required="required" /> <br>
	Email: <input type="text" name="email" required="required" /> <br/>
	
	<input type="hidden" name="form" value="addUserOperation" /> <br/>
	<input type="submit" value="Add User"/>
</form>


<jsp:include page="include/footer.jsp"></jsp:include>

</body>
</html>