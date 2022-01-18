package com.ds.watchtable.controller;

import com.ds.watchtable.dto.LikesDTO;
import com.ds.watchtable.service.LikesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class LikesController {
    @Autowired
    final private LikesService likesService;

    //좋아요 추가
    @RequestMapping("/addLikes/{storeNum}")
    public ResponseEntity<Long> addLikes(@RequestBody LikesDTO likesDTO) {
        Long likesNum = likesService.registerLikes(likesDTO);
        return new ResponseEntity<>(likesNum, HttpStatus.OK);
    }

    //좋아요 취소
    @DeleteMapping("/modifyLikes/{storeNum}/{likesNum}")
    public ResponseEntity<Long> cancelLike( @PathVariable Long likesNum){
        likesService.remove(likesNum);
        log.info("deletlikescontroller======"+likesNum);
        return new ResponseEntity<>( likesNum, HttpStatus.OK);
    }



}
