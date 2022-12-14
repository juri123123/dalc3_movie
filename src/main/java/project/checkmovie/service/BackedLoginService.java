package project.checkmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.checkmovie.domain.UserEntity;
import project.checkmovie.domain.UserRepository;

import java.util.Arrays;

@Service
public class BackedLoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity create(String id, String password, String userName, int age, String gender, String email) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(userName);
        user.setAge(age);
        user.setEmail(email);
        user.setGender(gender);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPwd(passwordEncoder.encode(password));
        this.userRepository.save(user);

        return user;
    }

//    public UserEntity create() {
//        UserEntity user2 = new UserEntity();
//        user2.setUserId("id1");
//        user2.setUserName("name1");
//        user2.setAge(23);
//        user2.setEmail("user@naver.com");
//        user2.setGender("F");
////        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        user2.setPassword("{noop}password1");
//        this.userRepository.save(user2);
//
//        return user2;
//    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        UserEntity user = userRepository.findByName(userName).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 유저입니다."));
        //login issue 해결해야함.
        return new User(user.getId(), user.getPwd(),
                Arrays.asList(new SimpleGrantedAuthority(user.getId())));
    }

    //현재 인증된 사용자의 정보 가져오기
//    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//    if (principal instanceof UserDetails) {
//        String username = ((UserDetails)principal).getUsername()
//    } else {
//        String username = principal.toString();
//    }
}
