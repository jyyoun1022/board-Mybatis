package codej.codemarket.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttachDTO extends CommonDTO{


    /* 파일 번호 Long idx */
    private Long idx;

    private Long boardIdx;

    private String originalName;

    private String saveName;

    private long size;

}
