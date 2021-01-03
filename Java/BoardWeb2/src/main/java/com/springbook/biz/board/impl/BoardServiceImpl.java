package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Log4jAdvice;
import com.springbook.biz.common.LogAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAOSpring boardDAO;
//    private BoardDAO boardDAO;

//    private LogAdvice log;
//    private Log4jAdvice log;

    /*public BoardServiceImpl() {
        log = new LogAdvice();
    }*/

    /*public BoardServiceImpl() {
        log = new Log4jAdvice();
    }*/

    @Override
    public void insertBoard(BoardVO vo) {
        /*if(vo.getSeq() == 0) {
            throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
        }*/
        boardDAO.insertBoard(vo);
    }

    @Override
    public void updateBoard(BoardVO vo) {
        boardDAO.updateBoard(vo);
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        boardDAO.deleteBoard(vo);
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        return boardDAO.getBoardList(vo);
    }


}
