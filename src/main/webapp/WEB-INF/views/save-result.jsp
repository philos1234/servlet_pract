<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
저장 성공
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li> <!-- $ {} 문법이  request.getAttribute("member") 를 대신함-->
</ul>
<a href="/index.html">메인</a>

</body>
</html>
