package com.example.dto;

import com.example.persistance.entity.SyncInfoEntity;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SyncInfoDto {

    private long id;
    private LocalDateTime syncTime;

    public static SyncInfoDto convert(SyncInfoEntity entity) {
        SyncInfoDto syncInfoDto = new SyncInfoDto();
        syncInfoDto.setId(entity.getId());
        syncInfoDto.setSyncTime(entity.getSyncTime());
        return syncInfoDto;
    }
}
