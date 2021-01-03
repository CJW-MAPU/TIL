<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: MAPU
  Date: 2020-05-03
  Time: ���� 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=EUC-KR"%>

<%
    BoardVO vo = new BoardVO();
    BoardDAO boardDAO = new BoardDAO();
    List<BoardVO> boardList = boardDAO.getBoardList(vo);
%>
<html>
<head>
    <title>�� ���</title>
</head>
<body>
    <div style="text-align: center;">
        <h1>�� ���</h1>
        <h3>�׽�Ʈ�� ȯ���մϴ�...<a href="logout_proc.jsp"> Log-out </a> </h3>

        <form action="getBoardList.jsp" method="post">
            <table border="1" cellpadding="0" cellspacing="0">
                <tr>
                    <td align="center">
                        <select name="searchCondition">
                            <option value="TITLE">����</option>
                            <option value="CONTENT">����</option>
                        </select>
                        <input name="searchKeyword" type="text"/>
                        <input type="submit" value="�˻�"/>
                    </td>
                </tr>
            </table>
        </form>

        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <th bgcolor="orange" width="100">��ȣ</th>
                <th bgcolor="orange" width="200">����</th>
                <th bgcolor="orange" width="150">�ۼ���</th>
                <th bgcolor="orange" width="150">�����</th>
                <th bgcolor="orange" width="100">��ȸ��</th>
            </tr>

            <% for (BoardVO board : boardList) { %>
                <tr>
                    <td><%= board.getSeq() %></td>
                    <td align="left"> <a href="getBoard.jsp?seq=<%= board.getSeq() %>"> <%=board.getTitle() %></a></td>
                    <td><%=board.getWriter()%></td>
                    <td><%=board.getRegDate()%></td>
                    <td><%=board.getCnt()%></td>
                </tr>
            <% } %>
        </table>
        <br/>
        <a href="insertBoard.jsp">�� �� �� ��</a>
    </div>
</body>
</html>
