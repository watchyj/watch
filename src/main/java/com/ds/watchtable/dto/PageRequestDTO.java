package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

    private int page, size;
    private String type, keyword;
    public PageRequestDTO(){
        page = 1;
        size = 10;
    }
    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page-1,size,sort);
    }
}
