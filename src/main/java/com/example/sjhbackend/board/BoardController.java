package com.example.sjhbackend.board;

import com.example.sjhbackend.board.model.BoardDetailDto;
import com.example.sjhbackend.board.model.BoardListDto;
import com.example.sjhbackend.board.model.BoardRegisterDto;
import com.example.sjhbackend.global.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @PostMapping("/register")
    public ResponseEntity<BaseResponse> register(@RequestBody BoardRegisterDto.RegisterReq dto) {
        boardService.register(dto);
        return ResponseEntity.ok(BaseResponse.onSuccess(null));
    }
    @GetMapping("/list")
    public ResponseEntity<BaseResponse> getBoardList(int page, int size) {
        List<BoardListDto.BoardListDetail> dto = boardService.getList(page, size);
        return ResponseEntity.ok(BaseResponse.onSuccess(dto));
    }

    @GetMapping("/{boardIdx}")
    public ResponseEntity<BaseResponse> getBoard(@PathVariable Long boardIdx) {
        BoardDetailDto.BoardDetailResponse dto = boardService.getBoard(boardIdx);
        return ResponseEntity.ok(BaseResponse.onSuccess(dto));
    }

}
