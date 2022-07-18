package codej.codemarket.service;

import codej.codemarket.blog.ReqJoinDto;
import codej.codemarket.blog.RespCM;
import codej.codemarket.blog.ReturnCode;
import codej.codemarket.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    @Transactional
    public int join(ReqJoinDto dto){
        try{
            int result = userMapper.findByUsername(dto.getUsername());

            if(result ==1){
                return ReturnCode.아이디중복;
            }else {
                return userMapper.save(dto);
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }


}
