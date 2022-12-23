package com.votingforlunch.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
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
    @Size(min = 4, max = 50)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Column(name = "registered", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE", updatable = false)
    @NotNull
    private LocalDate registered;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(){

    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getRegistered(), u.isEnabled(), u.getRoles());
    }

    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
      this(id, name, email, password, LocalDate.now(),true, EnumSet.of(role, roles));
     }
    public User(Integer id, String name, String email, String password, LocalDate registered, boolean enabled, Set<Role> roles) {
        super(id);
        this.name=name;
        this.email = email;
        this.password = password;
        this.registered = registered;
        this.enabled = enabled;
        this.roles=roles;
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

