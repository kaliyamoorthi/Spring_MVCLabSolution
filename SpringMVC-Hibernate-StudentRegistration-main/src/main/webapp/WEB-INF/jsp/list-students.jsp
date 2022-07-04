<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Debate Registration</title>
<!--link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script-->
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Event - Debate Registered Students</h2>
   <hr />

   <input type="button" value="Register Student"
    onclick="window.location.href='showStudentform';"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Student List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Student Id</th>
       <th>Name</th>
       <th>Department</th>
       <th>Country</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempStudent" items="${students}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/updateForm">
        <c:param name="studentId" value="${tempStudent.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/delete">
        <c:param name="studentId" value="${tempStudent.id}" />
       </c:url>

       <tr>
        <td>${tempStudent.id}</td>
        <td>${tempStudent.name}</td>
        <td>${tempStudent.department}</td>
		<td>${tempStudent.country}</td>

        <td>
         <!-- display the update link -->
          <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
 <br>
   <c:url var="homepage" value="/homePage"></c:url>
 <a href  = "${homepage}">Home Page</a>
</body>
</html>