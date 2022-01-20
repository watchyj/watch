package com.ds.watchtable.service;

import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.*;
import com.ds.watchtable.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

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

    //좋아요 리스트 (멤버)
    @Override
    public PageResultDTO<LikesDTO, Likes> getUserLikes(PageRequestDTO requestDTO, Member member) {
        Pageable pageable = requestDTO.getPageable(Sort.by("likesNum").descending());
        Page<Likes> result = likesRepository.getLikesByUser(pageable, member);
        Function<Likes, LikesDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    //좋아요 데이터
    @Override
    public LikesDTO getLikes(Long storeNum) {
        Likes likes = likesRepository.getById(storeNum);
        return entityToDTO(likes);
    }

/*    @Override
    public LikesDTO getLikes(Long storeNum) {
        Store store = Store.builder().storeNum(storeNum).build();
        LikesDTO likes = likesRepository.getByStore(store);

        return likes;
    }*/


}