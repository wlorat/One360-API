package org.virtualizat.one.plugin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "option", schema="app")
public class OptionEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 36)
    private UUID id;

    @Column(name="option")
    private String option;

    @Column(name="description")
    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "plugin")
    private PluginEntity plugin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionEntity option = (OptionEntity) o;
        return id != null && id.equals(option.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
