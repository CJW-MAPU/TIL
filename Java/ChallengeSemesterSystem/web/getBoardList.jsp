<%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-06-02
  Time: 오후 7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<div style="text-align: center;">
    <h1>글 목록</h1>
    <h3>${userName }님 환영합니다...<a href="logout.do">Log-Out</a></h3>

    <form action="/getBoardList.do" method="post">
        <table border="1" cellspacing="0" cellpadding="0" width="700" style="margin: auto;">
            <tr>
                <td align="right" colspan="4">
                    <select name="searchCondition">
                        <option value="TITLE">제목</option>
                        <option value="CONTENT">내용</option>
                    </select>
                    <input name="searchKeyword" type="text"/>
                    <input type="submit" name="submit" value="검색"/>
                </td>
            </tr>
            <tr>
                <th bgcolor="#7fffd4" width="100">번호</th>
                <th bgcolor="#7fffd4" width="200">제목</th>
                <th bgcolor="#7fffd4" width="150">작성자</th>
                <th bgcolor="#7fffd4" width="150">등록일</th>
            </tr>

            <c:forEach items="${boardList }" var="board">
                <tr>
                    <td>${board.seq }</td>
                    <td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
                    <td>${board.writer }</td>
                    <td>${board.regDate }</td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <br/>
    <a href="insertBoard.jsp">새 글 등록</a>
</div>
</body>
</html>
