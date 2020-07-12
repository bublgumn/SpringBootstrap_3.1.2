package org.springBootA.springBoot.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "role" , cascade = CascadeType.ALL)
    private List<User> client;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getClient() {
        return client;
    }

    public void setClient(List<User> client) {
        this.client = client;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    public String printRole() {
        return getName().substring(5);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return name.trim().equals(role.name.trim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
