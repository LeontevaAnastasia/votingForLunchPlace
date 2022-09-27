package com.votingforlunch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled = true;

    private Date registered = new Date();

    private Set<Role> roles;
}
