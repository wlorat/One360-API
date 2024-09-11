package org.virtualizat.one.plugin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.virtualizat.one.plugin.entity.OptionEntity;

import java.util.UUID;

public interface OptionRepository  extends JpaRepository<OptionEntity, UUID> {
}
