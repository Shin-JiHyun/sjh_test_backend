package com.example.sjhbackend.board;

import com.example.sjhbackend.board.model.Board;
import com.example.sjhbackend.board.model.BoardDetailDto;
import com.example.sjhbackend.board.model.BoardListDto;
import com.example.sjhbackend.board.model.BoardRegisterDto;
import com.example.sjhbackend.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    public void register(BoardRegisterDto.RegisterReq dto) {
        boardRepository.save(dto.toEntity());
        return;
    }

    public List<BoardListDto.BoardListDetail> getList(int page, int size) {
        List<Board> boards = boardRepository.findAll(PageRequest.of(page, size)).getContent();
        List<BoardListDto.BoardListDetail> boardListDetails = new ArrayList<>();
        for (Board board : boards) {
            boardListDetails.add(BoardListDto.BoardListDetail.from(board, commentRepository.countByBoardIdx(board.getIdx())));
        }
        return boardListDetails;
    }

    public BoardDetailDto.BoardDetailResponse getBoard(Long boardIdx) {
        Board board = boardRepository.findBoardWithComments(boardIdx).orElseThrow();
            BoardDetailDto.BoardDetailResponse dto = BoardDetailDto.BoardDetailResponse.from(board);
            return dto;

    }
}
