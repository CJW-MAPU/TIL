package com.spring.dao;

import com.spring.dto.BoardVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDAO {
    @Select("SELECT * FROM BOARD ORDER BY SEQ DESC")
    public List<BoardVO> getBoardList(BoardVO vo) throws Exception;

    @Select("SELECT * FROM BOARD WHERE SEQ=#{seq}")
    public BoardVO getBoard(BoardVO vo) throws Exception;

    @Insert("INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) values((SELECT IFNULL(MAX(SEQ), 0) + 1 from BOARD a), #{title}, #{writer}, #{content})")
    public void insertBoard(BoardVO vo) throws Exception;

    @Update("UPDATE BOARD SET TITLE=#{title}, CONTENT=#{content} WHERE SEQ=#{seq}")
    public void updateBoard(BoardVO vo) throws Exception;

    @Delete("DELETE FROM BOARD WHERE SEQ=#{seq}")
    public void deleteBoard(BoardVO vo) throws Exception;
}
