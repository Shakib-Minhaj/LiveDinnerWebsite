<%--
  Created by IntelliJ IDEA.
  User: shakib
  Date: 9/14/2020
  Time: 4:30 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Image to DB and show</title>
</head>

<body>

<g:uploadForm class="user-form" controller="restaurant" action="addToStaff">
    Image: <g:field name="staffImage" type="file" accept="image/*" required=""/><br>
    Name: <g:textField name="name" required=""/>
    Designation: <g:textField name="designation" required=""/>
    <g:submitButton name="add" value="Add"/>
</g:uploadForm>

</body>
</html>