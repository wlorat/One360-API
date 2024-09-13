package org.virtualizat.one.auth.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.virtualizat.one.auth.entity.emun.State;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user", schema="app")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 36)
    private UUID id;

    @NotBlank
    @Column(name="username")
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "hashtag")
    private String hashtag;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;
}
