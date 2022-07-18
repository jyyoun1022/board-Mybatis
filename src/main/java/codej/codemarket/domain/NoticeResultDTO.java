package codej.codemarket.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeResultDTO {

    private Long memberId;

    private String text;

    private String link;

    public Notice toEntity(){
        return Notice.builder()
                .memberId(this.memberId)
                .text(this.text)
                .link(this.link)
                .build();

    }


}
