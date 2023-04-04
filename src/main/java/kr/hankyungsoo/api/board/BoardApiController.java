package kr.hankyungsoo.api.board;

import kr.hankyungsoo.dto.board.BoardDto;
import kr.hankyungsoo.service.board.BoardService;
import kr.hankyungsoo.service.common.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;
    private final FileUploadService uploadService;


    @GetMapping("/{id}")
    public BoardDto findById(@PathVariable Long id){
        return boardService.findById(id);
    }

    @PostMapping
    public BoardDto insertBoard(@RequestBody BoardDto boardDto){
        return boardService.insertBoard(boardDto);
    }
    @PostMapping("/file")
    public BoardDto insertBoardWithFile(@RequestPart BoardDto boardDto, @RequestPart MultipartFile file) throws IOException {

        String serverFileName = RandomStringUtils.randomAlphanumeric(50);

        String realFilesName = file.getOriginalFilename();
        String realFilesNameExtension = FilenameUtils.getExtension(realFilesName).toLowerCase();

        boardDto.setServerFileName(serverFileName + "." + realFilesNameExtension);
        boardDto.setRealFileName(realFilesName);

        BoardDto insertBoard = boardService.insertBoard(boardDto);

        uploadService.upload(file, realFilesNameExtension, serverFileName);

        return insertBoard;
    }

    @PutMapping
    public BoardDto updateBoard(@RequestBody BoardDto boardDto){
        return boardService.updateBoard(boardDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteBoard(@PathVariable Long id){
        return boardService.deleteBoard(id);
    }

}
