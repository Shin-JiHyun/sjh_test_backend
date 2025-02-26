package com.example.sjhbackend.comment;

import com.example.sjhbackend.global.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody CommentDto.CommentRegister dto) {
        commentService.register(dto);
        return ResponseEntity.ok(BaseResponse.onSuccess(null));
    }
}
