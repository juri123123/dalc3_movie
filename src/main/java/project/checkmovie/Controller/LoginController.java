package project.checkmovie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.checkmovie.domain.UserEntity;
import project.checkmovie.domain.UserRepository;
import project.checkmovie.service.BackedLoginService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BackedLoginService backedLoginService;

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
        return "04-login";
    }

    // 회원가입
    @GetMapping("/signUp")
    public String signUp(UserForm userForm) {
        return "05-signup";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid UserForm userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "05-signup";
        }
        backedLoginService.create(userForm.getId(), userForm.getPwd(), userForm.getName(), userForm.getAge()
        , userForm.getGender(), userForm.getEmail());

        return "redirect:/login";
    }

}
