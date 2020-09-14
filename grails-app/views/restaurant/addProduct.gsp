<%--
  Created by IntelliJ IDEA.
  User: shakib
  Date: 9/13/2020
  Time: 2:33 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Image to DB and show</title>
</head>

<body>

    <g:uploadForm class="user-form" controller="restaurant" action="addItem">
        Image: <g:field name="userImage" type="file" accept="image/*" required=""/><br>
        Name: <g:textField name="name" required=""/>
        Details: <g:textField name="details" required=""/>
        Price: <g:textField name="price" required=""/>
        <g:submitButton name="add" value="Add"/>
    </g:uploadForm>

</body>
</html>