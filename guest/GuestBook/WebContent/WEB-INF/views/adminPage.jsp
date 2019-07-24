<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#ffbb33">
<h1> Welcome to Admin Page !! </h1>
<table border="2" width="70%" cellpadding="2" bgcolor="#ffcccc">  
<tr><th>name</th><th>User Name</th><th>message_status</th> <th>Action</th></tr>  
   <c:forEach var="user" items="${messageList}">   
	   <tr>  
	   <td>${user.user_message}</td> 
	   <td>${user.user_id}
	    <td>${user.message_status}</td>
	    
	    <td><a href="/GuestBook/approve/${user.message_id}">Approve</a>
	    <a href="/GuestBook/reject/${user.message_id}">Reject</a>
	    </td>  
 	   </tr>  
	   </c:forEach>  
 

</table>

 <div align="center">
  <a href="/GuestBook/home">Logout</a>
</div>​

<%-- <h1>welcome ${list}  , you have logged in as ${user_role} </h1> --%>
</body>
</html>