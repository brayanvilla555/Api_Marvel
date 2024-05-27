package com.app.marvel.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role implements GrantedAuthority{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @JsonIgnoreProperties("role")
    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Set<GrantedPermission> grantedPermission;

    @Override
    public String getAuthority() {
        if(name == null) return null;

        return "ROLE_"+name.name();
    }

    @Getter
    public static enum RoleEnum{
        ADMIN, MODERATOR, USER, EDITOR
    }


}
