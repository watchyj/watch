package com.ds.watchtable.service;

import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.repository.PosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PosServiceImpl implements PosService{
    final private PosRepository posRepository;

    @Override
    public void posSetting(PosDTO posDTO) {
        Pos pos = dtoToEntity(posDTO);
        posRepository.save(pos);
    }

}
