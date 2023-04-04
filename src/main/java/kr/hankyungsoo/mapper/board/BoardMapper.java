package kr.hankyungsoo.mapper.board;

import kr.hankyungsoo.dto.board.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDto boardDto);

    BoardDto findById(Long id);

    void updateBoard(BoardDto boardDto);

    void deleteBoard(Long id);

    List<BoardDto> findList();
}
