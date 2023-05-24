package com.ey.desafio.repository;

import com.ey.desafio.model.User;
import com.ey.desafio.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UserId> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> findOneByEmail(String email);

    //Método que usamos para ocultar cierta información de los usuarios, para esto utilizamos una query directamente.
    @Query("SELECT new user(u.id, u.name, u.email, u.password, u.creationTime, u.modificationTime, u.lastLogin, u.isActive) FROM user u")
    List<User> findAllUsersWithoutPhones();
}
