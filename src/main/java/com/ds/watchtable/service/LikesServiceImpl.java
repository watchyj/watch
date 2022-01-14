package com.ds.watchtable.service;

import com.ds.watchtable.dto.LikesDTO;
import com.ds.watchtable.entity.Likes;
import com.ds.watchtable.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class LikesServiceImpl implements LikesService{

    private final LikesRepository likesRepository;

    //DB저장
    @Override
    public Long registerLikes(LikesDTO likesDTO) {
        Likes likes = dtoToEntity(likesDTO);
        likesRepository.save(likes);
        return likes.getLikesNum();
    }

    //좋아요 취소
    @Override
    public void remove(Long likesNum) {
        log.info("likesNum====="+likesNum);
        likesRepository.deleteById(likesNum);
    }


}
