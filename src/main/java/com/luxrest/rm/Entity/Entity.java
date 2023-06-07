package com.luxrest.rm.Entity;

import com.luxrest.rm.Token.Token;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@jakarta.persistence.Entity
@Table(name = "entities")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String email;

    private String phone;

    private String fiscalId;

    private String address;

    private String city;

    private String zipCode;

    private Boolean isActive = true;

    private Boolean isDeleted = false;

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    @OneToMany(mappedBy = "entity")
    private List<Token> tokens;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        if (this.isDeleted == null) {
            this.isDeleted = false;
        }
        if(this.isActive == null){
            this.isActive = true;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(entityType.name()));
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}