<%@page import="com.org.dto.Notes"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/bootstrap_css.jsp"%>
</head>
<body>
<%@ include file="components/homenavbar.jsp"%>
<h1 align="center">WELCOME TO HOME</h1>
<% String msg = (String)session.getAttribute("success");
						%>
 
						<% 
							if(msg!=null)
							{ %>
								<p class="text-center text-success fs-4"><%= msg %></p>
						<%	}
						%>
 
						<% session.removeAttribute("success"); %>
<%
User user=(User)session.getAttribute("userObj");
List<Notes> list=user.getNotes();
%>
<div class="row">
	<div class="column">
	<%
	for(Notes note:list){%>
		<%= note.getTitle() %>
	<% }
	%>
	</div>
</div>
<div class="container border">
	<div>
		<a href="addnote.jsp "class="btn bg-primary text-white">Add Notes</a>
	</div>
</div>

</body>
</html>