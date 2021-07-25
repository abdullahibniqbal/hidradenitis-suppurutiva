package com.shady.hidradenitis.suppurutiva.auth;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Payload {
    @Id
    public String name;
    public String password;
}
