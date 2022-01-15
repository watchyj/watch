package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Likes;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikesRepository extends JpaRepository<Likes, Long > {
    @Query("select l from Likes l where l.member =:member")
    Page<Likes> getLikesByUser(Pageable pageable, Member member);



}
