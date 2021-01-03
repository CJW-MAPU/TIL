<%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-06-02
  Time: 오후 7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 등록</title>
</head>
<body>
<div style="text-align: center;">
    <h1>글 등록</h1>
    <hr>
    <form action="insertBoard.do" method="post">
        <table border="1" cellpadding="0" cellspacing="0" style="margin: auto;">
            <tr>
                <td bgcolor="#7fffd4" width="70">제목</td>
                <td align="left"><input type="text" name="title"/></td>
            </tr>
            <tr>
                <td bgcolor="#7fffd4">작성자</td>
                <td align="left"><input type="text" name="writer" size="10" value="${userName }" readonly/></td>
            </tr>
            <tr>
                <td bgcolor="#7fffd4">내용</td>
                <td align="left"><textarea rows="10" cols="40" name="content"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="새 글 등록"/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="/getBoardList.do">글 목록 가기</a>
</div>
</body>
</html>
