package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {


}
