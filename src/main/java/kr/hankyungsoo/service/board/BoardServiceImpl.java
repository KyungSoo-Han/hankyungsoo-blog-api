package kr.hankyungsoo.service.board;

import kr.hankyungsoo.dto.board.BoardDto;
import kr.hankyungsoo.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public BoardDto insertBoard(BoardDto boardDto) {

        boardMapper.insertBoard(boardDto);

        return boardDto;
    }

    @Override
    public BoardDto findById(Long id) {
        return boardMapper.findById(id);
    }
}
