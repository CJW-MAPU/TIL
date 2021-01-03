package com.springbook.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        // 생성
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        BoardService boardService = (BoardService) container.getBean("boardService");

        BoardVO vo = new BoardVO();
        vo.setTitle("임시 제목");
        vo.setWriter("홍길동");
        vo.setContent("임시 내용............");
        boardService.insertBoard(vo);

        List<BoardVO> boardList = boardService.getBoardList(vo);
        for(BoardVO board : boardList) {
            System.out.println("---> " + board.toString());
        }
        /*for (int i = 2; i < 16; i++) {
            BoardVO vo = new BoardVO();
            vo.setSeq(i);

            boardService.deleteBoard(vo);
        }*/

        container.close();
    }
}
