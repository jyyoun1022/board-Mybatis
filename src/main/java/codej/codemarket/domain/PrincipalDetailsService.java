package codej.codemarket.domain;

import codej.codemarket.domain.PrincipalDetails;
import codej.codemarket.domain.User;
import codej.codemarket.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userMapper.findByEmail(email);
        if(user != null){
            return new PrincipalDetails(user);
        }
        return null;
    }
}
