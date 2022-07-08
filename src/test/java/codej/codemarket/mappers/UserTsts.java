package codej.codemarket.mappers;

import codej.codemarket.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class UserTsts {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void saveTestUser(){

         String email = "test@naver.com";
        User user = User.builder()
                .password(passwordEncoder.encode("test"))
                .email("test@naver.com")
                .role("ROLE_ADMIN")
                .active("1")
                .build();

        userMapper.insertUser(user);


        System.out.println("======");
        System.out.println(user.getEmail());


    }
}
