<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
	
</head>
<body>
	<form action="UserServlet" method="post" >
	<br><br>
	
	<div align="center">
			<h1>User Login:</h1>
		
						
						<table border="0">
							
							<tr>
								<td><b>Login ID:</b></td>
								<td><input type="text" name="user">
							</tr>
							<tr>
								<td><b>Password:</b></td>
								<td><input type="password" name="password">
							</tr>
							<tr>
								
								<center><td align="right"><input type="submit" value="Login"></td></center>
								<td align="right"><input type="reset" name="Reset"></td>
								
							</tr>
							
					</table>
			
	</div>
	</form>
	
</body>
</html>