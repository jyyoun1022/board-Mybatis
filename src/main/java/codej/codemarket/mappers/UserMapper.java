package codej.codemarket.mappers;

import codej.codemarket.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    User findByEmail(String email);

    int insertUser(User user);

    boolean existsByEmail(String email);

}
