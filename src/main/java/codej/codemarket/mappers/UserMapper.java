package codej.codemarket.mappers;

import codej.codemarket.blog.ReqJoinDto;
import codej.codemarket.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

   int save(ReqJoinDto dto);
   int findByUsername(String username);

}
