package com.example.sedes.Account;import java.util.Optional;import org.springframework.data.jpa.repository.JpaRepository;public interface AccountRepository extends JpaRepository<Account, Integer> {    Optional<Account> findByUsername(String username);    Optional<Account> findById(int id);    boolean existsByUsername(String username);    boolean existsByEmail(String email);}