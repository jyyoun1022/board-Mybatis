package codej.codemarket.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachDTO extends CommonDTO{


    /* 파일 번호 Long idx */
    private Long idx;

    private Long boardIdx;

    private String originalName;

    private String saveName;

    private long size;

}
