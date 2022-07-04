<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,com.greatlearning.debate.event.entity.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>

		<h1>Student Information</h1>

		<div style="border:1px solid blue;background-color:yellow;color:blue;">
	
		<%
			
		List<Student> students=(List<Student>)request.getAttribute("studentInformation");
		
		out.println("<table border=1><tr><th>Id</th><th>Name</th><th>Department</th><th>Country</th><th>Delete</th></tr>");
		for(Student s:students){
			
			out.println("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getDepartment()+"</td><td>"+s.getCountry()+"</td><td><a href='/student-details/Student/delete-student?id="+s.getId()+"'>Delete</a></td></tr>");
		}
		
		out.println("</table>");
		%>
		
		</div>
		
		<a href="/student-details/Student/show-form">Add More..Students</a>
		
	</div>
</body>
</html>