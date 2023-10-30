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
<title>Faculty</title>
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
<p class="fs-3 text-center">Faculty Details</p>
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
<th scope="col">DOB</th>
<th scope="col">Qualification</th>
<th scope="col">Specialist</th>
<th scope="col">Email</th>
<th scope="col">Mob_No</th>
<th scope="col">Action</th>
</tr>
</thead>
<tbody>
<%

FacultyDao dao2=new FacultyDao(DBConnect.getConn());
List<Faculty> list=dao2.getAllFaculty();
for(Faculty f:list)
	
{%>
<tr>
<td><%=f.getFullName() %></td>
<td><%=f.getDob()%></td>
<td><%=f.getQualification() %></td>
<td><%=f.getSpecialist() %></td>
<td><%=f.getEmail()%></td>
 <td><%=f.getMobNo() %></td>
<td>
<a  href="edit_Faculty.jsp?id=<%=f.getId() %>" class="btn btn-sm btn-primary">Edit</a>
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