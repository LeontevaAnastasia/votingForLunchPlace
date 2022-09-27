package com.votingforlunch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@Data
public class User extends AbstractNamedEntity {

   public User(Integer id, String name, String email, String password,  boolean enabled, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }
    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
        this(id, name, email, password, true, EnumSet.of(role, roles));
    }

    private String email;

    private String lastName;

    private String password;

    private boolean enabled = true;

    private Date registered = new Date();

    private Set<Role> roles;
    }

