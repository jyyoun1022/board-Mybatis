package codej.codemarket.mappers;

import codej.codemarket.domain.HobbyDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HobbyMapper {

    int insertHobby(HobbyDTO hobbyDTO);
}
