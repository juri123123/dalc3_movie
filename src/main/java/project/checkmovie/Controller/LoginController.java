package project.checkmovie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.checkmovie.domain.UserEntity;
import project.checkmovie.domain.UserRepository;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/main")
    public String getMain() {
        return "main";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "loginPage";
    }
//임의로 회원가입
    @GetMapping("/signUp")
    public String signUp() {
        UserEntity user = UserEntity.builder()
                .userId("id1")
                .password(passwordEncoder.encode("psw1"))
                .userName("name1")
                .gender("F")
                .email("user@naver.com")
                .age(22)
                .build();

        userRepository.save(user);

        return "redirect:/login";
    }
}
