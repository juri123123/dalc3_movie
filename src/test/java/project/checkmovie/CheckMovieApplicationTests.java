package project.checkmovie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import project.checkmovie.domain.UserEntity;
import project.checkmovie.domain.UserRepository;

@SpringBootTest
class CheckMovieApplicationTests {

	private UserRepository userRepository;
	@Autowired
	public CheckMovieApplicationTests(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public
	@Test
	void signUp() {
		//user 저장
		UserEntity user3 = new UserEntity();
		user3.setUserId("id2");
		user3.setUserName("name2");
		user3.setAge(24);
		user3.setEmail("user2@naver.com");
		user3.setGender("G");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user3.setPassword("password2");
		this.userRepository.save(user3);

		UserEntity findMember = userRepository.findByUserId(user3.getUserId()).get();
		Assertions.assertEquals(user3.getUserName(), findMember.getUserName());
	}

}
