package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberService memberService;
    @Autowired
    private final StoreService storeService;
    private final WaitingService waitingService;
    private final ReviewService reviewService;
    private final LikesService likesService;

    //db 저장
    @PostMapping("/join/login")
    public void registerAndMyInfo(MemberDTO memberDTO) {
        log.info("register...........");
        memberService.register(memberDTO);
    }

    //principal, waiting list
    @RequestMapping("/member/myinfo")
    public void myinfo(Model model, PageRequestDTO pageRequestDTO, Long storeNum,
                       @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()1" + principal.getMember());
        }

        PageResultDTO userWaiting = waitingService.getUserWaiting(pageRequestDTO, principal.getMember());
        log.info("userWaiting>>11111" + userWaiting);
        model.addAttribute("userWaiting", userWaiting);

        PageResultDTO userReview = reviewService.getUserReview(pageRequestDTO, principal.getMember());
        log.info("userReview>>11111" + userReview);
        model.addAttribute("userReview", userReview);

        PageResultDTO userLikes = likesService.getUserLikes(pageRequestDTO, principal.getMember());
        log.info("userLikes>>11111" + userLikes);
        model.addAttribute("userLikes", userLikes);


/*
        Store store = storeService.getStoreMember(principal.getMember());
        model.addAttribute("dto", store);

        PosTable posTable1 = storeService.getPosTable(store);
        model.addAttribute("order", posTable1);
*/
    }

    @PostMapping("/member/myinfo")
    public String update(MemberDTO member) {
        log.info("modify...........");
        memberService.modify(member);
        return "redirect:/";
    }

    //principal
    @RequestMapping({"/member/myinfocorrect", "/join/socialJoin"})
    public void myinfo(Model model, @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()1" + principal.getMember());
        }
    }


    //    @PutMapping("/{memberNum}")
//    public ResponseEntity<Long> modifySocial(@PathVariable("memberNum") Long memberNum,
//                                       @RequestBody MemberDTO memberDTO){
//        log.info("modify.......");
//        memberService.modify(memberDTO);
//        return new ResponseEntity<>(memberNum, HttpStatus.OK);
//    }
//    @PutMapping("/join/login")
//    public void update(@PathVariable Long memberNum, String newSocial) {
//        memberRepository.findById(memberNum);
//        Member member = new Member();
//        Member.builder().fromSocial(true).build();
//        log.info("member.isFromSocial()"+member.isFromSocial());
//        memberRepository.save(member);
//    }
//    @PostMapping("/member/idCheck")
//    @ResponseBody
//    public int idCheck(@RequestParam("id") String id){
//        log.info("userIdCheck 진입");
//        log.info("전달받은 id:"+id);
//        int cnt = memberService.idCheck(id);
//        log.info("확인 결과:"+cnt);
//        return cnt;
//    }
}





