package project.checkmovie.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long num;

    private String userId;
    private String password;
    private String userName;
    private int age;
    private String gender;
    private String email;

    @Builder
    public UserEntity(String userId, String password, String userName, int age, String gender, String email) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

}
