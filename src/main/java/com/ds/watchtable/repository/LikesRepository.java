package com.ds.watchtable.repository;

import com.ds.watchtable.dto.LikesDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Likes;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long > {
    @Query("select l from Likes l where l.member =:member")
    Page<Likes> getLikesByUser(Pageable pageable, Member member);

    @Query("select l from Likes l where l.store =:store")
    LikesDTO getByStore(Store store);

    @Query("select l from Likes l where l.store =:store")
    Likes getLikesByUserStore(Store store);

    @Query("select count(Likes.likesNum) from Likes where Likes.storeNum =:storeNum")
    Long counting(Long storeNum);

    }
