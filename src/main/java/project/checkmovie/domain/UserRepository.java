package project.checkmovie.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    Optional<UserEntity> findByUserId(String userId);
    Optional<UserEntity> findByUserName(String userName);
}