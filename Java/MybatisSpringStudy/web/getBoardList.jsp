<%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-05-27
  Time: 오후 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>글 목록</title>
</head>
<body>
    <div style="text-align: center;">
        <h1>글 목록</h1>
        <h3>${userName }님 환영합니다...<a href="logout.do">Log-Out</a></h3>

        <form action="/getBoardList.do" method="post">
            <table border="1" cellspacing="0" cellpadding="0" width="700">
                <tr>
                    <td align="right">
                        <select name="searchCondition">
                            <option value="TITLE">제목</option>
                            <option value="CONTENT">내용</option>
                        </select>
                        <input name="searchKeyword" type="text"/>
                        <input type="submit" name="submit" value="검색"/>
                    </td>
                </tr>
            </table>
        </form>

        <table border="1" cellpadding="0" cellspacing="0" width="700">
            <tr>
                <th bgcolor="orange" width="100">번호</th>
                <th bgcolor="orange" width="200">제목</th>
                <th bgcolor="orange" width="150">작성자</th>
                <th bgcolor="orange" width="150">등록일</th>
                <th bgcolor="orange" width="100">조회수</th>
            </tr>

            <c:forEach items="${boardList }" var="board">
                <tr>
                    <td>${board.seq }</td>
                    <td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
                    <td>${board.writer }</td>
                    <td>${board.regDate }</td>
                    <td>${board.cnt }</td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="insertBoard.jsp">새 글 등록</a>
    </div>
</body>
</html>
