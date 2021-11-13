package com.ds.watchtable.service;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ds.watchtable.entity.QMember.member;


@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    //db 저장

    @Override
    public String register(MemberDTO memberDTO) {
        memberDTO.setMemberPw(this.passwordEncoder.encode(memberDTO.getMemberPw()));
        Member member = dtoToEntity(memberDTO);
        memberRepository.save(member);
        return member.getMemberName();
    }
}

