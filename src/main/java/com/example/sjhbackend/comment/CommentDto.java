package com.example.sjhbackend.comment;

import com.example.sjhbackend.board.model.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class CommentDto {
    @Builder @Getter @Setter
    public static class CommentRegister {
        @Schema(description = "게시글 번호", example = "1")
        private Long boardIdx;
        @Schema(description = "댓글 내용", example = "댓글입니다.")
        private String content;
        @Schema(description = "작성자 이름", example = "작성자")
        private String writer;

        public Comment toEntity(Board board){
            return Comment.builder()
                    .content(content)
                    .writer(writer)
                    .board(board)
                    .build();
        }
    }
}
