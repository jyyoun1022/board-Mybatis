package codej.codemarket.mappers;

import codej.codemarket.domain.AttachDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttachMapper {

    int insertAttach(List<AttachDTO>attachDTOList);

    AttachDTO selectAttachDetail(Long idx);

    int deleteAttach(Long boardIdx);

    List<AttachDTO> selectAttachList(Long boardIdx);

    int selectAttachTotalCount(Long boardIdx);
}
