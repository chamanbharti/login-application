<%@page import="com.servlet.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<%
		User user=(User)request.getAttribute("user");
	%>
<div align="center">
	<form action="SaveServlet" method="post">
	<table>
	<br><br>
		<h1>Edit Profile:</h1>
		
	<tr>
		<td>
			<label for="id">User ID:</label>
		</td>
		<td>
			<input type="text" name="userId" value="<%=user.getUserId()%>"/>
		
		</td>
	</tr>
	<tr>
		<td>
			<label for="name">Name:</label>
		</td>
		<td>
			<input type="text" name="name" value="<%=user.getName()%>"/>
		
		</td>
	</tr>
	<tr>
		<td>
			<label for="password">Password:</label>
		</td>
		<td>
			<input type="password" name="password">
		</td>
	</tr>
	<tr>
	<td>
		<label for="address">Address:</label>
	</td>
		<td>
			<textarea rows="2" cols="10" name="address"><%=user.getAddress()%></textarea>
		</td>
	</tr>
	
	<tr>
	<td>
		<label for="hobbies">Hobbies:</label>
	</td>
		<td>
			<%
				String hobbies[] = user.getHobbies().split(",");
				for(int i=0;i<hobbies.length;i++){
			%>
					<input type="checkbox" name="hobbies" value="<%=hobbies[i]%>"><%=hobbies[i]%>
			<%
				}
			%>
		</td>
	</tr>
	
	
	<tr>
	<td>
		<label for="Interest:">Interest:</label>
	</td>
		<td>
			<input type="radio" name="interest" value="<%=user.getInterest()%>"><%=user.getInterest()%>
		</td>
	</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Save User"/>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>