package com.example.sjhbackend.board.model;

import com.example.sjhbackend.comment.Comment;
import com.example.sjhbackend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String title;
    private String content;
    private String writer;

//    @ManyToOne
//    @JoinColumn(name = "user_idx")
//    private User user;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments;
}
