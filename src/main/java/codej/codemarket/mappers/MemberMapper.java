package codej.codemarket.mappers;

import codej.codemarket.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    MemberDTO findByNickname(String nickname);

    MemberDTO findByEmail(String email);

    int insert(MemberDTO memberDTO);
}
