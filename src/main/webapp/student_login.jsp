<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student_login</title>
<%@ include file="component/allcssjs.jsp" %>
<style type="text/css">

.point-card{
    box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);}
    </style>
    
</head>
<body>
<%@ include file="component/navbar.jsp" %>
<div class="container p-5">
<div class="row">
  <div class="col-md-6 offset-md-4">
  <div class="card point-card">
  <div class="card-body">
  <p class="fs-4 text-center fs-5">Student_Login</p>
  
  <c:if test="${not empty succMsg}">
  <p class="text-center text-success fs-3">${succMsg}</p>
  <c:remove var="sucMsg" scope="session"/>
  
  </c:if>
  <c:if test="${not empty errorMsg}">
  <p class="text-center text-danger fs-5">${errorMsg}</p>
  <c:remove var="errorMsg" scope="session" />
  
  </c:if>
    <form action="studentLogin" method="post">
  <div class="mb-3">
  <label class="form-label">Email Address</label>
  <input required name="email" type="email" class="form-control">
  </div>
  <div class="mb-3">
  <label class="form-label">Password</label>
  <input required name="password" type="password" class="form-control">
  </div>
  <button type="submit" class="btn btn-success text-white col-md-12">login</button>
</form>
<br>Don't have an account?<a href="sign_up.jsp" class="text-decoration-none">Create_account</a>
</div>
</div>
</div>
</div>
</div>
</body>
</html>