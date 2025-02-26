package com.example.sjhbackend.comment;

import com.example.sjhbackend.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public void register(CommentDto.CommentRegister dto) {
        commentRepository.save(dto.toEntity(boardRepository.findById(dto.getBoardIdx()).orElseThrow()));
    }
}
