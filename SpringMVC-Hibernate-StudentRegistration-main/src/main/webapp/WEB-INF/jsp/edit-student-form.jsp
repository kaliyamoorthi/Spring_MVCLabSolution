<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Student Details Update</h2>

      <form:form method = "POST" action = "update" >
         <table>
            <tr>
                <td><form:label path = "id">Id of Student to be updated</form:label></td>
                <td><form:input readonly="true"  path = "id" /></td>
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
                  <input type = "submit" value = "Update"/>
               </td>
            </tr>
         </table>
      </form:form>
   </body>

</html>