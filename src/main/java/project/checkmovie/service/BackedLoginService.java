package project.checkmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.checkmovie.domain.UserEntity;
import project.checkmovie.domain.UserRepository;

import java.util.Arrays;

@Service
public class BackedLoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(userName).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 유저입니다."));
        //login issue 해결해야함.
        return new User(user.getUserId(), user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority(user.getUserId())));
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
