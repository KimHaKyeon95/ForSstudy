package com.example.scheduler;


import com.example.dto.SyncInfoDto;
import com.example.scheduler.service.SyncInfoService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableSchedulerLock(defaultLockAtMostFor = "PT10M")
public class JobScheduler {

    private final SyncInfoService syncInfoService;

    @Scheduled(cron = "*/10 * * * * *")
    @SchedulerLock(name = "syncInfoInsert", lockAtLeastFor = "PT10M", lockAtMostFor = "PT15M")
    public void saveSyncData() {
        SyncInfoDto syncInfoDto = new SyncInfoDto();
        syncInfoDto.setSyncTime(LocalDateTime.now());
        syncInfoService.save(syncInfoDto);
    }

}
