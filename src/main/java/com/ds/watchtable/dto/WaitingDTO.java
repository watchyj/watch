package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WaitingDTO {
    private Long waitingNum;
    private String partyMember;

    private Long memberNum;
    private String memberName;
    private String memberNickname;
    private String memberMobile;

    private Long storeNum;
    private String storeName;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
