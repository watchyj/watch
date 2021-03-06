package com.ds.watchtable.service;


import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.MemberRole;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;

public interface MemberService {
//    public User add(User user) throws Exception;

    //DB 저장
    String register(MemberDTO dto);

    void modify(MemberDTO memberDTO);
    default Member dtoToEntity(MemberDTO memberDTO) {
        Member member = Member.builder()
                .memberNum(memberDTO.getMemberNum())
                .memberName(memberDTO.getMemberName())
                .memberNickname(memberDTO.getMemberNickname())
                .memberId(memberDTO.getMemberId())
                .memberEmail(memberDTO.getMemberEmail())
                .memberMobile(memberDTO.getMemberMobile())
                .memberPw(memberDTO.getMemberPw())
                .build();
        member.addMemberRole(MemberRole.USER);
        return member;
    }

    default Member socialDtoToEntity(MemberDTO memberDTO) {
        Member member = Member.builder()
                .memberNum(memberDTO.getMemberNum())
                .memberName(memberDTO.getMemberName())
                .memberNickname(memberDTO.getMemberNickname())
                .memberId(memberDTO.getMemberId())
                .memberEmail(memberDTO.getMemberEmail())
                .memberMobile(memberDTO.getMemberMobile())
                .memberPw(memberDTO.getMemberPw())
                .fromSocial(true)
                .build();
        member.addMemberRole(MemberRole.USER);
        return member;
    }

    default MemberDTO entityToDTO(Member member) {
        MemberDTO memberDTO = MemberDTO.builder()
                .memberNum(member.getMemberNum())
                .memberName(member.getMemberName())
                .memberId(member.getMemberId())
                .memberEmail(member.getMemberEmail())
                .memberMobile(member.getMemberMobile())
                .memberPw(member.getMemberPw())
                .modDate(member.getModDate())
                .regDate(member.getRegDate())
                .build();
        return memberDTO;
    }

}
