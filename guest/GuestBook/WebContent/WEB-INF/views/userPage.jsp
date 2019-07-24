<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#ffbb33">

<form:form id="regForm" modelAttribute="message" action="saveUser"  method = "post" align="centre">
			<table style="with: 50%">
				<tr>
					<td>Your Entry :</td>
					<td><input type="text" name="user_message" /></td>
				</tr>
				<tr>
				<td>upload File:(optional)</td>
				<td><input type="file" name="userImage" id="userImage" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add Entry" /></td>
				</tr>
				
				
			</table>
</form:form>




<%-- <h1>welcome ${list}  , you have logged in as ${user_role} </h1> --%>
</body>
</html>