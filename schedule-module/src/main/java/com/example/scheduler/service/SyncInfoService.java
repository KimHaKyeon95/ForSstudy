package com.example.scheduler.service;


import com.example.dto.SyncInfoDto;
import com.example.persistance.entity.SyncInfoEntity;
import com.example.persistance.repository.SyncInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SyncInfoService {

    private final SyncInfoRepository syncInfoRepository;
    public void save(SyncInfoDto syncInfoDto) {
        SyncInfoEntity syncInfoEntity = SyncInfoEntity.convert(syncInfoDto);
        log.info("--------- sync data saved! ---------");
        syncInfoRepository.save(syncInfoEntity);
    }

}
