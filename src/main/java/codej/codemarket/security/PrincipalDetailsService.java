package codej.codemarket.security;

import codej.codemarket.domain.MemberDTO;
import codej.codemarket.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    //1. 패스워드는 알아서 체킹하니까 신경 x
    //2. 리턴이 잘 되면 자동으로 UserDetails 타입으로 세션을 만듬
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberDTO memberDTO = memberMapper.findByEmail(username);
        System.out.println("memberDTO = " + memberDTO);

        if(memberDTO == null){
            return null;
        }else {
            return new PrincipalDetails(memberDTO);
        }
    }
}
