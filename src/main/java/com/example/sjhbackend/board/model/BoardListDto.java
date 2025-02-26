package com.example.sjhbackend.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class BoardListDto {

    @Builder
    @Getter
    public static class BoardListDetail {
        @Schema(description = "게시글 ID", example = "1")
        private Long idx;

        @Schema(description = "게시글 제목", example = "새로운 게시글 제목")
        private String title;

        @Schema(description = "작성자", example = "홍길동")
        private String writer;

        @Schema(description = "댓글 수", example = "5")
        private int replyCount;

        public static BoardListDetail from(Board entity, int replyCount) {
            return BoardListDetail.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .writer(entity.getWriter())
                    .replyCount(replyCount)
                    .build();
        }
    }
}

