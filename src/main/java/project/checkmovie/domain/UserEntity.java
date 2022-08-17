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

    @Column(unique = true)
    private String id;

    private String pwd;

    private String name;

    private int age;

    private String gender;

    @Column(unique = true)
    private String email;
}
