package org.virtualizat.one.plugin.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.virtualizat.one.plugin.dto.OptionDto;
import org.virtualizat.one.plugin.dto.PluginDto;
import org.virtualizat.one.plugin.entity.OptionEntity;
import org.virtualizat.one.plugin.entity.PluginEntity;
import org.virtualizat.one.plugin.entity.emun.Category;
import org.virtualizat.one.plugin.utils.ValueMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Component
public class PluginMapper {
    public PluginEntity toEntity(PluginDto pluginDto) {


        if (pluginDto == null) {
            return null;
        }

        PluginEntity pluginEntity = new PluginEntity();
        if (pluginDto.getId() != null) {
            pluginEntity.setId(UUID.fromString(pluginDto.getId()));
        }

        pluginEntity.setName(pluginDto.getName());
        pluginEntity.setDescription(pluginDto.getDescription());
        pluginEntity.setCategory(Category.valueOf(pluginDto.getCategory()));
        pluginEntity.setVersion(pluginDto.getVersion());

        if (pluginDto.getOptions() != null) {
            Set<OptionEntity> optionEntities = new HashSet<>();

            for (OptionDto optionDto : pluginDto.getOptions()) {
                OptionEntity optionEntity = new OptionEntity();
                optionEntity.setOption(optionDto.getOption());
                optionEntity.setDescription(optionDto.getDescription());
                optionEntity.setPlugin(pluginEntity);
                optionEntities.add(optionEntity);
            }

            pluginEntity.setOptions(optionEntities);
        }

        return pluginEntity;
    }

    public List<PluginEntity> toCollectionModel(List<PluginDto> plugins) {
        return plugins.stream()
                .map(this::toEntity)
                .toList();
    }

    public PluginDto toDto(PluginEntity pluginEntity) {
        if (pluginEntity == null) {
            return null;
        }

        PluginDto pluginDto = new PluginDto();

        if (pluginEntity.getId() != null) {
            pluginDto.setId(pluginEntity.getId().toString());
        }

        pluginDto.setName(pluginEntity.getName());
        pluginDto.setVersion(pluginEntity.getVersion());
        pluginDto.setDescription(pluginEntity.getDescription());
        pluginDto.setCategory(pluginEntity.getCategory().toString());

        if (pluginEntity.getOptions() != null) {
            Set<OptionDto> optionDtos = new HashSet<>();
            for (OptionEntity optionEntity : pluginEntity.getOptions()) {
                OptionDto optionDto = new OptionDto();
                optionDto.setId(optionEntity.getId().toString());
                optionDto.setOption(optionEntity.getOption());
                optionDto.setDescription(optionEntity.getDescription());
                optionDtos.add(optionDto);
            }

            pluginDto.setOptions(optionDtos);
        }

        return pluginDto;
    }

    public List<PluginDto> toCollectionDto(List<PluginEntity> plugins) {
        return plugins.stream()
                .map(this::toDto)
                .toList();
    }
}
