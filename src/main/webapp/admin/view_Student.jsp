<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDao"%>

<%@ page import="com.dao.FacultyDao" %>
<%@ page import="com.entity.Faculty" %>
<%@page import="com.entity.Specalist"%>

<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
<%@ include file="../component/allcssjs.jsp" %>
<style type="text/css">

.paint-card{
box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
}

</style>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container-fluid mt-2">
<div class="row">


</div>
</div>

<div class="col-md-10 mt-2">
<div class="card paint-card">
<div class="card-body">
<p class="fs-3 text-center">All Student Details</p>
<c:if test="${not empty errorMsg}">   
<p class="fs-3 text-center text-danger">${errorMsg}</p>
<c:remove var="errorMsg" scope="session"/>
</c:if>
<c:if test="${not empty succMsg}">
<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
<c:remove var="succMsg" scope="session"/>
</c:if>
<table class="table">
<thead>
<tr>
<th scope="col">Full name</th>

<th scope="col">Email</th>
<th scope="col">Password</th>
<th scope="col">Action</th>
</tr>
</thead>
<tbody>
<%

StudentDao dao3=new StudentDao(DBConnect.getConn());
List<Student> list1=dao3.getAllStudent();
for(Student f:list1)
	
{%>
<tr>
<td><%=f.getFullname() %></td>
<td><%=f.getEmail()%></td>
 <td><%=f.getPassword() %>
<td>
<a  href="editDocter.jsp?id=<%=f.getId() %>" class="btn btn-sm btn-primary">Edit</a>
<a  href="../deleteDoctor?id=<%=f.getId() %>" class="btn btn-sm btn-danger">Delete</a>
</td>
</tr>
	
<%}
%>

</tbody>
</table>
</div>
</div>
</div>


</body>
</html>