package com.example.sjhbackend.board;

import com.example.sjhbackend.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b LEFT JOIN FETCH b.comments WHERE b.idx = :boardIdx")
    Optional<Board> findBoardWithComments(@Param("boardIdx") Long boardIdx);

}
