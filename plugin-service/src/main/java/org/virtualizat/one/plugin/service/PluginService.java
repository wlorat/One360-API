package org.virtualizat.one.plugin.service;

import org.virtualizat.one.plugin.dto.PluginDto;

import java.util.List;

public interface PluginService {
    public ServiceResponse<PluginDto> createPlugin(PluginDto createPlugin);

    public ServiceResponse<PluginDto> updatePlugin(String id, PluginDto updatePlugin);
    public ServiceResponse<PluginDto> deletePlugin(String id);

    public ServiceResponse<List<PluginDto>> getPlugins();
    public ServiceResponse<PluginDto> getPlugin(String id);
}
