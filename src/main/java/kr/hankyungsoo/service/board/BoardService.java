package kr.hankyungsoo.service.board;

import kr.hankyungsoo.dto.board.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardService {
    BoardDto insertBoard(BoardDto boardDto);

    BoardDto findById(Long id);

    List<BoardDto> findList(int pageNo, int pageSize);

    BoardDto updateBoard(BoardDto boardDto);

    Long deleteBoard(Long id);
}
