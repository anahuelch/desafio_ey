package com.ey.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "user")
@Table(name = "\"user\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserId.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Id
    @Column(unique = true)
    private String email;

    private String password;

    private LocalDateTime creationTime = LocalDateTime.now();

    private LocalDateTime modificationTime;

    private LocalDateTime lastLogin = LocalDateTime.now();

    private boolean isActive;

    @OneToMany(targetEntity = Phone.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    private List<Phone> phones;

    public User(UUID id, String name, String email, LocalDateTime creationTime, LocalDateTime modificationTime, LocalDateTime lastLogin, boolean isActive){
        this.id = id;
        this.name = name;
        this.email = email;
        this.creationTime = creationTime;
        this.modificationTime = modificationTime;
        this.lastLogin = lastLogin;
        this.isActive = isActive;
    }

    public User(UUID id, String name, String email, String password, LocalDateTime creationTime, LocalDateTime modificationTime, LocalDateTime lastLogin, boolean isActive){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.creationTime = creationTime;
        this.modificationTime = modificationTime;
        this.lastLogin = lastLogin;
        this.isActive = isActive;
    }
}
