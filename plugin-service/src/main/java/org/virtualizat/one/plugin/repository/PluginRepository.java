package org.virtualizat.one.plugin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.virtualizat.one.plugin.entity.PluginEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PluginRepository extends JpaRepository<PluginEntity, UUID> {
    Optional<PluginEntity> findByName(String name);
}