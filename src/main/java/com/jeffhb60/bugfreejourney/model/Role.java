package com.jeffhb60.bugfreejourney.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "roles")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Role {

    @Column(name = "role_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(length = 20, name = "role_name")
    @ToString.Exclude @Enumerated(EnumType.STRING)
    private AppRole roleName;

    public Role(AppRole roleName) {
        this.roleName = roleName;
    }
}
