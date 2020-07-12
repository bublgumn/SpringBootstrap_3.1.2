package org.springBootA.springBoot.repository;

import org.springBootA.springBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
   User findByFirstname(String username);

   User findByEmail(String email);

   @Transactional
   @Modifying
   @Query("delete from User u where u.id = ?1")
   void deleteById(Long aLong);
}
