package codej.codemarket.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice {

    private Long memberId;

    private String text;

    private String link;


}
