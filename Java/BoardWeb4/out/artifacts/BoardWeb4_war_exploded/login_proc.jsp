<%@ page import="com.springbook.biz.user.UserVO" %>
<%@ page import="com.springbook.biz.user.impl.UserDAO" %>
<%@ page import="com.springbook.biz.user.UserService" %>
<%@ page import="org.springframework.context.support.AbstractApplicationContext" %>
<%@ page import="org.springframework.context.support.GenericXmlApplicationContext" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-05-03
  Time: ¿ÀÀü 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=EUC-KR" %>
<%

    String id = request.getParameter("id");
    String password = request.getParameter("password");

    UserVO vo = new UserVO();
    vo.setId(id);
    vo.setPassword(password);

    UserDAO userDAO = new UserDAO();
    UserVO user = userDAO.getUser(vo);

    if(user != null) {
        System.out.println(user.getName());
    } else {
        System.out.println("failed");
    }


    if(user != null) {
        response.sendRedirect("getBoardList.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }
%>

