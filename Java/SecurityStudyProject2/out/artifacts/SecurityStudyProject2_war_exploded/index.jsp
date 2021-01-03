<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %><%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-08-25
  Time: 오후 4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Object principal = auth.getPrincipal();

    String name = "";
    if(principal != null) {
      name = auth.getName();
    }
  %>
  <br><br>
  <div>
    <h1>Security Prj</h1>
    <h5><%=name%>님, 반갑습니다.</h5>
    <%--<sec:authorize access="isAuthenticated()">
      <p><sec:authentication property="principal.username"/></p>
    </sec:authorize>--%>
  </div>
  <br><br>
  <div>
    <a href='<c:url value="/page"/>'>GUEST</a>
    <a href='<c:url value="/user/page"/>'>USER</a>
    <a href='<c:url value="/member/page"/>'>MEMBER</a>
    <a href='<c:url value="/admin/page"/>'>ADMIN</a>
  </div>
  <br>
  <div>
    <sec:authorize access="isAuthenticated()">
      <form action="/logout" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">LOGOUT</button>
      </form>
    </sec:authorize>
  </div>
  </body>
</html>
