package kr.hankyungsoo.service.board;

import com.github.pagehelper.PageHelper;
import kr.hankyungsoo.dto.board.BoardDto;
import kr.hankyungsoo.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<BoardDto> findList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return boardMapper.findList();
    }

    @Override
    public BoardDto updateBoard(BoardDto boardDto) {
        boardMapper.updateBoard(boardDto);
        return boardDto;
    }

    @Override
    public Long deleteBoard(Long id) {
        boardMapper.deleteBoard(id);
        return id;
    }
}
