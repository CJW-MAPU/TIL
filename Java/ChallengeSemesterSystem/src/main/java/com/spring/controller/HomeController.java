package com.spring.controller;

import com.spring.dao.BoardDAO;
import com.spring.dao.UserDAO;
import com.spring.dto.BoardVO;
import com.spring.dto.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping(value = "/index.do")
    public String Index() {
        return "login.jsp";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String Login(UserVO vo, HttpSession session) throws Exception {
        UserVO user = userDAO.getUser(vo);
        if(user != null) {
            session.setAttribute("userName", user.getName());
            return "getBoardList.do";
        }
        else return "login.jsp";
    }

    @RequestMapping(value = "/logout.do")
    public String Logout(HttpSession session) {
        session.invalidate();
        return "login.jsp";
    }

    @RequestMapping(value = "/getBoardList.do")
    public ModelAndView getBoardList(BoardVO vo, ModelAndView mav) throws Exception {
        mav.addObject("boardList", boardDAO.getBoardList(vo));
        mav.setViewName("getBoardList.jsp");
        return mav;
    }

    @RequestMapping(value = "/getBoard.do", method = RequestMethod.GET)
    public ModelAndView getBoard(BoardVO vo, ModelAndView mav) throws Exception {
        mav.addObject("board", boardDAO.getBoard(vo));
        mav.setViewName("getBoard.jsp");
        return mav;
    }

    @RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
    public String insertBoard(BoardVO vo) throws Exception {
        boardDAO.insertBoard(vo);
        return "getBoardList.do";
    }

    @RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
    public String updateBoard(BoardVO vo) throws Exception {
        boardDAO.updateBoard(vo);
        return "getBoardList.do";
    }

    @RequestMapping(value = "/deleteBoard.do", method = RequestMethod.GET)
    public String deleteBoard(BoardVO vo) throws Exception {
        boardDAO.deleteBoard(vo);
        return "getBoardList.do";
    }


}

