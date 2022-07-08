package codej.codemarket.mappers;

import codej.codemarket.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByEmail(String email);

}
