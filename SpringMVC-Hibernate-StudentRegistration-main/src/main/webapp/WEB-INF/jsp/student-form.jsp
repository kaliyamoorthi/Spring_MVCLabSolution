<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Student Registration</h2>

      <form:form method = "POST" action = "registerStudent" >
         <table>
            <tr>
                <td><form:label path = "id">Id</form:label></td>
                <td><form:input path = "id" /></td>
            </tr>
            <tr>
               <td><form:label path = "name">Name</form:label></td>
               <td><form:input path = "name" /></td>
            </tr>
            <tr>
               <td><form:label path = "department">Department</form:label></td>
               <td><form:input path = "department" /></td>
            </tr>
			<tr>
               <td><form:label path = "country">Country</form:label></td>
               <td><form:input path = "country" /></td>
            </tr>

            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>
      </form:form>
   </body>

</html>