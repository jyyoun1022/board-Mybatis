package codej.codemarket.mappers;

import codej.codemarket.domain.Notice;
import codej.codemarket.domain.NoticeResultDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {

    void  save(Notice notice);


}
