package web.Model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "surName")
    private String surName;

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Long getId() {
        return id;
    }
}
