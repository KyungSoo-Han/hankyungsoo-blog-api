package kr.hankyungsoo.api.board;

import kr.hankyungsoo.dto.board.BoardDto;
import kr.hankyungsoo.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/{id}")
    public BoardDto findById(@PathVariable Long id){

        return boardService.findById(id);
    }

    @PostMapping
    public BoardDto insertBoard(@RequestBody BoardDto boardDto){
        return boardService.insertBoard(boardDto);
    }

}
