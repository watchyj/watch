package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreTableRepository extends JpaRepository<Setting, Long > {
}