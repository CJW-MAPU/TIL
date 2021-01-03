<%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-05-31
  Time: 오후 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>글 상세</title>
</head>
<body>
    <div style="text-align: center;">
        <h1> 글 상세 </h1>
        <a href="logout.do">Log-Out</a>
        <hr>
        <form action="/updateBoard.do" method="post">
            <input name="seq" type="hidden" value="${board.seq }"/>
            <table border="1" cellspacing="0" cellpadding="0">
                <tr>
                    <td bgcolor="orange" width="70">제목</td>
                    <td align="left"><input name="title" type="text" value="${board.title }"/></td>
                </tr>
                <tr>
                    <td bgcolor="orange">작성자</td>
                    <td align="left">${board.writer }</td>
                </tr>
                <tr>
                    <td bgcolor="orange">내용</td>
                    <td align="left"><textarea rows="10" cols="40" name="content">${board.content }</textarea> </td>
                </tr>
                <tr>
                    <td bgcolor="orange">등록일</td>
                    <td align="left">${board.regDate }</td>
                </tr>
                <tr>
                    <td bgcolor="orange">조회수</td>
                    <td align="left">${board.cnt }</td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="글 수정"/>
                    </td>
                </tr>
            </table>
        </form>
        <hr>
        <a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
        <a href="deleteBoard.do?seq=${board.seq }">글 삭제</a>&nbsp;&nbsp;&nbsp;
        <a href="/getBoardList.do">글 목록</a>
    </div>
</body>
</html>
