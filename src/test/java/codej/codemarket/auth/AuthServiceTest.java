package codej.codemarket.auth;

import codej.codemarket.domain.MemberDTO;
import codej.codemarket.dto.SignupDTO;
import codej.codemarket.mappers.MemberMapper;
import codej.codemarket.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @DisplayName("중복닉네임 테스트")
    void test1(){
        //given
        SignupDTO memberEntityA = createSignUpDTO();
        String nickname ="memberNickname";

        //when
        int joinedMember = authService.join(memberEntityA.toEntity());
        MemberDTO memberA = memberMapper.findByNickname("memberNickname");

        //then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> authService.insDuplicateNickname(nickname));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

    @Test
    @DisplayName("회원가입 테스트")
    void test2(){
        //given
        SignupDTO memberEntityA = createSignUpDTO();
        //when
        MemberDTO memberDTO = memberEntityA.toEntity();
        int memberA = authService.join(memberDTO);
        MemberDTO memberB = memberMapper.findByNickname("memberNickname");


        //then
        assertThat(memberB.getName()).isEqualTo(memberEntityA.getName());

    }

    SignupDTO createSignUpDTO(){
        return SignupDTO.builder()
                .name("memberA")
                .email("member@codej.com")
                .nickname("memberNickname")
                .password("1111")
                .phone("010-0000-0000")
                .university("서강대학교")
                .build();
    }
}
