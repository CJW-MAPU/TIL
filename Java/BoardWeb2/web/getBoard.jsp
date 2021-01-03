<%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-05-01
  Time: 오후 6:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page contentType="text/html; charset=EUC-KR" %>

<%
    String seq = request.getParameter("seq");

    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    BoardVO board = boardDAO.getBoard(vo);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>글 상세</title>
    </head>
    <body>
        <div style="text-align: center;">
            <h1> 글 상세 </h1>
            <a href="logout_proc.jsp">Log-out</a>
            <hr>
            <form action="updateBoard_proc.jsp" method="post">
                <table border="1" cellpadding="0" cellspacing="0">
                    <tr>
                        <td bgcolor="orange" width="70"> 제목 </td>
                        <td align="left"><input name="title" type="text"
                                                 value="<%= board.getTitle() %>"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="orange"> 작성자 </td>
                        <td align="left"><%= board.getWriter() %></td>
                    </tr>
                    <tr>
                        <td bgcolor="orange">내용</td>
                        <td align="left"><textarea name="content" rows="10" cols="40"> <%= board.getContent() %></textarea></td>
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
            <a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
            <a href="deleteBoard_proc.jsp">글삭제</a>&nbsp;&nbsp;&nbsp;
            <a href="getBoardList.jsp">글목록</a>
        </div>
    </body>
</html>
