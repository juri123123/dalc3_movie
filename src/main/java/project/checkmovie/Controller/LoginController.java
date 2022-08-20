package project.checkmovie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


//    @RequestMapping("/")
//    public String index(){
//        return "01-main-origin";
//    }
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/main")
    public String getMain() {
        return "01-main-origin";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "04-login";
    }

    // 회원가입
    @GetMapping("/signUp")
    public String signUp(UserForm userForm) {
        //임시로 디비에 정보 넣기
//        backedLoginService.create();
        return "04-1-signup";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute UserForm userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "04-1-signup";
        }
        try {
            backedLoginService.create(userForm.getId(), userForm.getPwd(), userForm.getName(), userForm.getAge()
                    , userForm.getGender(), userForm.getEmail());
//            backedLoginService.create();
        }catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "04-1-signup";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "04-1-signup";
        }

        return "redirect:/login";
    }

}
