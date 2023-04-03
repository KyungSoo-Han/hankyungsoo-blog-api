package kr.hankyungsoo.api.board;

import kr.hankyungsoo.dto.board.BoardDto;
import kr.hankyungsoo.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping
    public BoardDto insertBoard(@RequestBody BoardDto boardDto){
        return boardService.insertBoard(boardDto);
    }

}
