<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
    <h1>List</h1>
    <pre>
        http://localhost:8888/json/board/list
        list.jsp
    </pre>
<c:forEach items="${list}" var="board">
    ${board.title} <br>
</c:forEach>

</body>
</html>