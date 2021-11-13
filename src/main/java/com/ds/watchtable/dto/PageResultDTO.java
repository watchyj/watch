package com.ds.watchtable.dto;

import com.ds.watchtable.entity.Store;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, EN> {
    //DTO 리스트 순서있음
    private List<DTO> dtoList;

    //총 페이지 번호
    private  int totalPage;

    //현재 페이지
    private  int page;

    //목록 사이즈
    private int size;

    //시작 페이지 번호, 끝 페이지 번호
    private int start, end;
    
    //이전, 다음
    private boolean prev, next;
    
    //페이지 번호 목록
    private List<Integer> pageList;

    public PageResultDTO(Page<EN> result, Function<EN,DTO>fn){
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
        makePageList(result.getPageable());

    }

    private void makePageList(Pageable pageable) {
        page = pageable.getPageNumber() +1;
        size = pageable.getPageSize();
        int tempEnd = (int) (Math.ceil(page/10.0))*10;
        start = tempEnd - 9;
        prev = start > 1;
        end = totalPage>tempEnd ? tempEnd : totalPage;
        next = totalPage>tempEnd;
        //페이지번호를 담는 리스트
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
