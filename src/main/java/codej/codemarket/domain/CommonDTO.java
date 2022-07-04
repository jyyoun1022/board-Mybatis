package codej.codemarket.domain;

import codej.codemarket.paging.Criteria;
import codej.codemarket.paging.PaginationInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommonDTO extends Criteria {

    private PaginationInfo paginationInfo;
    private String deleteYn;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
}
