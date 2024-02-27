package com.example.persistance.repository;

import com.example.persistance.entity.SyncInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyncInfoRepository extends JpaRepository<SyncInfoEntity, Long> {

}
