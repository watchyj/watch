package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long > {
}
