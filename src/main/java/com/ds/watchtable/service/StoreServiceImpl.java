package com.ds.watchtable.service;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.MenuImage;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.StoreImage;
import com.ds.watchtable.repository.MenuImageRepository;
import com.ds.watchtable.repository.StoreImageRepository;
import com.ds.watchtable.repository.StoreRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
    @Autowired
    final private StoreRepository storeRepository;
    @Autowired
    final private StoreImageRepository storeImageRepository;
    @Autowired
    final private MenuImageRepository menuImageRepository;

//    DB저장
    @Transactional
    @Override
    public Long storeRegister(StoreDTO storeDTO) {
        log.info(">>>"+storeDTO);
        Map<String, Object> entityMap = dtoToEntity(storeDTO);
        Store store = (Store) entityMap.get("store");
        log.info("오류오류"+store);
        List<StoreImage> storeImageList = (List<StoreImage>) entityMap.get("storeImgList");
        log.info("오류오류"+storeImageList);
        List<MenuImage> menuImageList = (List<MenuImage>) entityMap.get("menuImgList");
        log.info("오류오류"+menuImageList);
        storeRepository.save(store);
        storeImageList.forEach(storeImage -> {
            storeImageRepository.save(storeImage);
        });
        menuImageList.forEach(menuImage -> {
            menuImageRepository.save(menuImage);
        });
        return store.getStoreNum();
    }

//    admin store list
    @Override
    public PageResultDTO<StoreDTO, Object[]> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("storeNum").descending());

        Page<Object[]> result = storeRepository.getListPage(pageable);

        Function<Object[], StoreDTO> fn = (arr -> entityToDTO(
                (Store) arr[0],
                (List<StoreImage>)(Arrays.asList((StoreImage)arr[1])),
                (List<MenuImage>)(Arrays.asList((MenuImage)arr[2]))
        ));
        return new PageResultDTO<>(result, fn);
    }

    //admin/storeread
    @Override
    public StoreDTO getStore(Long storeNum) {
        List<Object[]> result = storeRepository.getStoreDetail(storeNum);
        log.info(">>"+result.get(0));

        Store store = (Store) result.get(0)[0]; //get(0) -중복방지
        log.info(">>"+store);

        List<StoreImage> storeImageList = new ArrayList<>();
        result.forEach(arr->{
            StoreImage storeImage = (StoreImage) arr[1];
            log.info(">>"+storeImage);

            storeImageList.add((storeImage));
        });

        List<MenuImage> menuImageList = new ArrayList<>();
        result.forEach(arr->{
            MenuImage menuImage = (MenuImage) arr[2];
            log.info(">>"+menuImage);

            menuImageList.add((menuImage));
        });
        return entityToDTO(store, storeImageList, menuImageList);
    }

}