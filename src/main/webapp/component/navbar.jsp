<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<nav class="navbar navbar-expand-lg navbar-light bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa fa-graduation-cap" aria-hidden="true"></i>ACADEMY</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
     <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
     <c:if test="${empty studentObj }">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="admin_login.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i> Admin</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Faculty_login.jsp">Faculty</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="classes.jsp">Classes</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="student_login.jsp" >USER</a>
        </li>
        </c:if>
        <c:if test="${not empty studentObj }">
        
         <li class="nav-item">
          <a class="nav-link" href="admin/view_Faculty.jsp">Faculty</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="classes.jsp">Classes</a>
        </li>
        <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria="expended="false>${studentObj.fullname}</a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
        <li><a class="dropdown-item" href="#">change_password</a>
         <li><a class="dropdown-item" href="./studentLogout">logout</a>
        </ul>
        
        
     
        
        
      
           </c:if>
        
         </ul>
    </div>
  </div>
</nav>