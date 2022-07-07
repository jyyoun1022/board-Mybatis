package codej.codemarket.domain;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO extends CommonDTO{

   private Long idx;
   private String title;
   private String content;
   private String writer;
   private int viewCnt;
   private String noticeYn;
   private String secretYn;
}
