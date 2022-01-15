package com.ds.watchtable.service;

import com.ds.watchtable.dto.LikesDTO;
import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.entity.Likes;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Store;

public interface LikesService {
    //좋아요 추가
    Long registerLikes(LikesDTO likesDTO);
    //좋아요 취소
    void remove(Long likesNum);
    //좋아요 리스트 (멤버)
    PageResultDTO<LikesDTO, Likes> getUserLikes(PageRequestDTO requestDTO, Member member);




        default Likes dtoToEntity(LikesDTO likesDTO) {
        Likes likes = Likes.builder()
            .likesNum(likesDTO.getLikesNum())
            .likes(likesDTO.getLikes())
            .member(Member.builder()
                    .memberNum(likesDTO.getMemberNum())
                    .build())
            .store(Store.builder()
                    .storeNum(likesDTO.getStoreNum())
                    .storeName(likesDTO.getStoreName())
                    .build())
            .build();
        return likes;
    }

    default LikesDTO entityToDTO(Likes likes) {
        LikesDTO likesDTO = LikesDTO.builder()
                .likesNum(likes.getLikesNum())
                .likes(likes.getLikes())
                .memberNum(likes.getMember().getMemberNum())
                .storeNum(likes.getStore().getStoreNum())
                .storeName(likes.getStore().getStoreName())
                .regDate(likes.getRegDate())
                .modDate(likes.getModDate())
                .build();
        return likesDTO;
    }

}