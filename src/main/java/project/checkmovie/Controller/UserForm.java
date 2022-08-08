package project.checkmovie.Controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class UserForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    private String id;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String pwd;

    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

    @NotEmpty(message = "나이는 필수항목입니다.")
    private int age;

    @NotEmpty(message = "성별은 필수항목입니다.")
    private String gender;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;

}
