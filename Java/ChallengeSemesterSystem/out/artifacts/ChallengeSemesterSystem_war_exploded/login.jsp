<%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-06-02
  Time: 오후 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<div style="text-align: center;">
    <h1>로그인</h1>
    <hr>
    <form action="login.do" method="post">
        <table border="1" cellpadding="0" cellspacing="0" style="margin: auto;">
            <tr>
                <td bgcolor="#7fffd4">아이디</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td bgcolor="#7fffd4">비밀번호</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="로그인">
                </td>
            </tr>
        </table>
    </form>
    <hr>
</div>
</body>
</html>
