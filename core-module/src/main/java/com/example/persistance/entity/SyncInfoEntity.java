package com.example.persistance.entity;

import com.example.dto.SyncInfoDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sync_info")
public class SyncInfoEntity {

    @Id
    private long id;

    @CreatedDate
    private LocalDateTime syncTime;

    public static SyncInfoEntity convert(SyncInfoDto syncInfoDto) {
        SyncInfoEntity syncInfoEntity = new SyncInfoEntity();
        syncInfoEntity.id = syncInfoDto.getId();
        syncInfoEntity.syncTime = syncInfoDto.getSyncTime();
        return syncInfoEntity;
    }

}
