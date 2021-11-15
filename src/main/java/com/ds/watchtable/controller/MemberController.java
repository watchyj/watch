package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    //DB 저장
    @RequestMapping("/myinfo")
    public void registerPost(MemberDTO memberDTO) {
        log.info("register...........");
        memberService.register(memberDTO);
//    attributes.addAttribute("username",userDTO.getUsername());
//    attributes.addAttribute("userid",userDTO.getUserid());
    }

/*    @GetMapping("/myinfocorrect")
    private void getMyInfo(Model model, @AuthenticationPrincipal Principal principal) {
        Optional<Member> result = memberService.getInfo(memberNum);
        model.addAttribute("memberDTO", result);
    }*/



    //그냥 틀려먹음
/*
    @GetMapping("/myinfocorrect") //get-불러오기
    private void getMyInfo(Model model, @AuthenticationPrincipal Principal principal) {
        List<MemberDTO> dto = memberService.getAll();
        model.addAttribute("memberDTO", dto);
        log.info("dto>>" + dto);
        }
*/

}


