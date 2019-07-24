<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">



</style>
</head>
<body  background="/WEB-INF/images/guestbook_bg.jpg" bgcolor="#ffecb3">
<h1>${welcomeMessage}</h1>
 <form:form id="regForm" modelAttribute="user" action="user"  method = "post" align="centre">
 <table align="center" >
 <tr>
 <td>
<input type="text" name ="user_name"><br>
<input type="password" name="password" ><br>
<input type="submit" value="login" align="middle">

</td>
</tr>
</table>
<a href="userPage" ></a>
</form:form>
</body>
</html>
