package project.checkmovie.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //회원 생성
    UserEntity save(UserEntity userEntity);

    //id로 회원검색
    Optional<UserEntity> findById(String id);
//    UserEntity findByUSerId(String userId){
//        return
//    }

    //name 으로 회원 검색
    Optional<UserEntity> findByName(String name);

    //회원 모두 출력
    List<UserEntity> findAll();

}
