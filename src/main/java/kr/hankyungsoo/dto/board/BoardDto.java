package kr.hankyungsoo.dto.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private Long id;
    private String category;
    private String title;
    private String content;
    private String visible;
    private String userId;
    private LocalDateTime createdDt;
    private LocalDateTime modifiedDt;

}
