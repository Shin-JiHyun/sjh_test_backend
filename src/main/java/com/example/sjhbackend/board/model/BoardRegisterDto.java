package com.example.sjhbackend.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class BoardRegisterDto {
    @Builder @Getter
    public static class RegisterReq {

        @Schema(description = "게시글 제목", example = "새로운 게시글 제목")
        private String title;

        @Schema(description = "게시글 내용", example = "이것은 게시글 내용입니다.")
        private String content;

        @Schema(description = "작성자", example = "홍길동")
        private String writer;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }
}
