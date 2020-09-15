<%--
  Created by IntelliJ IDEA.
  User: shakib
  Date: 9/14/2020
  Time: 1:41 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Image to DB and show</title>
</head>

<body>

<g:uploadForm class="user-form" controller="restaurant" action="addToGallery">
    Image: <g:field name="userImg" type="file" accept="image/*" required=""/><br>
    <g:submitButton name="add" value="Add"/>
</g:uploadForm>

</body>
</html>