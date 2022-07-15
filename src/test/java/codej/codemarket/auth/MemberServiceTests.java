package codej.codemarket.auth;

import codej.codemarket.domain.MemberDTO;
import codej.codemarket.domain.MemberUpdateDTO;
import codej.codemarket.dto.SignupDTO;
import codej.codemarket.mappers.MemberMapper;
import codej.codemarket.service.AuthService;
import codej.codemarket.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@Transactional
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @DisplayName("회원정보 수정 테스트")
    public void test1() throws Exception{
        //given
        authService.join(createMember().toEntity());
        MemberDTO findMember = memberMapper.findByEmail("jyyoun1024@gmail.com");

        MemberDTO ex = updateMember().toEntity();
        System.out.println("=================");
        System.out.println("ex = " + ex);
        //when

        MemberDTO updateMember = memberService.memberUpdate(findMember);

        //then
        Assertions.assertThat(findMember.getInstaUrl()).isEqualTo(findMember.getInstaUrl());
    }

    SignupDTO createMember(){
        return SignupDTO.builder()
                .name("윤재열")
                .email("jyyoun1024@gmail.com")
                .nickname("successful!!")
                .password(passwordEncoder.encode("1111"))
                .phone("010-8491-2891")
                .university("인하공전")
                .build();
    }
    MemberUpdateDTO updateMember(){
        return MemberUpdateDTO.builder()
                .text("안녕하세요")
                .instaUrl("왜안바뀜")
                .twitterUrl("https://www.twitter.com/codej/abcd")
                .build();
    }


}
