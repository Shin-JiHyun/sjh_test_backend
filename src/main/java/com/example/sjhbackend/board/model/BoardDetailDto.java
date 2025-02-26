package com.example.sjhbackend.board.model;

import com.example.sjhbackend.comment.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class BoardDetailDto {

    @Builder @Getter
    public static class BoardDetailResponse {
        @Schema(description = "게시글 제목", example = "새로운 게시글 제목")
        private String title;

        @Schema(description = "게시글 내용", example = "이것은 새로운 게시글 내용입니다.")
        private String content;

        @Schema(description = "작성자", example = "홍길동")
        private String writer;

        @Schema(description = "댓글 리스트", example = "[{\"writer\": \"이순신\", \"content\": \"첫 번째 댓글\"}, {\"writer\": \"김유신\", \"content\": \"두 번째 댓글\"}]")
        private List<CommentDto> commentDtoList;

        public static BoardDetailResponse from(Board board) {
            return BoardDetailResponse.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .commentDtoList(board.getComments().stream()
                            .map(CommentDto::from)
                            .collect(Collectors.toList()))
                    .build();
        }
    }

    @Builder @Getter
    public static class CommentDto {
        @Schema(description = "댓글 작성자", example = "이순신")
        private String writer;

        @Schema(description = "댓글 내용", example = "첫 번째 댓글")
        private String content;

        public static CommentDto from(Comment comment) {
            return CommentDto.builder()
                    .writer(comment.getWriter())
                    .content(comment.getContent())
                    .build();
        }
    }
}
