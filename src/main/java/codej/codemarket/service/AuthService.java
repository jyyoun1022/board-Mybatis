package codej.codemarket.service;

import codej.codemarket.domain.MemberDTO;
import codej.codemarket.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MemberMapper memberMapper;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final PasswordEncoder passwordEncoder;



    /**
     * 중복 닉네임 검증
     */
    @Transactional
    public void insDuplicateNickname(String nickname){
        validateDuplicatemember(nickname);
    }

    /**
     * 회원가입
     * @param memberDTO
     * @return 회원가입 카운트
     */
    @Transactional
    public int join(MemberDTO memberDTO){

        String rawPassword = memberDTO.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);
        memberDTO.setPassword(encPassword);

        int count = memberMapper.insert(memberDTO);
        log.info("정상 회원가입이 {}번 되었습니다.",count);

        return count;
    }

    /**
     *  전체 회원 조회
     */
    public List<MemberDTO> findAllMembers(){
        List<MemberDTO> findMembers = memberMapper.findAll();
        return findMembers;

    }

    private void validateDuplicatemember(String nickname){
        MemberDTO findMember = memberMapper.findByNickname(nickname);
        if(findMember != null){
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
    }
}
