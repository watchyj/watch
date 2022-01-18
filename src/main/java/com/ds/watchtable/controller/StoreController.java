package com.ds.watchtable.controller;

import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.PosTable;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.LikesService;
import com.ds.watchtable.service.StoreService;
import com.ds.watchtable.service.WaitingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Nullable;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
@Nullable
public class StoreController {
    @Autowired
    private final StoreService storeService;
    @Autowired
    private final WaitingService waitingService;
    private final LikesService likesService;

    //store/detail - member, store 정보 넘기기
    @GetMapping("/store/detail")
    public void read(Long storeNum, @ModelAttribute("pageRequestDTO")
            PageRequestDTO pageRequestDTO, Model model, Long likesNum,
                     @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()" + principal.getMember());
        }

        StoreDTO storeDTO = storeService.getStore(storeNum);
        log.info("storeDTO()>>" + storeDTO);
        model.addAttribute("dto", storeDTO);


        LikesDTO likesDTO = null;
        try {
            if (likesNum == null) {
                likesDTO = likesService.getLikes(principal.getMember(), storeNum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            model.addAttribute("likesDTO", likesDTO);


        Store posTable1 = storeService.getPosTable1(storeNum);
        log.info("storeDTO()>>" + posTable1);
        PosTable posTable = storeService.getPosTable(posTable1);
        log.info("ewrwererwrew" + posTable1);
        model.addAttribute("order", posTable);

        List<PosTable> posTableList = storeService.findAll();
        model.addAttribute("postable", posTableList);
    }


    //스토어 principal 정보 넘기기
    @RequestMapping({"/manager/managemyinfo", "/pos/postable"})
    public void read1(Model model, @AuthenticationPrincipal ClubAuthMemberDTO principal,
                      PageRequestDTO pageRequestDTO) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
        }
        Store store = storeService.getStoreMember(principal.getMember());
        log.info("store.getMember()" + store);
        model.addAttribute("dto", store);

        //웨이팅리스트
        PageResultDTO waitingDTO = waitingService.getWaitingList(pageRequestDTO, store);
        log.info("waitinglist>>11111" + waitingDTO);
        model.addAttribute("waitingDTO", waitingDTO);

        PosTable posTable1 = storeService.getPosTable(store);
        log.info("yjyj12" + posTable1);
        model.addAttribute("order", posTable1);
    }

    //사업자 정보수정 principal 넘기기
    @RequestMapping("/manager/manageinfocorrect")
    public void read2(Model model, @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()" + principal.getMember());
        }
        model.addAttribute("store", storeService.getStoreMember(principal.getMember()));
        Store storeDTO = storeService.getStoreMember(principal.getMember());
        log.info("storeDTO.getMember22222()" + storeDTO);
    }

    @RequestMapping("/pos/postable2")
    public String update(Model model, @AuthenticationPrincipal ClubAuthMemberDTO principal,
                         PosTableDTO posTableDTO) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
        }
        Store store = storeService.getStoreMember(principal.getMember());
        model.addAttribute("dto", store);

        log.info("yjyj13" + store);

        PosTable posTable1 = storeService.getPosTable(store);
        model.addAttribute("order", posTable1);

        log.info("yjyj14" + posTable1);
        posTableDTO.setPosTableNum(posTable1.getPosTableNum());
        posTableDTO.setStoreNum(store.getStoreNum());

        log.info("yjyj15" + posTableDTO);
        storeService.modify(posTableDTO, store);
        return "redirect:/pos/postable";
    }
}