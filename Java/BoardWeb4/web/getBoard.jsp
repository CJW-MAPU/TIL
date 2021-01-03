<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-05-03
  Time: 오후 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=EUC-KR" %>

<%
    String seq = request.getParameter("seq");

    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    BoardVO board = boardDAO.getBoard(vo);
%>

<html>
<head>
    <title>글 상세</title>
</head>
<body>
<div style="text-align: center;">
    <h1>글 상세</h1>
    <form action="updateBoard_proc.jsp" method="post">
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="70">제목</td>
                <td align="left"> <input name="title" type="text" value="<%= board.getTitle() %>"/> </td>
            </tr>
            <tr>
                <td bgcolor="orange"> 작성자</td>
                <td align="left"><%=board.getWriter()%></td>
            </tr>
            <tr>
                <td bgcolor="orange">내용</td>
                <td align="left"><textarea name="content" cols="40" rows="10"><%=board.getContent()%></textarea> </td>
            </tr>
            <tr>
                <td bgcolor="orange">등록일</td>
                <td align="left"><%=board.getRegDate()%></td>
            </tr>
            <tr>
                <td bgcolor="orange">조회수</td>
                <td align="left"><%=board.getCnt()%></td>
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
    <a href="deleteBoard_proc.jsp">글 삭제</a>&nbsp;&nbsp;&nbsp;
    <a href="getBoardList.jsp">글 목록</a>
</div>
</body>
</html>
