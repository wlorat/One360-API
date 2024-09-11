package org.virtualizat.one.plugin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.virtualizat.one.plugin.dto.APIResponse;
import org.virtualizat.one.plugin.dto.PluginDto;
import org.virtualizat.one.plugin.entity.OptionEntity;
import org.virtualizat.one.plugin.entity.PluginEntity;
import org.virtualizat.one.plugin.repository.OptionRepository;
import org.virtualizat.one.plugin.repository.PluginRepository;
import org.virtualizat.one.plugin.service.PluginService;
import org.virtualizat.one.plugin.service.ServiceResponse;

import java.sql.SQLException;

@RestController
@RequestMapping(value="/plugins")
public class PluginController {

    @Autowired
    PluginService pluginService;

    @PostMapping
    public ResponseEntity<?> createPlugin(@RequestBody PluginDto createPlugin){

        ServiceResponse<PluginDto> pluginDto = pluginService.createPlugin(createPlugin);

        APIResponse<PluginDto> responseDTO = APIResponse
                .<PluginDto>builder()
                .status(pluginDto.getMessageCode())
                .results(pluginDto.getEntity())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
