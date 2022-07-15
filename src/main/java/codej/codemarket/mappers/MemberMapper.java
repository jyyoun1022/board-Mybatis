package codej.codemarket.mappers;

import codej.codemarket.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    MemberDTO findByNickname(String nickname);

    MemberDTO findByEmail(String email);

    int insert(MemberDTO memberDTO);

    List<MemberDTO> findAll();
}
