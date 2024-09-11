package org.virtualizat.one.plugin.entity;

import com.sun.source.util.Plugin;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.virtualizat.one.plugin.entity.emun.Category;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "plugin", schema="app")
public class PluginEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 36)
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="version")
    private String version;

    @Column(name="description")
    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(
            mappedBy = "plugin",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<OptionEntity> options;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PluginEntity that = (PluginEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(version, that.version) && Objects.equals(description, that.description) && category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version, description, category);
    }
}
