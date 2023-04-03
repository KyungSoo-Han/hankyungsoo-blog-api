package kr.hankyungsoo.mapper.board;

import kr.hankyungsoo.dto.board.BoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDto boardDto);
}
