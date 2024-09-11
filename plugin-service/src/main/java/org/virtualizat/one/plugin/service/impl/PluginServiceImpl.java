package org.virtualizat.one.plugin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtualizat.one.plugin.dto.PluginDto;
import org.virtualizat.one.plugin.entity.PluginEntity;
import org.virtualizat.one.plugin.mapper.PluginMapper;
import org.virtualizat.one.plugin.repository.PluginRepository;
import org.virtualizat.one.plugin.service.PluginService;
import org.virtualizat.one.plugin.service.ServiceResponse;
import org.virtualizat.one.plugin.service.util.MessageCode;
import org.virtualizat.one.plugin.utils.ValueMapper;

import java.util.List;
import java.util.Optional;

@Service
public class PluginServiceImpl implements PluginService {

    @Autowired
    PluginRepository pluginRepository;
    @Autowired
    PluginMapper pluginMapper;

    @Override
    public ServiceResponse<PluginDto> createPlugin(PluginDto createPlugin) {

        try {
            PluginEntity newPlugin = pluginMapper.toEntity(createPlugin);

            Optional<PluginEntity> existingPlugin = pluginRepository.findByName(newPlugin.getName());


            if (existingPlugin.isPresent()) {
                return new ServiceResponseImpl<>(MessageCode.ALREADY_EXISTS, pluginMapper.toDto(existingPlugin.get()));
            } else {
                return new ServiceResponseImpl<>(MessageCode.CREATED, pluginMapper.toDto(pluginRepository.save(newPlugin)));
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public ServiceResponse<PluginDto> updatePlugin(String id, PluginDto updatePlugin) {
        return null;
    }

    @Override
    public ServiceResponse<PluginDto> deletePlugin(String id) {
        return null;
    }

    @Override
    public ServiceResponse<List<PluginDto>> getPlugins() {
        return null;
    }

    @Override
    public ServiceResponse<PluginDto> getPlugin(String id) {
        return null;
    }
}
