package project.checkmovie.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String userId;

    private String password;

    @Column(unique = true)
    private String userName;

    private int age;

    private String gender;

    @Column(unique = true)
    private String email;
}
