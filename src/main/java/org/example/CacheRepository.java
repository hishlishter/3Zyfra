package org.example;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CacheRepository extends JpaRepository<CacheEntry, Long> {
    List<CacheEntry> findByObjectId(String objectId);
}
