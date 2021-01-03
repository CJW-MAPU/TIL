package com.springbook.view.controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println(path);

        if(path.equals("/login.do")) {
            System.out.println("로그인 처리");

            String id = request.getParameter("id");
            String password = request.getParameter("password");

            UserVO vo = new UserVO();
            vo.setId(id);
            vo.setPassword(password);

            UserDAO userDAO = new UserDAO();
            UserVO user = userDAO.getUser(vo);

            if(user != null) {
                response.sendRedirect("getBoardList.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        }

        else if(path.equals("/logout.do")) {
            System.out.println("logout");
        } else if(path.equals("/insertBoard.do")) {
            System.out.println("insertBoard");
        } else if(path.equals("/updateBoard.do")) {
            System.out.println("updateBoard");
        } else if(path.equals("/deleteBoard.do")) {
            System.out.println("deleteBoard");
        } else if(path.equals("/getBoard.do")) {
            System.out.println("getBoard");
        } else if(path.equals("/getBoardList.do")) {
            System.out.println("getBoardList");
        }
    }
}
