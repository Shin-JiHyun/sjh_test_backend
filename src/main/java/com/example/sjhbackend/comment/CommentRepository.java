package com.example.sjhbackend.comment;

import com.example.sjhbackend.board.model.BoardDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countByBoardIdx(Long idx);

}
