package com.votingforlunch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"password"})
public class User extends AbstractBaseEntity{

    @Column(name = "name")
    @Size(max = 128)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty
    @Size(max = 128)
    private String email;

    @Column(name = "password")
    @Size(max = 256)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @NotNull
    private LocalDate registered;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
      this(id, name, email, password, true, EnumSet.of(role, roles));
     }
    public User(Integer id, String name, String email, String password,  boolean enabled, Set<Role> roles) {
        super(id);
        this.name=name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }
    public User( String name, String email, String password, LocalDate date, boolean enabled, Set<Role> roles) {
        this.name=name;
        this.email = email;
        this.password = password;
        this.registered = date;
        this.enabled=enabled;
        this.roles = roles;
    }
}

