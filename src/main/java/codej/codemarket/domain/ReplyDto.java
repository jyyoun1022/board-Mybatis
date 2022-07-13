package codej.codemarket.domain;

import lombok.Data;

@Data
public class ReplyDto {

    private String rno;
    private String bno;
    private String writer;
    private String deleteFlag;
    private String memo;
    private String regDate;
    private String parent;
    private String r_depth;
    private String r_order;
}
