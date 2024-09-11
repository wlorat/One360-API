package org.virtualizat.one.plugin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.virtualizat.one.plugin.entity.emun.Category;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PluginDto {

    private String id;
    private String name;
    private String version;
    private String description;
    private String category;
    private Set<OptionDto> options;

}
