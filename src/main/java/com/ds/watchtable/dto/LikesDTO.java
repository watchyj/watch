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
public class LikesDTO {
    private Long likesNum;
    private String likes;

    private Long memberNum;

    private Long storeNum;
    private String storeName;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
