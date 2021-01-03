<%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-08-25
  Time: 오후 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/login" method="post">
            <input type="text" name="loginId" placeholder="example">
            <input type="password" name="loginPwd" placeholder="Password">
            <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
            <button type="submit">Sign in</button>
        </form>
    </div>
    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
        <span style="color: #ff0000; ">
            <p>Your login attempt was not successful due to <br/>
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
            <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
        </span>
    </c:if>
</body>
</html>
