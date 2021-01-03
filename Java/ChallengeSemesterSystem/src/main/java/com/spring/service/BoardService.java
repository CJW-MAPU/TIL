package com.spring.service;

import com.spring.dto.BoardVO;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface BoardService {
    public List<BoardVO> getBoardList(BoardVO vo) throws Exception;

    public BoardVO getBoard(BoardVO vo) throws Exception;

    public void insertBoard(BoardVO vo) throws Exception;

    public void updateBoard(BoardVO vo) throws Exception;

    public void deleteBoard(BoardVO vo) throws Exception;
}
